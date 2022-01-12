package com.hashtable;

import java.lang.reflect.Array;

import com.linked_list.LinkedListInterface;
import com.linked_list.LinkedListt;

public class HashMap<T extends Comparable<T>, U> implements HashMapInterface<T, U> {

	// Data Node class
	private static class Node<T, U> {
		T key;
		U data;

		Node(T key, U data) {
			this.key = key;
			this.data = data;
		}

		@SuppressWarnings("unchecked")
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Node)
				return ((Node<T, U>) obj).key.equals(this.key);
			return false;
		}

	}

	private LinkedListInterface<Node<T, U>>[] buckets;
	private int count;
	private static final int ARRAY_SIZE = 15;

	@SuppressWarnings("unchecked")
	public HashMap() {
		buckets = (LinkedListt<Node<T, U>>[]) Array.newInstance(LinkedListt.class, ARRAY_SIZE);
		count = 0;
	}

	private static int hash(int key) {
		return key % ARRAY_SIZE;
	}

	@Override
	public void put(T key, U value) {
		// get bucket id
		int bId = hash(key.hashCode());

		// create LL if not exist
		if (buckets[bId] == null)
			buckets[bId] = new LinkedListt<>();

		// insert into LL
		for (int i = 0; i < buckets[bId].size(); i++) {
			Node<T, U> temp = buckets[bId].get(i);
			if (temp.key == key) {
				temp.data = value;
				return;
			}
		}

		// insert new data
		buckets[bId].add(new Node<T, U>(key, value));

		this.count++;
	}

	@Override
	public U get(T key) {
		// get bucket id
		int bId = hash(key.hashCode());

		// create LL if not exist
		if (buckets[bId] == null)
			return null;

		// Search for element with key
		for (int i = 0; i < buckets[bId].size(); i++) {
			Node<T, U> temp = buckets[bId].get(i);
			if (temp.key.equals(key))
				return temp.data;
		}

		return null;
	}

	@Override
	public U remove(T key) {
		// get bucket id
		int bId = hash(key.hashCode());

		// if not exist
		if (buckets[bId] == null)
			return null;

		Node<T, U> temp = buckets[bId].remove(new Node<T, U>(key, null));

		// if deleted return data
		if (temp != null) {
			this.count--;
			return temp.data;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public U[] values() {
		// create a temporary data array
		U[] temp = null;
		int index = 0;

		for (LinkedListInterface<Node<T, U>> u : buckets) {
			if (u != null) {
				if (temp == null)
					temp = (U[]) Array.newInstance(u.get(0).data.getClass(), this.count);
				for (int i = 0; i < u.size(); i++) {
					temp[index++] = u.get(i).data;
				}
			}
		}

		return temp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] keys() {
		// create a temporary data array
		T[] temp = null;
		int index = 0;

		for (LinkedListInterface<Node<T, U>> u : buckets) {
			if (u != null) {
				if (temp == null)
					temp = (T[]) Array.newInstance(u.get(0).key.getClass(), this.count);
				for (int i = 0; i < u.size(); i++) {
					temp[index++] = u.get(i).key;
				}
			}
		}

		return temp;
	}

	// get first element in first bucket
	public U getFirst() {
		U user = null;
		
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null) {
				U temp = buckets[i].get(0).data;
				
				if (temp != null) {
					user = temp;
					break;
				}
			}
		}
		
		return user;
	}

	@Override
	public int size() {
		return this.count;
	}

}
