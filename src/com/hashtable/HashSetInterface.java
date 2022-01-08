package com.hashtable;

public interface HashSetInterface<T> {
	void add(T element);
	void remove(T element);
	boolean contains(T element);
	T[] values();
}
