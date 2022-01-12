package com.hashtable;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.linked_list.LinkedListt;
import com.linked_list.SinglyLinkedListNode;

public class HashSett<T> implements HashSetInterface<T> {
	private ArrayList<LinkedListt<T>> holder;
	private int fixSize = 15;
	private int size = 0;

	public HashSett() {
		holder = new ArrayList<>(15);

		for (int i = 0; i < 15; i++) {
			holder.add(null);
		}
	}

	@Override
	public void add(T element) {
		// Adds an element to the hashset if the hashcode is different
		int bucketId = (element.hashCode()) % fixSize;
		LinkedListt<T> ll;
		SinglyLinkedListNode<T> current;
		ll = holder.get(bucketId);
		if (ll != null) {
			current = ll.getHead();
			while (current != null) {
				if (current.getData().hashCode() == element.hashCode()) {
					System.out.println("Duplicate entries detected");
					return;
				}
				current = current.getNext();
			}
			ll.add(element);
			size++;
		} else {
			holder.add(bucketId, new LinkedListt<>());
			holder.get(bucketId).add(element);
			size++;
		}

	}

	@Override
	public T remove(T element) {
		int bucketId = (element.hashCode()) % fixSize;
		LinkedListt<T> ll;
		ll = holder.get(bucketId);
		if (ll != null) {
			size--;
			return ll.remove(element);
		}
		return null;
	}

	@Override
	public boolean contains(T element) {
		int count;

		for (LinkedListt<T> ll : holder) {
			if (ll != null) {
				count = ll.getCount();
				for (int i = 0; i < count; i++) {
					if (ll.get(i).equals(element))
						return true;
				}
			}
		}

		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] values() {
		ArrayList<T> tempArray = new ArrayList<>(15);
		int count;
		for (LinkedListt<T> ll : holder) {
			if (ll != null) {
				count = ll.getCount();
				for (int i = 0; i < count; i++) {
					tempArray.add(ll.get(i));
				}
			}
		}

		T[] result = (T[]) Array.newInstance(tempArray.get(0).getClass(), tempArray.size());

		return tempArray.toArray(result);
	}

	@Override
	public int size() {
		return size;
	}

}
