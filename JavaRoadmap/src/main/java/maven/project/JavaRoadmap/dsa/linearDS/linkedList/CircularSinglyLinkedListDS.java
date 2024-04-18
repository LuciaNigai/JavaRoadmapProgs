package maven.project.JavaRoadmap.dsa.linearDS.linkedList;

import java.util.NoSuchElementException;

import maven.project.JavaRoadmap.dsa.linearDS.SingularNode;

/**
 * Class implements circular singly linked list.
 * @version 1.0
 * @since 2024-04-17
 */
public class CircularSinglyLinkedListDS {
	
	SingularNode head;
	/**
	 * Getter method returns list head.
	 * @return List head.
	 */
	public SingularNode getHead() {
		return this.head;
	}

	/**
	 * Method inserts the new node to the end of the list.
	 * @param data Node data to be inserted.
	 */
	public void insertNode(int data) {
		SingularNode node = new SingularNode(data);
		if(head==null) {
			head=node;
			head.setNext(head);
		}
		else {
			SingularNode temp = this.head;
			while(temp.getNext()!=head) {
				temp=temp.getNext();
			}
			node.setNext(head);
			temp.setNext(node);
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
			SingularNode node = new SingularNode(data);
			SingularNode temp = head;
			while(temp.getNext()!=head) {
				temp=temp.getNext();
			}
			node.setNext(head);
			temp.setNext(node);
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
			SingularNode temp=head;
			while(temp.getNext()!=head && temp.getData()!=after) {
				temp=temp.getNext();
			}
			if(temp.getNext()==head && temp.getData()==after) {
				this.insertNode(data);
			}
			else if(temp.getNext()!=head && temp.getData()==after) {
				SingularNode node = new SingularNode(data);
				node.setNext(temp.getNext());
				temp.setNext(node);
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
		else if(head.getNext()==null) {
			head=null;
		}
		else {
			SingularNode temp = head;
			while(temp.getNext().getNext()!=head) {
				temp=temp.getNext();
			}
			temp.setNext(head);
		}
	}
	
	/**
	 * Method deletes the head of the list.
	 */
	public void deleteHead() {
		if(head==null || head.getNext()==null) {
			this.deleteNode();
		}
		else {
			SingularNode temp = head;
			while(temp.getNext()!=head) {
				temp=temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
			head=temp.getNext();
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
			SingularNode temp = head;
			while(temp.getNext()!=head && temp.getData()!=after) {
				temp=temp.getNext();
			}
			if(temp.getNext()==head && temp.getData()==after) {
				this.deleteHead();
			}
			else if(temp.getNext()!=head && temp.getData()==after) {
				temp.setNext(temp.getNext().getNext());
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
			SingularNode temp=head;
			while(temp.getNext()!=head && temp.getData()!=data) {
				temp=temp.getNext();
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
			SingularNode temp = head;
			System.out.print("[");
			while(temp.getNext()!=head) {
				System.out.print(temp.getData()+", ");
				temp=temp.getNext();
			}
			System.out.println(temp.getData()+"]");
		}
	}

}
