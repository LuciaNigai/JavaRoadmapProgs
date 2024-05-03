package maven.project.JavaRoadmap.JUnitTests.DSTests.LinearDSTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import maven.project.JavaRoadmap.dsa.linearDS.queue.PriorityQueueDS;

class PriorityQueueDSTest {

	@Test
	void enqueueTest() {
		PriorityQueueDS queue = new PriorityQueueDS();
		queue.enqueue(10,"f");
		queue.enqueue(2,"a");
		queue.enqueue(20,"a");
		queue.enqueue(5,"k");
		
		assertEquals("2a", queue.getFront().getData()+queue.getFront().getLetter());
		assertEquals("5k", queue.getFront().getNext().getData()+queue.getFront().getNext().getLetter());
		
		queue.enqueue(2, "b");
		assertEquals("2b", queue.getFront().getNext().getData()+queue.getFront().getNext().getLetter());
		
	}
	
	@Test
	void dequeueTest() {
		PriorityQueueDS queue = new PriorityQueueDS();
		queue.enqueue(10,"f");
		queue.enqueue(2,"s");
		queue.enqueue(20,"a");
		queue.enqueue(5,"k");
		
		assertEquals("2 s", queue.dequeue());;
	}
	
	@Test
	void peekTest() {
		PriorityQueueDS queue = new PriorityQueueDS();
		queue.enqueue(10,"f");
		queue.enqueue(2,"s");
		queue.enqueue(20,"a");
		queue.enqueue(5,"k");
		
		assertEquals("2 s", queue.peek());
	}

}
