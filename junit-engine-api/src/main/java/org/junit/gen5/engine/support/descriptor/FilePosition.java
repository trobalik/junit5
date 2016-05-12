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

import java.io.Serializable;
import java.util.Objects;

import org.junit.gen5.commons.meta.API;

@API(Experimental)
public class FilePosition implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int line;
	private final int column;

	public FilePosition(int line, int column) {
		this.line = line;
		this.column = column;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("FilePosition{");
		sb.append("line=").append(line);
		sb.append(", column=").append(column);
		sb.append('}');
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		FilePosition that = (FilePosition) o;
		return line == that.line && column == that.column;
	}

	@Override
	public int hashCode() {
		return Objects.hash(line, column);
	}
}
