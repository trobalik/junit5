/*
 * Copyright 2015-2016 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.junit.gen5.engine.support.discovery;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.gen5.api.Assertions.assertEquals;
import static org.junit.gen5.api.Assertions.assertFalse;
import static org.junit.gen5.api.Assertions.assertThrows;
import static org.junit.gen5.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.gen5.api.Test;
import org.junit.gen5.commons.util.PreconditionViolationException;
import org.junit.gen5.engine.support.descriptor.DirectorySource;
import org.junit.gen5.engine.support.descriptor.FilePosition;
import org.junit.gen5.engine.support.descriptor.FileSource;

class FileSystemSourceTests {

	@Test
	void nullSourceFileOrDirectoryYieldsException() {
		assertThrows(PreconditionViolationException.class, () -> {
			new FileSource(null);
		});
	}

	@Test
	void directory() {
		Path directoryPath = Paths.get(".");
		DirectorySource source = new DirectorySource(directoryPath);
		assertThat(source.getPath()).isEqualTo(directoryPath.toAbsolutePath());
		assertThat(source.toString()).isEqualTo(directoryPath.toAbsolutePath().toString());
	}

	@Test
	void fileWithoutPosition() throws Exception {
		Path filePath = Paths.get("test.txt");
		FileSource source = new FileSource(filePath);

		assertThat(source.getPath()).isEqualTo(filePath.toAbsolutePath());
		assertThat(source.getPosition()).isEmpty();
		assertThat(source.toString()).isEqualTo(filePath.toAbsolutePath().toString());
	}

	@Test
	void fileWithPosition() throws Exception {
		Path filePath = Paths.get("test.txt");
		FilePosition position = new FilePosition(42, 23);
		FileSource source = new FileSource(filePath, position);

		assertThat(source.getPath()).isEqualTo(filePath.toAbsolutePath());
		assertThat(source.getPosition()).hasValue(position);

		assertThat(source.toString()).isEqualTo(filePath.toAbsolutePath().toString() + " [42:23]");
	}

}
