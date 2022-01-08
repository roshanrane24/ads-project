package com.hashmap;

public interface HashMapInterface<T extends Comparable<T>, U> {
	public void put(T key, U value);
	public U get(T key);
	public U remove(T key);
}
