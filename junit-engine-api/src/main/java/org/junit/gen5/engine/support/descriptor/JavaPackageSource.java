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

import java.util.Objects;

import org.junit.gen5.commons.meta.API;

@API(Experimental)
public class JavaPackageSource implements JavaSource {
	private static final long serialVersionUID = 1L;

	private final String packageName;

	public JavaPackageSource(Package javaPackage) {
		this.packageName = javaPackage.getName();
	}

	public String getPackageName() {
		return packageName;
	}

	@Override
	public String toString() {
		return getPackageName();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		JavaPackageSource that = (JavaPackageSource) o;
		return Objects.equals(packageName, that.packageName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(packageName);
	}
}
