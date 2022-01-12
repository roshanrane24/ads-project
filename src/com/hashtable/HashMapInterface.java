package com.hashtable;

public interface HashMapInterface<K extends Comparable<K>, V> {
	void put(K key, V value);

	V get(K key);

	V remove(K key);

	V[] values();

	K[] keys();

	int size();
}
