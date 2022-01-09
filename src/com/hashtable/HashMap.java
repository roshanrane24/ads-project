package com.hashtable;

import com.linked_list.LinkedListInterface;

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
	
	public HashMap() {
		buckets = null; // TODO Setup Linked List instance
		count = 0;
	}

	private static int hash(int key) {
		return key % 10;
	}

	@Override
	public void put(T key, U value) {
		// get bucket id
		int bId = hash(key.hashCode());

		// create LL if not exist
		if (buckets[bId] == null)
			buckets[bId] = null; // TODO add instance of linked list

		// insert into LL
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

		// create bst if not exist
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

	@Override
	public U[] values() {
		// create a temporary data array
		@SuppressWarnings("unchecked")
		U[] temp = (U[]) new Object[this.count];
		int index = 0;

		for (LinkedListInterface<Node<T, U>> u : buckets) {
			if (u != null) {
				for (int i = 0; i < u.size(); i++) {
					temp[index++] = u.get(i).data;
				}
			}
		}

		return temp;
	}

}
