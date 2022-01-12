package com.linked_list;

public class SinglyLinkedListNode<T> {
	private T data;
	private SinglyLinkedListNode<T> next;

	public SinglyLinkedListNode(T data) {
		this.data = data;
		next = null;
	}

	public SinglyLinkedListNode<T> getNext() {
		return next;
	}

	public void setNext(SinglyLinkedListNode<T> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}

}
