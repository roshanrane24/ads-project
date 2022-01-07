package com.linked_list;

public interface LinkedListInterface<T> {
	public void add(T element);

	public void add(T element, int i);

	public void get(int i);

	public T remove(int i);

	public int size();
}
