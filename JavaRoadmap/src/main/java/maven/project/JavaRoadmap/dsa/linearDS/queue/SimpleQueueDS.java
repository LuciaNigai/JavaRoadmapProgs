package maven.project.JavaRoadmap.dsa.linearDS.queue;

import java.util.NoSuchElementException;

import maven.project.JavaRoadmap.dsa.linearDS.SingularNode;

/**
 * Class implements the simple queue DS.
 * @version 1.0
 * @since 2024-04-18
 */
public class SimpleQueueDS {

	private SingularNode head;
	/**
	 * Getter method returns the stack head.
	 * @return Stack head.
	 */
	public SingularNode getHead() {
		return this.head;
	}
	
	
	/**
	 * Method checks if the queue is empty.
	 * @return True if stack is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return head==null ? true : false;
	}
	
	/**
	 * Method adds the element to the end of the queue.
	 * @param data Node data to enqueue.
	 */
	public void enqueue(int data) {
		SingularNode node = new SingularNode(data);
		if(head==null) {
			head=node;
		}
		else {
			SingularNode temp = head;
			while(temp.getNext()!=null) {
				temp=temp.getNext();
			}
			temp.setNext(node);
		}
		
	}
	
	/**
	 * Method returns the first element from the queue.
	 * @return First element from the stack.
	 */
	public int dequeue() {
		if(head==null) {
			throw new NoSuchElementException("the queue is empty");
		}
		else {
			int data = head.getData();
			head=head.getNext();
			return data;
		}
	}
	
	/**
	 * Method returns the first element from the queue without removing it.
	 * @return First element of the queue.
	 */
	public int peek() {
		if(head==null) {
			throw new NoSuchElementException("The queue is empty");
		}
		else {
			return head.getData();
		}
	}
	
	/**
	 * Method returns the queue size.
	 * @return Qeuue size.
	 */
	public int size() {
		if(head==null) {
			throw new NoSuchElementException("The queue is empty");
		}
		else {
			int size=0;
			SingularNode temp = head;
			while(temp!=null) {
				size++;
				temp=temp.getNext();
			}
			return size;
		}
	}
	
	/**
	 * Method displays the queue.
	 */
	public void display() {
		if(head==null) {
			throw new NoSuchElementException("The queue is empty");
		}
		else {
			SingularNode temp=head;
			System.out.print("[");
			while(temp.getNext()!=null) {
				System.out.print(temp.getData()+", ");
				temp=temp.getNext();
			}
			System.out.println(temp.getData()+"]");
		}
	}

}
