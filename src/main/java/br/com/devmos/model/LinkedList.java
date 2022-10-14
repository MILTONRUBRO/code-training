package br.com.devmos.model;

public class LinkedList<E> {
	
	Node<E> head;
	int size = 0;
	
	public void add(E element) {
		if(head == null) {
			head = new Node<>(element);
			size++;
			return;
		}
		
		Node<E> add = new Node<>(element);
		Node<E> temp = head;
		
		while(temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = add;
		size++;
	}
	
	public E getFirst() throws Exception {
		if(head == null) {
			throw new Exception("Elemento não encontrando na lista");
		}
		return head.data;
	}
	
	public E getLast() throws Exception {
		if(head == null) {
			throw new Exception("Elemento não encontrando na lista");
		}
		Node<E> temp = head;
		
		while(temp.next != null) {
			temp = temp.next;
		}
		
		return temp.data;
	}

}
