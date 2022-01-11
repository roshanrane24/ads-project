package com.hashtable;

import java.util.ArrayList;

import com.linked_list.LinkedListt;
import com.linked_list.SinglyLinkedListNode;

public class HashSett<T> implements HashSetInterface<T> {
	private ArrayList<LinkedListt<T>> holder;
	private int fixSize = 15;
	private int size = 0;

	public HashSett() {
		holder = new ArrayList<>(15);
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
			while (ll.getHead() != null) {
				if (current.getData().hashCode() == element.hashCode()) {
					System.out.println("Duplicate entries detected");
					return;
				}
				current = current.getNext();
			}
			ll.add(element);
			size++;
		} else {
			ll = new LinkedListt<>();
			ll.add(element);
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
		// TODO Auto-generated method stub
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

		return (T[]) tempArray.toArray();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}
