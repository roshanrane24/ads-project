package com.array_list;

public interface ArrayListInterface<T> {
	public void add(T element);

	public void add(T element, int index);

	public T remove(int index);

	public T get(int index);

	public int size();
}
