package maven.project.JavaRoadmap.dsa.linearDS;

import java.util.NoSuchElementException;

/**
 * Class implements stack DS.
 * @version 1.0
 * @since 2024-04-18
 */
public class StackDS {
	
	SingularNode head;
	/**
	 * Getter method returns stack head.
	 * @return Stack head.
	 */
	public SingularNode getHead() {
		return this.head;
	}
	/**
	 * Method pushes the data to the top of the stack;
	 * @param data Node data to be pushed.
	 */
	public void push(int data) {
		SingularNode node = new SingularNode(data);
		if(head==null) {
			head=node;
//			head.next=null;
			head.setNext(null);
		}
		else {
//			node.next=head;
			node.setNext(head);
			head=node;
		}
	}
	
	/**
	 * Method extracts the data from the top of the stack.
	 * @return The top element from the stack.
	 */
	public int pop() {
		if(head==null) {
			throw new NoSuchElementException("List is empty");
		}
		else {
			
			int data=head.getData();
//			head=head.next;
			head=head.getNext();
			return data;
		}
	}
	
	/**
	 * Method checks if the stack is empty.
	 * @return True is stack is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return head==null ? true : false;
	}
	
	/**
	 * Method returns the stack top element without removing it from the stack.
	 * @return Top element from the stack.
	 */
	public int peek() {
		if(head==null) {
			throw new NoSuchElementException("List is empty");
		}
		else {
			return head.getData();
		}
	}
	
	/**
	 * Method returns the size of the stack.
	 * @return Stack size.
	 */
	public int size() {
		if(head==null) {
			throw new NoSuchElementException("The list is empty");
		}
		else {
			int size=0;
			SingularNode temp = head;
			while(temp!=null) {
				size++;
//				temp=temp.next;
				temp=temp.getNext();
			}
			return size;
		}
	}
	
	/**
	 * Method displays the stack data.
	 */
	public void display() {
		if(head==null) {
			throw new NoSuchElementException("The list is empty.");
		}
		else {
			SingularNode temp = head;
			System.out.print("[");
			while(temp.getNext()!=null) {
				System.out.print(temp.getData()+", ");
//				temp=temp.next;
				temp=temp.getNext();
			}
			System.out.println(temp.getData()+"]");
		}
	}
}
