package maven.project.JavaRoadmap.dsa.linearDS;

import java.util.NoSuchElementException;

/**
 * Class implements the circular doubly linked list.
 * @version 1.0
 * @since 2024-04-17
 */
public class CircularDoublyLinkedListDS {
	
	private CircularDoublyNode head;
	private CircularDoublyNode tail;
	
	/**
	 * Class represents the node of the circular doubly linked list.
	 */
	public class CircularDoublyNode{
		private int data;
		private CircularDoublyNode next;
		private CircularDoublyNode previous;
		
		public CircularDoublyNode(int data){
			this.data=data;
			next=null;
			previous=null;
		}
		
		/**
		 * Getter method treturns node data.
		 * @return Node data.
		 */
		public int getData() {
			return data;
		}
		
	}
	
	/**
	 * Getter method returns node next to the current node.
	 * @param node Current node.
	 * @return Next to the current node.
	 */
	public CircularDoublyNode getNext(CircularDoublyNode node) {
		return node.next;
	}
	
	/**
	 * Getter method returns node previous to current node.
	 * @param node Current node.
	 * @return Node presious to curent node.
	 */
	public CircularDoublyNode getPrevious(CircularDoublyNode node) {
		return node.previous;
	}
	
	/**
	 * Getter method returns the list head.
	 * @return List head node.
	 */
	public CircularDoublyNode getHead() {
		return head;
	}
	
	/**
	 * Getter method returns the list tail node.
	 * @return List tail node.
	 */
	public CircularDoublyNode getTail() {
		return tail;
	}
	
	/**
	 * Method inserts new node to the end of the list.
	 * @param data New node data.
	 */
	public void insertNode(int data) {
		CircularDoublyNode node = new CircularDoublyNode(data);
		if(head==null) {
			head=tail=node;
			head.previous=tail;
			head.next=tail;
			tail.previous=head;
			tail.next=head;
		}
		else {
			node.next=head;
			node.previous=tail;
			tail.next=node;
			head.previous=node;
			tail=node;
		}
	}
	
	/**
	 * Method inserts new head node.
	 * @param data New head node data.
	 */
	public void insertHead(int data) {
		if(head==null) {
			this.insertNode(data);
		}
		else {
			CircularDoublyNode node = new CircularDoublyNode(data);
			node.next=head;
			node.previous=tail;
			head.previous=node;
			tail.next=node;
			head=node;
		}
	}
	
	/**
	 * Method inserts the node after the specified node.
	 * @param after The node data after which the node to be inserted.
	 * @param data The new node data to be inserted.
	 */
	public void insertAfter(int after, int data) {
		if(head==null) {
			throw new NoSuchElementException("The list is empty");
		}
		else {
			CircularDoublyNode temp = head;
			while(temp.next!=head && temp.getData()!=after) {
				temp=temp.next;
			}
			if(temp.next==head && temp.getData()==after) {
				this.insertNode(data);
				
			}
			else if(temp.next!=head && temp.getData()==after) {
				CircularDoublyNode node = new CircularDoublyNode(data);
				node.next=temp.next;
				node.previous=temp;
				temp.next.previous=node;
				temp.next=node;
			}
			else {
				throw new NoSuchElementException("The element was not found");
			}
		}
	}
	
	/**
	 * Method deletes the node from the end of the list.
	 */
	public void deleteNode() {
		if(head==null) {
			throw new NoSuchElementException("The list is empty");
		}
		else {
			if(head==tail) {
				head=tail=null;
			}
			else {
				head.previous=tail.previous;
				tail.previous.next=head;
				tail=head.previous;
			}
		}
	}
	
	/**
	 * Method deletes the head node of the list.
	 */
	public void deleteHead() {
		if(head==null) {
			throw new NoSuchElementException("The list is empty");
		}
		else if(head.next==null) {
			head=tail=null;
		}
		else {
			tail.next=tail.next.next;
			head.next.previous=tail;
			head=tail.next;
		}
	}
	
