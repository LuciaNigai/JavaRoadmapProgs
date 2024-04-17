package maven.project.JavaRoadmap.dsa.linearDS;

import java.util.NoSuchElementException;

/**
 * Class that implements the doubly liked list.
 * @version 1.0
 * @since 2024-04-16
 */
public class DoublyLinkedListDS {

	private DoubleNode head;
	private DoubleNode tail;
	

	/**
	 * Class representing the doubly linked list node.
	 */
	public static class DoubleNode {
		private int data;
		private DoubleNode previous;
		private DoubleNode next;

		public DoubleNode(int data) {
			this.data = data;
			previous = null;
			next = null;
		}

		/**
		 * Data accessor method.
		 * @return node data.
		 */
		public int getData() {
			return data;
		}
	}

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
	 *Accessor method returns next node to the current.
	 * @param node Curent node.
	 * @return Next to current node.
	 */
	public DoubleNode getNext(DoubleNode node) {
		return node.next;
	}

	/**
	 * Accessor method returns the previous to current node.
	 * @param node Current node.
	 * @return Previous node.
	 */
	public DoubleNode getPrevious(DoubleNode node) {
		return node.previous;
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
			tail.next = newNode;
			newNode.previous = tail;
			newNode.next = null;
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
			newNode.next = head;
			head.previous = newNode;
			newNode.previous = null;
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
			while (temp != null && temp.data != dataAfter) {
				temp = temp.next;
			}
			if (temp == null) {
				throw new NoSuchElementException("The element wa snot found");
			} else {
				if (temp == tail) {
					insertDoubleNode(data);
				} else {
					DoubleNode node = new DoubleNode(data);
					node.next = temp.next;
					node.previous = temp;
					temp.next.previous = node;
					temp.next = node;
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
			tail = tail.previous;
			tail.next = null;
		}
	}

	/**
	 * Method deleted the head of the list.
	 */
	public void deleteDoubleNodeBegin() {
		if (head == null) {
			throw new NoSuchElementException("The list is empty");
		} else {
			if (head.next == null) {
				head = tail = null;
			} else {
				DoubleNode temp = head.next;
				head = temp;
				head.previous = null;
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
			while (temp != null && temp.data != data) {
				temp = temp.next;
			}
			if (temp == null) {
				throw new NoSuchElementException("The element is not found");
			} else if (temp.next == tail) {
				this.deleteDoubleNode();
			} else {
				temp.next.next.previous = temp;
				temp.next = temp.next.next;
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
			while(temp!=null && temp.data!=data) {
				temp=temp.next;
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
			temp = temp.next;
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
				temp = temp.previous;
			}
			System.out.println(temp.getData() + "]");
		}
	}
}
