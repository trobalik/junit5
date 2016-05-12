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
import java.util.Optional;

import org.junit.gen5.commons.meta.API;
import org.junit.gen5.commons.util.Preconditions;

@API(Experimental)
public class FileSource implements FileSystemSource {

	private static final long serialVersionUID = 1L;

	private final Path filePath;
	private final FilePosition positionInFile;

	public FileSource(Path filePath) {
		this(filePath, null);
	}

	public FileSource(Path filePath, FilePosition positionInFile) {
		this.filePath = Preconditions.notNull(filePath, "file path must not be null").toAbsolutePath();
		this.positionInFile = positionInFile;
	}

	@Override
	public Path getPath() {
		return filePath;
	}

	public Optional<FilePosition> getPosition() {
		return Optional.ofNullable(positionInFile);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(filePath.toString());
		getPosition().ifPresent(position -> {
			builder.append(" [");
			builder.append(position.getLine());
			builder.append(':');
			builder.append(position.getColumn());
			builder.append(']');
		});
		return builder.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		FileSource that = (FileSource) o;
		return Objects.equals(filePath, that.filePath) && Objects.equals(positionInFile, that.positionInFile);
	}

	@Override
	public int hashCode() {
		return Objects.hash(filePath, positionInFile);
	}
}
