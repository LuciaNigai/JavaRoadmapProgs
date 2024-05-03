package maven.project.JavaRoadmap.dsa.non_linearDS.tree;

public class MaxHeapDS {

	private int[] heap;
	private int capacity;
	private int size;
	
	
	public MaxHeapDS(int capacity) {
		this.capacity=capacity;
		this.size=0;
		this.heap=new int[capacity];
	}
	
	private int getParent(int i) {
		return (i-1)/2;
	}
	
	private int getLeftChild(int i) {
		return 2*i+1;
	}
	
	private int getRightChild(int i) {
		return 2*i+2;
	}
	
	public void swap(int i, int j) {
		int temp = heap[i];
		heap[i]=heap[j];
		heap[j]=temp;
	}
	
	private void heapifyDown(int i) {
		int largest = i;
		int left = getLeftChild(i);
		int right = getRightChild(i);
		
		if(left<size && heap[left]>heap[largest]) {
			largest =left;
		}
		
		if(right<size && heap[right]>heap[largest]) {
			largest = right;
		}
		if(largest!=i) {
			swap(i, largest);
			heapifyDown(largest);
		}
	}
	
	private void heapifyUp(int i) {
		while(i>0 && heap[i]> heap[getParent(i)]) {
			int parent = getParent(i);
			swap(i, parent);
			i=parent;
		}
	}
	
	public void insert(int value) {
		if(size==capacity) {
			System.out.println("Heap si full.");
			return;
		}
		heap[size]=value;
		size++;
		heapifyUp(size-1);
	}
	
	public int extractMax() {
		if(size == 0) {
			System.out.println("Heap is empty.");
			return -1;
		}
		int max = heap[0];
		heap[0]=heap[size-1];
		size--;
		heapifyDown(0);
		return max;
	}
	
	public void printHeap() {
		System.out.println("Heap elements");
		for(int i=0; i<size; i++) {
			System.out.print(heap[i]+", ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		MaxHeapDS maxHeap = new MaxHeapDS(10);
		maxHeap.insert(10);
		maxHeap.insert(22);
		maxHeap.insert(12);
		maxHeap.insert(9);
		maxHeap.insert(19);
		maxHeap.insert(54);
		
		maxHeap.printHeap();
		System.out.println(maxHeap.extractMax());
		maxHeap.printHeap();
	}

}
