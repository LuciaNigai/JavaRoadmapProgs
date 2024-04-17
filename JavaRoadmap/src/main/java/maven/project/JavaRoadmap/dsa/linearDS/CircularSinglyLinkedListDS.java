package maven.project.JavaRoadmap.dsa.linearDS;

import java.util.NoSuchElementException;

/**
 * Class implements circular singly linked list.
 * @version 1.0
 * @since 2024-04-17
 */
public class CircularSinglyLinkedListDS {
	
	CircularSinglyNode head;
	

	/**
	 * Class represents the circular singly linked list node.
	 */
	public static class CircularSinglyNode {
		private int data;
		private CircularSinglyNode next;

		public CircularSinglyNode(int val) {
			this.data = val;
			next = null;
		}

		/**
		 * Getter method returns node data.
		 * @return Node data.
		 */
		public int getData() {
			return this.data;
		}
	}

	/**
	 * Getter method returns list head.
	 * @return List head.
	 */
	public CircularSinglyNode getHead() {
		return this.head;
	}

	/**
	 * Getter method returns next node for specified node.
	 * @param node Current node.
	 * @return Node next to current.
	 */
	public CircularSinglyNode getNext(CircularSinglyNode node) {
		return node.next;
	}

	/**
	 * Method inserts the new node to the end of the list.
	 * @param data Node data to be inserted.
	 */
	public void insertNode(int data) {
		CircularSinglyNode node = new CircularSinglyNode(data);
		if(head==null) {
			head=node;
			head.next=head;
		}
		else {
			CircularSinglyNode temp = this.head;
			while(temp.next!=head) {
				temp=temp.next;
			}
			node.next=head;
			temp.next=node;
		}
	}
	
	/**
	 * Method inserts the new head to the list.
	 * @param data The head data to be inserted.
	 */
	public void insertNodeBegin(int data) {
		if(head==null) {
			this.insertNode(data);
		}
		else {
			CircularSinglyNode node = new CircularSinglyNode(data);
			CircularSinglyNode temp = head;
			while(temp.next!=head) {
				temp=temp.next;
			}
			node.next=head;
			temp.next=node;
			head=node;
		}
	}
	
	/**
	 * Method inserts new node after the specified node.
	 * @param after Node after which new node to be inserted.
	 * @param data The node data to be inserted.
	 */
	public void insertNodeAfter(int after, int data) {
		if(head==null) {
			throw new NoSuchElementException("List is empty");
		}
		else {
			CircularSinglyNode temp=head;
			while(temp.next!=head && temp.getData()!=after) {
				temp=temp.next;
			}
			if(temp.next==head && temp.getData()==after) {
				this.insertNode(data);
			}
			else if(temp.next!=head && temp.getData()==after) {
				CircularSinglyNode node = new CircularSinglyNode(data);
				node.next=temp.next;
				temp.next=node;
			}
			else {
				throw new NoSuchElementException("The element was not found");
			}
				
		}
	}
	
	/**
	 * Method deletes the node at the end of the list.
	 */
	public void deleteNode() {
		if(head==null) {
			throw new NoSuchElementException("The list is empty");
		}
		else if(head.next==null) {
			head=null;
		}
		else {
			CircularSinglyNode temp = head;
			while(temp.next.next!=head) {
				temp=temp.next;
			}
			temp.next=head;
		}
	}
	
	/**
	 * Method deletes the head of the list.
	 */
	public void deleteHead() {
		if(head==null || head.next==null) {
			this.deleteNode();
		}
		else {
			CircularSinglyNode temp = head;
			while(temp.next!=head) {
				temp=temp.next;
			}
			temp.next=temp.next.next;
			head=temp.next;
		}
	}
	
	/**
	 * Method deletes the node after the specified node. 
	 * @param after Node data after which to delete the node.
	 */
	public void deleteNodeAfter(int after) {
		if(head==null) {
			throw new NoSuchElementException("List is empty");
		}
		else {
			CircularSinglyNode temp = head;
			while(temp.next!=head && temp.getData()!=after) {
				temp=temp.next;
			}
			if(temp.next==head && temp.getData()==after) {
				this.deleteHead();
			}
			else if(temp.next!=head && temp.getData()==after) {
				temp.next=temp.next.next;
			}
			else {
				throw new NoSuchElementException("The element is not found");
			}
		}
		
	}
	
	/**
	 * Method searches for the specified node in the list.
	 * @param data The node data to be searched for.
	 * @return The node data if it is found, else NoSuchElementException.
	 */
	public int searchNode(int data) {
		if(head==null) {
			throw new NoSuchElementException("List is empty");
		}
		else {
			CircularSinglyNode temp=head;
			while(temp.next!=head && temp.getData()!=data) {
				temp=temp.next;
			}
			if(temp.getData()==data) {
				System.out.println("The element "+data +" was found");
				return data;
			}
			else {
				throw new NoSuchElementException("The element was not found");
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
			CircularSinglyNode temp = head;
			System.out.print("[");
			while(temp.next!=head) {
				System.out.print(temp.getData()+", ");
				temp=temp.next;
			}
			System.out.println(temp.getData()+"]");
		}
	}

}
