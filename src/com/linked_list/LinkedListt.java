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
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.setNext(this.head);
			this.head = newNode;
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
		current = head;
		while (current != null) {
			if (count == i)
				break;
			count++;
			current = current.getNext();
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

		while (currentNode != null) {

			if (currentNode.getData().equals(element))
				break;
			previousNode = currentNode;
			currentNode = currentNode.getNext();
		}

		if (currentNode == null) {
			System.out.println("Element not found or List Empty");
			return null;
		}
		
		size--;

		if (currentNode == head) {
			if (this.head == this.tail) {
				this.head = null;
				this.tail = null;
				return currentNode.getData();
			}
			this.head = this.head.getNext();
			return currentNode.getData();
		}
		
		if  (currentNode == this.tail) {
			this.tail = previousNode;
			this.tail.setNext(null);
			return currentNode.getData();
		}
		
		previousNode.setNext(currentNode.getNext());
		return currentNode.getData();
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
