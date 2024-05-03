package maven.project.JavaRoadmap.JUnitTests.DSTests.LinearDSTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import maven.project.JavaRoadmap.dsa.linearDS.linkedList.CircularDoublyLinkedListDS;

class CircularDoublyLinkedListDSTest {

	@Test
	void insertNodeTest() {
		CircularDoublyLinkedListDS list = new CircularDoublyLinkedListDS();
		list.insertNode(10);
		list.insertNode(15);
		list.insertNode(20);
		
		list.printList();
		
		assertEquals(10, list.getHead().getData());
		assertEquals(20, list.getTail().getData());
//		assertEquals(10, list.getNext(list.getTail()).getData());
		assertEquals(10, list.getTail().getNext().getData());
//		assertEquals(20, list.getPrevious(list.getHead()).getData());
		assertEquals(20, list.getHead().getPrevious().getData());
	}
	
	@Test 
	void insertHeadTest() {
		CircularDoublyLinkedListDS list = new CircularDoublyLinkedListDS();
		list.insertNode(10);
		list.insertNode(15);
		list.insertNode(20);
		
		list.insertHead(5);
		list.printList();
		
		assertEquals(5, list.getHead().getData());
//		assertEquals(10, list.getNext(list.getHead()).getData());
		assertEquals(10, list.getHead().getNext().getData());
//		assertEquals(20, list.getPrevious(list.getHead()).getData());
		assertEquals(20, list.getHead().getPrevious().getData());
//		assertEquals(5, list.getNext(list.getTail()).getData());
		assertEquals(5, list.getTail().getNext().getData());
	}
	
	@Test
	void insertAfterTest() {
		CircularDoublyLinkedListDS list = new CircularDoublyLinkedListDS();
		list.insertNode(10);
		list.insertNode(15);
		
		list.insertAfter(15,20);
		list.printList();
		
		assertEquals(20, list.getTail().getData());
//		assertEquals(10, list.getNext(list.getTail()).getData());
		assertEquals(10, list.getTail().getNext().getData());
//		assertEquals(15, list.getPrevious(list.getTail()).getData());
		assertEquals(15, list.getTail().getPrevious().getData());
		
		list.insertAfter(10, 12);
		list.printList();
		
//		assertEquals(12, list.getNext(list.getHead()).getData());
		assertEquals(12, list.getHead().getNext().getData());
//		assertEquals(10, list.getPrevious(list.getNext(list.getHead())).getData());
		assertEquals(10, list.getHead().getNext().getPrevious().getData());
	}
	
	@Test
	void deleteNodeTest() {
		CircularDoublyLinkedListDS list = new CircularDoublyLinkedListDS();
		list.insertNode(10);
		list.insertNode(15);
		list.insertNode(20);
		
		list.deleteNode();
		
		assertEquals(15, list.getTail().getData());
//		assertEquals(10, list.getNext(list.getTail()).getData());
		assertEquals(10, list.getTail().getNext().getData());
//		assertEquals(15,list.getNext(list.getHead()).getData());
		assertEquals(15, list.getHead().getNext().getData());
	}
	
	@Test
	void deleteHeadTest() {
		CircularDoublyLinkedListDS list = new CircularDoublyLinkedListDS();
		list.insertNode(10);
		list.insertNode(15);
		list.insertNode(20);
		
		list.deleteHead();
		
		assertEquals(15, list.getHead().getData());
//		assertEquals(15, list.getPrevious(list.getTail()).getData());
		assertEquals(15, list.getTail().getPrevious().getData());
//		assertEquals(20, list.getPrevious(list.getHead()).getData());
		assertEquals(20, list.getHead().getPrevious().getData());
	}
	
	@Test
	void deleteNodeAfter() {
		CircularDoublyLinkedListDS list = new CircularDoublyLinkedListDS();
		list.insertNode(10);
		list.insertNode(15);
		list.insertNode(20);
		
		list.deleteAfter(10);
		
//		assertEquals(20, list.getNext(list.getHead()).getData());
		assertEquals(20, list.getHead().getNext().getData());
//		assertEquals(10, list.getPrevious(list.getTail()).getData());
		assertEquals(10, list.getTail().getPrevious().getData());
	}
	
	@Test
	void searchNodeTest() {
		CircularDoublyLinkedListDS list = new CircularDoublyLinkedListDS();
		list.insertNode(10);
		list.insertNode(15);
		list.insertNode(20);
		
		assertEquals(10, list.searchNode(10));
		assertThrows(NoSuchElementException.class, ()->list.searchNode(100));
	}

}
