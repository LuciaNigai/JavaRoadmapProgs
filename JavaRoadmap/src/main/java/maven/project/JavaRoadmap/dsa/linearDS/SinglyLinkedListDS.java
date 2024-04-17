package maven.project.JavaRoadmap.dsa.linearDS;

/**
 * Class implementation of the singly linked list.
 * 
 * @version 1.0
 * @since 2024-04-15
 */
public class SinglyLinkedListDS {
// We always save the link to the head of the list
	private Node head;

	/**
	 * Class that represents a node of the list, stores data and the link to the
	 * next node.
	 */
	public static class Node {
		private int data;
		private Node nextNode;

		public Node(int val) {
			this.data = val;
			nextNode = null;
		}

		public int getData() {
			return this.data;
		}
	}

	public Node getHead() {
		return this.head;
	}

	public Node getNextNode(Node node) {
		return node.nextNode;
	}
//												INSERTION TO THE LIST (END, BEGINING, AFTER SPECIFIED ELEMENT)

	/**
	 * Method adds a node to the end of the list.
	 * 
	 * @param list List that we add the node to.
	 * @param data The data that we want to add.
	 * @return The list with the newly inserted node.
	 */
	public SinglyLinkedListDS insertNode(int data) {
		Node node = new Node(data);
		node.nextNode = null;

		if (head == null) {
			this.head = node;
		} else {
			Node last = this.head;
			while (last.nextNode != null) {
				last = last.nextNode;
			}
			last.nextNode = node;
		}

		return this;
	}

	/**
	 * Method adds a node as a new head of the list.
	 * 
	 * @param list The list that we want to add the element to.
	 * @param data The element we want to add.
	 * @return The ist with the new head inserted.
	 */
	public SinglyLinkedListDS insertNodeBegin(int data) {
		Node node = new Node(data);
		if (head == null) {
			this.head = node;
		} else {
			node.nextNode = head;
			head = node;
		}
		return this;
	}

	/**
	 * method inserts the element after the specified element.
	 * 
	 * @param list      The list to which the element is inserted.
	 * @param data      The element that is inserted.
	 * @param dataAfter The element after which the element will be inserted.
	 * @return The list with inserted element.
	 */
	public SinglyLinkedListDS insertNodeAfter(int data, int dataAfter) {
		Node node = new Node(data);
		if (head == null) {
			this.head = node;
		} else {
			Node temp = this.head;
			while (temp != null && temp.data != dataAfter) {
				temp = temp.nextNode;
			}
			if (temp == null) {
				throw new IllegalArgumentException("Node with data " + dataAfter + " not found");
			}
			node.nextNode = temp.nextNode;
			temp.nextNode = node;
		}
		return this;
	}

//												DELETION FROM THE LIST (END, BEGINING, AFTER SPECIFIED ELEMENT)

	/**
	 * Method deleted the element from the end of the list.
	 * 
	 * @return The list without the deleted element.
	 */
	public SinglyLinkedListDS deleteNode() {
		if (this.head == null) {
			throw new IllegalArgumentException("The list is empty");
		} else {
			Node temp = this.head;
			while (temp.nextNode.nextNode != null) {
				temp = temp.nextNode;
			}
			temp.nextNode = null;
		}
		return this;
	}

	/**
	 * Method deletes the head of the list.
	 * 
	 * @return The list wihtout the deleted element.
	 */
	public SinglyLinkedListDS deleteNodeHead() {
		if (this.head == null) {
			throw new IllegalArgumentException("The list is empty");
		} else {
			this.head = this.head.nextNode;
		}
		return this;
	}

	/**
	 * Method deletes the node after the specified node.
	 * 
	 * @param beforeData Node after which to delete the node.
	 * @return The list without the deleted node.
	 */
	public SinglyLinkedListDS deleteNodeAfter(int beforeData) {
		if (this.head == null) {
			throw new IllegalArgumentException("The list is empty");
		} else {
			Node temp = this.head;
			while (temp != null && temp.data != beforeData) {
				temp = temp.nextNode;
			}
			if (temp == null) {
				throw new IllegalArgumentException("Node with data " + beforeData + " not found");
			}
			temp.nextNode = temp.nextNode.nextNode;
		}
		return this;
	}

	/**
	 * Method traverses a linked list.
	 */
	public void printList() {
		Node go = this.head;
		System.out.print("[");
		while (go.nextNode != null) {
			System.out.print(go.data + " ");
			go = go.nextNode;
		}
		System.out.println(go.data + "]");
	}

//													SEARCHING
	public int findNode(int nodeData) {
		if (this.head == null) {
			throw new IllegalArgumentException("The list is empty");
		} else {
			Node temp = this.head;
			while (temp != null && temp.data != nodeData) {
				temp = temp.nextNode;
			}

			if (temp == null) {
				throw new IllegalArgumentException("Node with data " + nodeData + " not found");
			}
			System.out.println("Node "+temp.getData()+" is found");
			return temp.getData();

		}
	}
	
//									SORTING

	public static void main(String... args) {
		SinglyLinkedListDS list = new SinglyLinkedListDS();
		list.insertNode(12);
		list.insertNode(24);
		list.insertNode(48);
		System.out.print("List before insertions: ");
		list.printList();
		System.out.print("Inserting node 6 at the beggining: ");
		list.insertNodeBegin(6);
		list.printList();
		System.out.print("Inserting node 36 after 24: ");
		list.insertNodeAfter(36, 24);
		list.printList();
		System.out.print("Deleting node from the end: ");
		list.deleteNode();
		list.printList();
		System.out.print("Deleting the head of the list: ");
		list.deleteNodeHead();
		list.printList();
		System.out.print("Deleting node after 24: ");
		list.deleteNodeAfter(24);
		list.printList();
		System.out.print("Deleting node after 12: ");
		list.deleteNodeAfter(12);
		list.printList();
	}
}