	/**
	 * Method deletes the node after specified node.
	 * @param after Node data after which the node to be deleted.
	 */
	public void deleteAfter(int after) {
		if(head==null) {
			throw new NoSuchElementException("The list is empty");
		}
		else {
			CircularDoublyNode temp = head;
			while(temp.next!=head && temp.getData()!=after) {
				temp=temp.next;
			}
			if(temp.next==head && temp.getData()==after) {
				this.deleteHead();
			}
			else if(temp.next==tail && temp.getData()==after) {
				this.deleteNode();
			}
			else if(temp.next!=head && temp.getData()==after) {
				temp.next=temp.next.next;
				temp.next.previous=temp;
			}
			else {
				throw new NoSuchElementException("The element was not found");
			}
		}
	}
	
	public int searchNode(int data) {
		if(head==null) {
			throw new NoSuchElementException("List is empty");
		}
		else {
			CircularDoublyNode temp = head;
			while(temp.next!=head && temp.getData()!=data) {
				temp=temp.next;
			}
			if(temp.getData()==data) {
				System.out.println("Node "+data+" was found");
				return data;
			}
			else {
				throw new NoSuchElementException("Element was not found");
			}
		}
	}
	
	/**
	 * Method prints the list.
	 */
	public void printList() {
		if(head==null) {
			throw new NoSuchElementException("The list is empty");
		}
		else {
			CircularDoublyNode temp = head;
			System.out.print("[");
			while(temp.next!=head) {
				System.out.print(temp.getData()+", ");
				temp=temp.next;
			}
			System.out.println(temp.getData()+"]");
		}
	}
	
	/**
	 * Method prints the list in reversed order.
	 */
	public void printListReverse() {
		if(head==null) {
			throw new NoSuchElementException("The list is empty");
		}
		else {
			CircularDoublyNode temp = tail;
			System.out.print("[");
			while(temp!=head) {
				System.out.print(temp.getData()+", ");
				temp=temp.previous;
			}
			System.out.println(temp.getData()+"]");
		}
	}

	public static void main(String[] args) {
		CircularDoublyLinkedListDS list = new CircularDoublyLinkedListDS();
		list.insertNode(10);
		list.insertNode(15);
		list.insertNode(20);
		
		System.out.println("List head "+list.getHead().getData());
		System.out.println("List tail "+list.getTail().getData());
		System.out.println("Tail.next "+list.getNext(list.getTail()).getData());
		list.printList();
		
		list.insertHead(5);
		System.out.println("List head "+list.getHead().getData());
		System.out.println("List tail "+list.getTail().getData());
		System.out.println("Tail.next "+list.getNext(list.getTail()).getData());
		list.printList();
		
		list.insertAfter(10, 12);
		list.insertAfter(20, 25);
		System.out.println("List head "+list.getHead().getData());
		System.out.println("List tail "+list.getTail().getData());
		System.out.println("Tail.next "+list.getNext(list.getTail()).getData());
		list.printList();
		list.printListReverse();
		
		list.deleteNode();
		System.out.println("List head "+list.getHead().getData());
		System.out.println("List tail "+list.getTail().getData());
		System.out.println("Tail.next "+list.getNext(list.getTail()).getData());
		list.printList();
		
		list.deleteHead();
		System.out.println("List head "+list.getHead().getData());
		System.out.println("List tail "+list.getTail().getData());
		System.out.println("Tail.next "+list.getNext(list.getTail()).getData());
		list.printList();
		
		list.deleteAfter(20);
		System.out.println("List head "+list.getHead().getData());
		System.out.println("List tail "+list.getTail().getData());
		System.out.println("Tail.next "+list.getNext(list.getTail()).getData());
		list.printList();
		
		list.deleteAfter(15);
		System.out.println("List head "+list.getHead().getData());
		System.out.println("List tail "+list.getTail().getData());
		System.out.println("Tail.next "+list.getNext(list.getTail()).getData());
		list.printList();
	}

}
