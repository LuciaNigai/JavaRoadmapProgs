package maven.project.JavaRoadmap.dsa.linearDS;

public class SingularNode {
	private int data;
	private SingularNode next;
	
	public SingularNode(int data) {
		this.data=data;
		this.next=null;
	}
	
	public int getData() {
		return this.data;
	}
	
	public SingularNode getNext() {
		return this.next;
	}
	
	public void setNext(SingularNode node) {
		this.next=node;
	}
}
