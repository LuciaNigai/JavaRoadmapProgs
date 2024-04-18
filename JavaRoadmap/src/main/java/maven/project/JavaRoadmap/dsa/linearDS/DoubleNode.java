package maven.project.JavaRoadmap.dsa.linearDS;

/**
 * Class representing the doubly linked list node.
 */
public class DoubleNode {
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
	
	public DoubleNode getPrevious() {
		return this.previous;
	}
	public DoubleNode getNext() {
		return this.next;
	}
	
	public void setNext(DoubleNode next) {
		this.next=next;
	}
	public void setPrevious(DoubleNode previous) {
		this.previous=previous;
	}
}