/*
 * Copyright 2015-2016 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.junit.gen5.engine.support.descriptor;

import static org.junit.gen5.commons.meta.API.Usage.Experimental;

import java.nio.file.Path;
import java.util.Objects;

import org.junit.gen5.commons.meta.API;
import org.junit.gen5.commons.util.Preconditions;

@API(Experimental)
public class DirectorySource implements FileSystemSource {

	private static final long serialVersionUID = 1L;

	private final Path directoryPath;

	public DirectorySource(Path directoryPath) {
		this.directoryPath = Preconditions.notNull(directoryPath, "directory path must not be null").toAbsolutePath();
	}

	@Override
	public Path getPath() {
		return directoryPath;
	}

	@Override
	public String toString() {
		return directoryPath.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		DirectorySource that = (DirectorySource) o;
		return Objects.equals(directoryPath, that.directoryPath);
	}

	@Override
	public int hashCode() {
		return Objects.hash(directoryPath);
	}
}
