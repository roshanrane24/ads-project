package com.hashtable;

public interface HashMapInterface<K extends Comparable<K>, V> {
	public void put(K key, V value);
	public V get(K key);
	public V remove(K key);
	public V[] values();
}
