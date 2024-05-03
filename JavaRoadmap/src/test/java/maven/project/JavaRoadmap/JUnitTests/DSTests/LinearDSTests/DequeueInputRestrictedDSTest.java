package maven.project.JavaRoadmap.JUnitTests.DSTests.LinearDSTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import maven.project.JavaRoadmap.dsa.linearDS.queue.DequeueInputRestrictedDS;

class DequeueInputRestrictedDSTest {

	@Test
	void enqueueTest() {
		DequeueInputRestrictedDS deque = new DequeueInputRestrictedDS();
		deque.enqueue(10);
		deque.enqueue(20);
		deque.enqueue(30);
		deque.display();
		assertEquals(10, deque.getFront().getData());
		assertEquals(20, deque.getFront().getNext().getData());
		assertEquals(30, deque.getRear().getData());
	}
	
	@Test
	void dequeueTest() {
		DequeueInputRestrictedDS deque = new DequeueInputRestrictedDS();
		deque.enqueue(10);
		deque.enqueue(20);
		deque.enqueue(30);
		
		assertEquals(10, deque.dequeueFront());
		assertEquals(20, deque.getFront().getData());
		assertEquals(30, deque.dequeueRear());
		assertEquals(20, deque.getFront().getData());
		assertEquals(20, deque.getRear().getData());
		deque.display();
	}
	
	@Test
	void peekTest() {
		DequeueInputRestrictedDS deque = new DequeueInputRestrictedDS();
		assertEquals(true, deque.isEmpty());
		deque.enqueue(10);
		deque.enqueue(20);
		deque.enqueue(30);
		
		assertEquals(false, deque.isEmpty());
		assertEquals(10, deque.peekFront());
		assertEquals(30, deque.peekRear());
	}

}
