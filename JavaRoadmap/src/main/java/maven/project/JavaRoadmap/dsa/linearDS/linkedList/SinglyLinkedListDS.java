package maven.project.JavaRoadmap.dsa.linearDS.linkedList;

import maven.project.JavaRoadmap.dsa.linearDS.SingularNode;

/**
 * Class implementation of the singly linked list.
 * 
 * @version 1.0
 * @since 2024-04-15
 */
public class SinglyLinkedListDS {
// We always save the link to the head of the list
	private SingularNode head;


	public SingularNode getHead() {
		return this.head;
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
		SingularNode node = new SingularNode(data);
//		node.nextNode = null;
		node.setNext(null);

		if (head == null) {
			this.head = node;
		} else {
			SingularNode last = this.head;
//			while (last.nextNode != null) {
			while(last.getNext()!=null) {
//				last = last.nextNode;
				last=last.getNext();
			}
//			last.nextNode = node;
			last.setNext(node);
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
		SingularNode node = new SingularNode(data);
		if (head == null) {
			this.head = node;
		} else {
//			node.nextNode = head;
			node.setNext(head);
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
		SingularNode node = new SingularNode(data);
		if (head == null) {
			this.head = node;
		} else {
			SingularNode temp = this.head;
			while (temp != null && temp.getData() != dataAfter) {
//				temp = temp.nextNode;
				temp=temp.getNext();
			}
			if (temp == null) {
				throw new IllegalArgumentException("Node with data " + dataAfter + " not found");
			}
//			node.nextNode = temp.nextNode;
			node.setNext(temp.getNext());
//			temp.nextNode = node;
			temp.setNext(node);
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
			SingularNode temp = this.head;
			while (temp.getNext().getNext() != null) {
//				temp = temp.nextNode;
				temp=temp.getNext();
			}
//			temp.nextNode = null;
			temp.setNext(null);
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
//			this.head = this.head.nextNode;
			this.head=this.head.getNext();
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
			SingularNode temp = this.head;
			while (temp != null && temp.getData() != beforeData) {
//				temp = temp.nextNode;
				temp=temp.getNext();
			}
			if (temp == null) {
				throw new IllegalArgumentException("Node with data " + beforeData + " not found");
			}
//			temp.nextNode = temp.nextNode.nextNode;
			temp.setNext(temp.getNext().getNext());
		}
		return this;
	}

	/**
	 * Method traverses a linked list.
	 */
	public void printList() {
		SingularNode go = this.head;
		System.out.print("[");
		while (go.getNext() != null) {
			System.out.print(go.getData() + " ");
//			go = go.nextNode;
			go=go.getNext();
		}
		System.out.println(go.getData() + "]");
	}

//													SEARCHING
	public int findNode(int nodeData) {
		if (this.head == null) {
			throw new IllegalArgumentException("The list is empty");
		} else {
			SingularNode temp = this.head;
			while (temp != null && temp.getData() != nodeData) {
//				temp = temp.nextNode;
				temp=temp.getNext();
			}

			if (temp == null) {
				throw new IllegalArgumentException("Node with data " + nodeData + " not found");
			}
			System.out.println("Node "+temp.getData()+" is found");
			return temp.getData();

		}
	}
	
//									SORTING

}
