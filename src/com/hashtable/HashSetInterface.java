package com.hashtable;

public interface HashSetInterface<T> {
	void add(T element);
	T remove(T element);
	boolean contains(T element);
	T[] values();
	int size();
}
