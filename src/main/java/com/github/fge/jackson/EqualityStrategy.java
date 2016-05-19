package com.github.fge.jackson;

import java.util.function.Predicate;

public abstract class EqualityStrategy<T> {
	protected abstract boolean doEquals(T a, T b);

	protected abstract int doHash(T t);

	public boolean equals(final T a, final T b) {
		if (a == b) {
			return true;
		}
		if (a == null || b == null) {
			return false;
		}

		return doEquals(a, b);
	}

	public Predicate<T> equalsTo(T target) {
		return t -> equals(target, t);
	}

	public int hash(T t) {
		if (t == null) {
			return 0;
		}
		return doHash(t);
	}
}
