package maven.project.JavaRoadmap.dsa.linearDS.queue;

import java.util.NoSuchElementException;

import maven.project.JavaRoadmap.dsa.linearDS.SingularNode;
/**
 * Class implements output restricted deque
 * @version 1.0
 * @since 2024-04-2024
 */
public class DequeOutputRestrictedDS {
	SingularNode front;
	SingularNode rear;
	
	/**
	 * Getter method returns queue's front node.
	 * @return Front node.
	 */
	public SingularNode getFront() {
		return this.front;
	}
	
	/**
	 * Getter method returns queue's rear node.
	 * @return Rear node.
	 */
	public SingularNode getRear() {
		return this.rear;
	}
	/**
	 * Method inserts element to the front of the queue.
	 * @param data Element data to be inserted.
	 */
	public void enqueueFront(int data) {
		SingularNode node = new SingularNode(data);
		if(front==null) {
			front=rear=node;
		}
		else {
			node.setNext(front);
			front=node;
		}
	}
	
	/**
	 * Method inserts element to the rear of the queue.
	 * @param data Element data to be inserted.
	 */
	public void enqueueRear(int data) {
		if(front==null) {
			this.enqueueFront(data);
		}
		else {
			SingularNode node = new SingularNode(data);
			rear.setNext(node);
			rear=node;
		}
	}
	
	/**
	 * Method extracts node from the queue rear.
	 * @return Extracted node data.
	 */
	public int dequeue() {
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
	 * Method checks if the queue is empty.
	 * @return True if queue is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return front==null;
	}
	
	/**
	 * Method returns queue's front node data without removing it.
	 * @return Queue's front node data.
	 */
	public int peekFront() {
		if(front==null) {
			throw new NoSuchElementException("The queue is empty.");
		}
		else
		{
			return front.getData();
		}
	}
	
	/**
	 * Method returns queue's rear node data without removing it.
	 * @return Queue's rear node data.
	 */
	public int peekRear() {
		if(front==null) {
			throw new NoSuchElementException("Queue is empty.");
		}
		else {
			return rear.getData();
		}
	}
	
	
	/**
	 * Method displays the queue.
	 */
	public void display() {
		if(front==null) {
			throw new NoSuchElementException("The queue is empty");
		}
		else{
			SingularNode temp = front;
			System.out.print("[");
			while(temp!=rear) {
				System.out.print(temp.getData()+", ");
				temp=temp.getNext();
			}
			System.out.println(temp.getData()+"]");
		}
	}

	public static void main(String[] args) {
		DequeOutputRestrictedDS deque = new DequeOutputRestrictedDS();
		deque.enqueueFront(20);
		deque.enqueueRear(30);
		deque.enqueueFront(10);
		deque.display();
		deque.dequeue();
		deque.display();
		System.out.println(deque.isEmpty());
	}

}
