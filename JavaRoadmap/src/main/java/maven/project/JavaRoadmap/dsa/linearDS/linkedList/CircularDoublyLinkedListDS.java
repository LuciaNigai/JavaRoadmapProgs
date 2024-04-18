package maven.project.JavaRoadmap.dsa.linearDS.linkedList;

import java.util.NoSuchElementException;

import maven.project.JavaRoadmap.dsa.linearDS.DoubleNode;

/**
 * Class implements the circular doubly linked list.
 * @version 1.0
 * @since 2024-04-17
 */
public class CircularDoublyLinkedListDS {
	
	private DoubleNode head;
	private DoubleNode tail;
	
	/**
	 * Getter method returns the list head.
	 * @return List head node.
	 */
	public DoubleNode getHead() {
		return head;
	}
	
	/**
	 * Getter method returns the list tail node.
	 * @return List tail node.
	 */
	public DoubleNode getTail() {
		return tail;
	}
	
	/**
	 * Method inserts new node to the end of the list.
	 * @param data New node data.
	 */
	public void insertNode(int data) {
		DoubleNode node = new DoubleNode(data);
		if(head==null) {
			head=tail=node;
//			head.previous=tail;
			head.setPrevious(tail);
//			head.next=tail;
			head.setNext(tail);
//			tail.previous=head;
			tail.setPrevious(head);
//			tail.next=head;
			tail.setNext(head);
		}
		else {
//			node.next=head;
			node.setNext(head);
//			node.previous=tail;
			node.setPrevious(tail);
//			tail.next=node;
			tail.setNext(node);
//			head.previous=node;
			head.setPrevious(node);
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
			DoubleNode node = new DoubleNode(data);
//			node.next=head;
			node.setNext(head);
//			node.previous=tail;
			node.setPrevious(tail);
//			head.previous=node;
			head.setPrevious(node);
//			tail.next=node;
			tail.setNext(node);
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
			DoubleNode temp = head;
			while(temp.getNext()!=head && temp.getData()!=after) {
//				temp=temp.next;
				temp=temp.getNext();
			}
			if(temp.getNext()==head && temp.getData()==after) {
				this.insertNode(data);
				
			}
			else if(temp.getNext()!=head && temp.getData()==after) {
				DoubleNode node = new DoubleNode(data);
//				node.next=temp.next;
				node.setNext(temp.getNext());
//				node.previous=temp;
				node.setPrevious(temp);
//				temp.next.previous=node;
				temp.getNext().setPrevious(node);
//				temp.next=node;
				temp.setNext(node);
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
//				head.previous=tail.previous;
				head.setPrevious(tail.getPrevious());
//				tail.previous.next=head;
				tail.getPrevious().setNext(head);
//				tail=head.previous;
				tail=head.getPrevious();
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
		else if(head.getNext()==null) {
			head=tail=null;
		}
		else {
//			tail.next=tail.next.next;
			tail.setNext(tail.getNext().getNext());
//			head.next.previous=tail;
			head.getNext().setPrevious(tail);
//			head=tail.next;
			head=tail.getNext();
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
			DoubleNode temp = head;
			while(temp.getNext()!=head && temp.getData()!=after) {
//				temp=temp.next;
				temp=temp.getNext();
			}
			if(temp.getNext()==head && temp.getData()==after) {
				this.deleteHead();
			}
			else if(temp.getNext()==tail && temp.getData()==after) {
				this.deleteNode();
			}
			else if(temp.getNext()!=head && temp.getData()==after) {
//				temp.next=temp.next.next;
				temp.setNext(temp.getNext().getNext());
//				temp.next.previous=temp;
				temp.getNext().setPrevious(temp);
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
			DoubleNode temp = head;
			while(temp.getNext()!=head && temp.getData()!=data) {
//				temp=temp.next;
				temp=temp.getNext();
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
			DoubleNode temp = head;
			System.out.print("[");
			while(temp.getNext()!=head) {
				System.out.print(temp.getData()+", ");
//				temp=temp.next;
				temp=temp.getNext();
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
			DoubleNode temp = tail;
			System.out.print("[");
			while(temp!=head) {
				System.out.print(temp.getData()+", ");
//				temp=temp.previous;
				temp=temp.getPrevious();
			}
			System.out.println(temp.getData()+"]");
		}
	}
}
