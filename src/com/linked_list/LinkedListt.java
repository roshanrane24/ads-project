package com.linked_list;

public class LinkedListt<T> implements LinkedListInterface<T> {
	private SinglyLinkedListNode<T> head, tail;
	private int size;

	public LinkedListt() {
		this.head = null;
		this.tail = null;
		size = 0;
	}

	public SinglyLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SinglyLinkedListNode<T> head) {
		this.head = head;
	}

	public SinglyLinkedListNode<T> getTail() {
		return tail;
	}

	public void setTail(SinglyLinkedListNode<T> tail) {
		this.tail = tail;
	}

	@Override
	public void add(T element) {
		SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(element);
		SinglyLinkedListNode<T> next;
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			next = head;
			newNode.setNext(next);
			head = newNode;
		}
		size++;
	}

	@Override
	public void add(T element, int i) {

	}

	@Override
	public T get(int i) {

		int count = 0;
		SinglyLinkedListNode<T> current;
		SinglyLinkedListNode<T> next = head.getNext();
		current = head;
		while (current != null) {
			if (count == i)
				break;
			count++;
			next = current.getNext();
			current = next;
		}
		if (current != null)
			return current.getData();
		return null;
	}

//	@Override
//	public T remove(int i) {
//		return null;
//
//	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public T remove(T element) {

		SinglyLinkedListNode<T> currentNode;
		SinglyLinkedListNode<T> previousNode;
		currentNode = head;
		previousNode = null;
		SinglyLinkedListNode<T> next = head.getNext();
		while (currentNode != null) {

			if (currentNode.getData().equals(element))
				break;
			previousNode = currentNode;
			next = currentNode.getNext();
			currentNode = next;
		}
		if (currentNode == null) {
			System.out.println("Element not found or List Empty");
			return null;
		}
		if (currentNode == head) {
			head = next;
			currentNode.setNext(null);
			return currentNode.getData();
		}
		if (currentNode.getData().equals(element)) {
			previousNode.setNext(currentNode.getNext());
			currentNode.setNext(null);
			return currentNode.getData();
		}
		System.out.println("ElementNotFound");
		return null;
	}

	public int getCount() {
		int count = 0;
		SinglyLinkedListNode<T> current;
		SinglyLinkedListNode<T> next;
		current = head;
		while (current != null) {
			++count;
			next = current.getNext();
			current = next;
		}

		return count;
	}

}
