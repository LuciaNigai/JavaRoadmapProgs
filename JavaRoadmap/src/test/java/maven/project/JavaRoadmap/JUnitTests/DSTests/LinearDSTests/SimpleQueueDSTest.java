package maven.project.JavaRoadmap.JUnitTests.DSTests.LinearDSTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import maven.project.JavaRoadmap.dsa.linearDS.queue.SimpleQueueDS;

class SimpleQueueDSTest {

	@Test
	void enqueueTest() {
		SimpleQueueDS queue = new SimpleQueueDS();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.display();
		
		assertEquals(10, queue.peek());
		assertEquals(queue.peek(), queue.getHead().getData());
//		assertEquals(20, queue.getNext(queue.getHead()).getData());
		assertEquals(20, queue.getHead().getNext().getData());
	}
	
	@Test
	void dequeueTest() {
		SimpleQueueDS queue = new SimpleQueueDS();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.display();
		
		assertEquals(10, queue.dequeue());
		assertEquals(20, queue.peek());
		assertEquals(queue.getHead().getData(), queue.peek());
	}
	
	@Test
	void sizeTest() {
		SimpleQueueDS queue = new SimpleQueueDS();
		assertThrows(NoSuchElementException.class, ()->queue.size());
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.display();
		
		assertEquals(3, queue.size());
		queue.dequeue();
		assertEquals(2, queue.size());
	}
	
	@Test
	void isEmptyTest() {
		SimpleQueueDS queue = new SimpleQueueDS();
		assertEquals(true, queue.isEmpty());
		queue.enqueue(11);
		assertEquals(false, queue.isEmpty());
	}

}
