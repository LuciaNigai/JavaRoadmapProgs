package maven.project.JavaRoadmap.JUnitTests.DSTests.LinearDSTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import maven.project.JavaRoadmap.dsa.linearDS.queue.DequeOutputRestrictedDS;

class DequeOutputRestrictedDSTest {

	@Test
	void enqueTest() {
		DequeOutputRestrictedDS deque = new DequeOutputRestrictedDS();
		deque.enqueueFront(20);
		deque.enqueueRear(30);
		deque.enqueueFront(10);
		
		assertEquals(10, deque.getFront().getData());
		assertEquals(30, deque.getRear().getData());
		assertEquals(20, deque.getFront().getNext().getData());
	}
	
	@Test
	void dequeTest() {
		DequeOutputRestrictedDS deque = new DequeOutputRestrictedDS();
		deque.enqueueFront(20);
		deque.enqueueRear(30);
		deque.enqueueFront(10);
		
		assertEquals(30, deque.dequeue());
		assertEquals(20, deque.getRear().getData());
	}

	@Test
	void peekTest() {
		DequeOutputRestrictedDS deque = new DequeOutputRestrictedDS();
		assertEquals(true, deque.isEmpty());
		deque.enqueueFront(20);
		deque.enqueueRear(30);
		deque.enqueueFront(10);
		
		assertEquals(false, deque.isEmpty());
		assertEquals(10, deque.peekFront());
		assertEquals(30, deque.peekRear());
	}
}
