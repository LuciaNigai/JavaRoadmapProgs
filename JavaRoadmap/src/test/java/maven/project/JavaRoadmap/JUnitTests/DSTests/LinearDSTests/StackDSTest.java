package maven.project.JavaRoadmap.JUnitTests.DSTests.LinearDSTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import maven.project.JavaRoadmap.dsa.linearDS.StackDS;

class StackDSTest {

	@Test
	void pushTest() {
		StackDS stack = new StackDS();
		stack.push(0);
		stack.push(3);
		stack.push(6);
		stack.display();
		
		assertEquals(6, stack.peek());
		assertEquals(3,stack.getHead().getNext().getData());
		assertEquals(6, stack.getHead().getData());
	}
	
	@Test 
	void peekTest() {
		StackDS stack = new StackDS();
		stack.push(0);
		stack.push(3);
		stack.push(6);
		stack.display();
		assertEquals(stack.getHead().getData(), stack.peek());
		stack.pop();
		assertEquals(stack.getHead().getData(), stack.peek());
	}
	
	@Test
	void popTest() {
		StackDS stack = new StackDS();
		assertThrows(NoSuchElementException.class, ()->stack.pop());
		stack.push(0);
		stack.push(3);
		stack.push(6);
		stack.display();
		
		stack.pop();
		stack.display();
		
		assertEquals(3, stack.getHead().getData());
		assertEquals(3, stack.peek());
	}
	
	@Test
	void sizeTest() {
		StackDS stack = new StackDS();
		assertThrows(NoSuchElementException.class, ()->stack.size());
		stack.push(0);
		stack.push(3);
		stack.push(6);
		stack.display();
		assertEquals(3, stack.size());
		stack.pop();
		assertEquals(2, stack.size());
	}

}
