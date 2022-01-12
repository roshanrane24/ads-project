package com.linked_list;

public interface LinkedListInterface<T> {
	public void add(T element);

	public void add(T element, int i);

	public T get(int i);


	public T remove(T element);

	public int size();
}
