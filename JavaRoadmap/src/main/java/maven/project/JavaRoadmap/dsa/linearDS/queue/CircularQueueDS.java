package maven.project.JavaRoadmap.dsa.linearDS.queue;

import java.util.NoSuchElementException;

import maven.project.JavaRoadmap.dsa.linearDS.SingularNode;

/**
 * Class implements the Circular Queue DS.
 * @version 1.0
 * @since 2024-04-18
 */
public class CircularQueueDS {

	SingularNode front;
	SingularNode rear;
	int capacity = 3;

	public SingularNode getFront() {
		return this.front;
	}

	public SingularNode getRear() {
		return this.rear;
	}

	public int size() {
		if (front == null) {
			return 0;
		} else {
			SingularNode temp = front;
			int size = 1;
			while (temp != rear) {
				size++;
				temp = temp.getNext();
			}
			return size;
		}
	}

	public void enqueue(int data) {
		if (this.size() == capacity) {
			throw new IllegalArgumentException("The queue reached its maximum capacity");
		} else {
			SingularNode node = new SingularNode(data);
			if (front == null) {
				front = node;
				rear = node;
				node.setNext(node);
			} else {
				node.setNext(rear.getNext());
				rear.setNext(node);
				rear = node;
			}
		}
	}

	public int dequeue() {
		if (front == null) {
			throw new NoSuchElementException("The queue is empty");
		} else {
			int data = front.getData();
			if (front == rear) {
				front = rear = null;
				return data;
			} else {
				rear.setNext(front.getNext());
				front=front.getNext();
				return data;
			}
		}
	}
	
	public int peek() {
		if (front == null) {
			throw new NoSuchElementException("The queue is empty");
		} else {
			return front.getData();
		}
	}
	
	public boolean isEmpty() {
		return front==null;
	}

	public void display() {
		if (front == null) {
			throw new IllegalArgumentException("The queue is empty");
		} else {
			SingularNode temp = front;
			System.out.print("[");
			while (temp != rear) {
				System.out.print(temp.getData() + ", ");
				temp = temp.getNext();
			}
			System.out.println(temp.getData() + "]");
		}
	}

	public static void main(String[] args) {

		CircularQueueDS queue = new CircularQueueDS();
		queue.enqueue(10);
		queue.enqueue(20);
		System.out.println(queue.getFront().getData());
		System.out.println(queue.getRear().getData());
		queue.display();
		queue.enqueue(30);
		queue.display();
		queue.dequeue();
		System.out.println(queue.getFront().getData());
		System.out.println(queue.getRear().getData());
		queue.display();
		queue.enqueue(100);
		queue.display();
		queue.dequeue();
		queue.display();
		System.out.println(queue.peek());
	}

}
