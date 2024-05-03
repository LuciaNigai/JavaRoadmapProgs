package maven.project.JavaRoadmap.dsa.linearDS.queue;

import java.util.NoSuchElementException;

import maven.project.JavaRoadmap.dsa.linearDS.SingularNode;

/**
 * Class implements the input restricted deque
 * @version 1.0
 * @since 2024-04-19
 */
public class DequeueInputRestrictedDS {
	SingularNode front;
	SingularNode rear;
	
	/**
	 * Geter method returns queue's front.
	 * @return Queue's front node.
	 */
	public SingularNode getFront() {
		return this.front;
	}
	
	/**
	 * Getter method returns queue's rear.
	 * @return Queue's rear node.
	 */
	public SingularNode getRear() {
		return this.rear;
	}
	
	
	/**
	 * Adding element to the rear of the queue.
	 * @param data Element to enqueue;
	 */
	public void enqueue(int data) {
		SingularNode node = new SingularNode(data);
		if(front==null) {
			front=rear=node;
		}
		else {
			rear.setNext(node);
			rear=node;
		}
	}
	
	/**
	 * Dequeue element from the front of the deque.
	 * @return Dequeued node.
	 */
	public int dequeueFront() {
		if(front==null) {
			throw new NoSuchElementException("The queue is empty");
		}
		else {
			int data = front.getData();
			front=front.getNext();
			return data;
		}
	}
	
	/**
	 * Method dequeues element from the deque rear.
	 * @return Element from the deque rear.
	 */
	public int dequeueRear() {
		if(front==null) {
			throw new NoSuchElementException("The queue is empty");
		}
		else {
			SingularNode temp = front;
			while(temp.getNext()!=rear) {
				temp=temp.getNext();
			}
			int data = rear.getData();
			rear=temp;
			return data;
		}
	}
	
	/**
	 * Method returns the front element from deque without deleting it.
	 * @return Front element from the deque.
	 */
	public int peekFront() {
		if(front==null) {
			throw new NoSuchElementException("The queue is empty");
		}
		else {
			return front.getData();
		}
	}
	
	/**
	 * Method returns the rear element from deque without deleting it.
	 * @return Rear element from the dequeue.
	 */
	public int peekRear() {
		if(front==null) {
			throw new NoSuchElementException("The queue is empty");
		}
		else {
			return rear.getData();
		}
	}
	
	/**
	 * Method checks if the dequeue is or not.
	 * @return True if empty, otherwise false.
	 */
	public boolean isEmpty() {
		return front==null;
	}
	
	/**
	 * Method prints the deque.
	 */
	public void display() {
		if(front==null) {
			throw new NoSuchElementException("The queue is empty");
		}
		else {
			SingularNode temp = front;
			System.out.print("[");
			while(temp!=rear) {
				System.out.print(temp.getData()+", ");
				temp=temp.getNext();
			}
			System.out.println(temp.getData()+"]");
		}
	}
}
