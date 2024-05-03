package maven.project.JavaRoadmap.dsa.linearDS.queue;

import java.util.NoSuchElementException;

/**
 * Class provides a simple implementation for priority queue.
 * I used letters to show that if the node has same value, the node that arives first gets the higher priority.
 * @version 1.0
 * @since 2024-22-04
 */
public class PriorityQueueDS {

	/**
	 * Class represents the priority queue node.
	 */
	public class PriorityQueueNode {
		private int data;
		private String letter;
		private PriorityQueueNode next;
		
		/**
		 * Class constructore creates new node.
		 * @param data Node data.
		 * @param letter Letter for demonstration.
		 */
		public PriorityQueueNode(int data, String letter) {
			this.data=data;
			this.letter=letter;
			this.next=null;
		}
		
		/**
		 *Getter method for node data.
		 * @return Node data.
		 */
		public int getData() {
			return this.data;
		}
		
		/**
		 * Getter method returns the node letter.
		 * @return Node letter.
		 */
		public String getLetter() {
			return letter;
		}
		/**
		 * Getter method returns the element after the current node.
		 * @return Node after the current.
		 */
		public PriorityQueueNode getNext() {
			return this.next;
		}
		
		/**
		 * Setter method  sets the node.next to the specified node.
		 * @param node  New node.
		 */
		public void setNext(PriorityQueueNode node) {
			this.next=node;
		}
	}
	
	PriorityQueueNode front;

	/**
	 * Gettter method returns queue's front node.
	 * @return Queue's front node.
	 */
	public PriorityQueueNode getFront() {
		return this.front;
	}

	/**
	 * Method enqueue's new node to the queue based on its priority.
	 * @param data New node data.
	 * @param letter New node letter.
	 */
	public void enqueue(int data, String letter) {
		PriorityQueueNode node = new PriorityQueueNode(data,letter);
		if (front == null) {
			front = node;
		} else {
			
			if (front.getData() > node.getData()) {
				node.setNext(front);
				front = node;
				return;
			}
			PriorityQueueNode after = front;
			while (after.getNext() != null && after.getNext().getData() <= node.getData()) {
				after = after.getNext();
			}
			if (after.getNext() == null) {
				after.setNext(node);
			} else {
				node.setNext(after.getNext());
				after.setNext(node);
			}
		}
	}

	/**
	 *Method dequeues the element from the front of the queue.
	 * @return
	 */
	public String dequeue() {
		if (front == null) {
			throw new NoSuchElementException("The queue is empty");
		} else {
			int data = front.getData();
			String letter = front.getLetter();
			front = front.getNext();
			return data+" "+letter;
		}
	}

	/**
	 * Method checks if the queue is emty.
	 * @return Truw if queue is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return front == null;
	}

	/**
	 * Returns the front element from the queue without removing it.
	 * @return Front element of the queue.
	 */
	public String peek() {
		if (front == null) {
			throw new NoSuchElementException("The queue is empty");
		} else {
			return front.getData()+" "+front.getLetter();
		}
	}

	/**
	 * Method displays the queue.
	 */
	public void display() {
		if (front == null) {
			throw new NoSuchElementException("The queue is empty.");
		} else {
			PriorityQueueNode temp = front;
			System.out.print("[");
			while (temp.getNext() != null) {
				System.out.print(temp.getData()+" "+temp.getLetter() + ", ");
				temp = temp.getNext();
			}
			System.out.println(temp.getData()+temp.getLetter() + "]");
		}
	}

}
