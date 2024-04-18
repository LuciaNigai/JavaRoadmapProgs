package maven.project.JavaRoadmap.dsa.linearDS.linkedList;

import java.util.NoSuchElementException;

import maven.project.JavaRoadmap.dsa.linearDS.DoubleNode;

/**
 * Class that implements the doubly liked list.
 * @version 1.0
 * @since 2024-04-16
 */
public class DoublyLinkedListDS {

	private DoubleNode head;
	private DoubleNode tail;
	/**
	 * Head accessor method.
	 * @return list head.
	 */
	public DoubleNode getHead() {
		return head;
	}

	/**
	 * Tail accessor method.
	 * @return list tail.
	 */
	public DoubleNode getTail() {
		return tail;
	}


	/**
	 * Method inserts a node to the end of the list.
	 * @param data The node data to insert.
	 */
	public void insertDoubleNode(int data) {
		DoubleNode newNode = new DoubleNode(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
//			tail.next = newNode;
			tail.setNext(newNode);
//			newNode.previous = tail;
			newNode.setPrevious(tail);
//			newNode.next = null;
			newNode.setNext(null);
			tail = newNode;
		}
	}

	/**
	 * Method inserts the node as the head of the list.
	 * @param data The node data to insert.
	 */
	public void insertDoubleNodeBegin(int data) {
		DoubleNode newNode = new DoubleNode(data);
		if (head == null) {
			this.insertDoubleNode(data);
		} else {
//			newNode.next = head;
			newNode.setNext(head);
//			head.previous = newNode;
			head.setPrevious(newNode);
//			newNode.previous = null;
			newNode.setPrevious(null);
			head = newNode;
		}
	}

	/**
	 * Method inserts the node after the specified node.
	 * @param dataAfter The node data after which to insert the new node.
	 * @param data The new node data.
	 */
	public void insertDoubleNodeAfter(int dataAfter, int data) {
		if (head == null) {
			throw new NoSuchElementException("List is empty");
		} else {
			DoubleNode temp = head;
			while (temp != null && temp.getData() != dataAfter) {
//				temp = temp.next;
				temp=temp.getNext();
			}
			if (temp == null) {
				throw new NoSuchElementException("The element wa snot found");
			} else {
				if (temp == tail) {
					insertDoubleNode(data);
				} else {
					DoubleNode node = new DoubleNode(data);
//					node.next = temp.next;
					node.setNext(temp.getNext());
//					node.previous = temp;
					node.setPrevious(temp);
//					temp.next.previous = node;
					node.getNext().setPrevious(node);
//					temp.next = node;
					temp.setNext(node);
				}
			}
		}
	}

	/**
	 * Method deletes the node from the end of the list.
	 */
	public void deleteDoubleNode() {
		if (head == null) {
			throw new NoSuchElementException("List is empty");
		}
		if (tail == head) {
			head = tail = null;
		} else {
//			tail = tail.previous;
			tail=tail.getPrevious();
//			tail.next = null;
			tail.setNext(null);
		}
	}

	/**
	 * Method deleted the head of the list.
	 */
	public void deleteDoubleNodeBegin() {
		if (head == null) {
			throw new NoSuchElementException("The list is empty");
		} else {
			if (head.getNext() == null) {
				head = tail = null;
			} else {
//				DoubleNode temp = head.next;
				DoubleNode temp = head.getNext();
				head = temp;
//				head.previous = null;
				head.setPrevious(null);
			}
		}
	}

	/**
	 * Method deletes the node after the specified node.
	 * @param data The node data after which to delete the node.
	 */
	public void deleteDoubleNodeAfter(int data) {
		if (head == null) {
			throw new NoSuchElementException("This list is empty");
		} else {
			DoubleNode temp = this.head;
			while (temp != null && temp.getData() != data) {
//				temp = temp.next;
				temp=temp.getNext();
			}
			if (temp == null) {
				throw new NoSuchElementException("The element is not found");
			} else if (temp.getNext() == tail) {
				this.deleteDoubleNode();
			} else {
//				temp.next.next.previous = temp;
				temp.getNext().getNext().setPrevious(temp);
//				temp.next = temp.next.next;
				temp.setNext(temp.getNext().getNext());
			}
		}
	}
	
//	search 
	/**
	 * The method searches for the specified node in the list. 
	 * @param data The node data to be searched for.
	 * @return The node if found, else throws NoSuchElementException.
	 */
	public int searchDoubleNode(int data) {
		if(head==null) {
			throw new NoSuchElementException("The list is empty");
		}
		else {
			DoubleNode temp = head;
			while(temp!=null && temp.getData()!=data) {
//				temp=temp.next;
				temp=temp.getNext();
			}
			if(temp==null) {
				throw new NoSuchElementException("The element was not found");
			}
			else
				System.out.println("Node "+data+" was found" );
			return data;
		}
	}

	/**
	 * Method prints the list.
	 */
	public void printList() {
		if (head == null) {
			throw new NoSuchElementException("The list is empty");
		}
		DoubleNode temp = this.head;
		System.out.print("[");
		while (temp != tail) {
			System.out.print(temp.getData() + ", ");
//			temp = temp.next;
			temp=temp.getNext();
		}
		System.out.println(temp.getData() + "]");
	}

	/**
	 * Method prints the list in reverse.
	 */
	public void printListReverse() {
		if (head == null) {
			throw new NoSuchElementException("List is empty");
		} else {
			DoubleNode temp = tail;
			System.out.print("[");
			while (temp != head) {
				System.out.print(temp.getData() + ", ");
//				temp = temp.previous;
				temp=temp.getPrevious();
			}
			System.out.println(temp.getData() + "]");
		}
	}
}
