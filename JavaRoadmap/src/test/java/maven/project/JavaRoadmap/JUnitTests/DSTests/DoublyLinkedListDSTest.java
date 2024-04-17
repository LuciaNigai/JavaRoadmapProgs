package maven.project.JavaRoadmap.JUnitTests.DSTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import maven.project.JavaRoadmap.dsa.linearDS.DoublyLinkedListDS;

class DoublyLinkedListDSTest {

	@Test
	void InsertDoubleNodetest() {
		DoublyLinkedListDS list = new DoublyLinkedListDS();
		list.insertDoubleNode(12);
		list.insertDoubleNode(24);
		list.insertDoubleNode(36);
		
		System.out.print("Test 1 ");
		list.printList();
		
		assertEquals(12, list.getHead().getData());
		assertEquals(36, list.getTail().getData());
		assertEquals(24, list.getNext(list.getHead()).getData());
		assertEquals(24, list.getPrevious(list.getTail()).getData());
	}
	
	@Test
	void insertDoubleHeadTTest() {
		DoublyLinkedListDS list = new DoublyLinkedListDS();
		list.insertDoubleNode(12);
		list.insertDoubleNode(24);
		list.insertDoubleNode(36);
		list.insertDoubleNodeBegin(6);
		
		System.out.print("Test 2 ");
		list.printList();
		
		assertEquals(6, list.getHead().getData());
		assertEquals(12, list.getNext(list.getHead()).getData());
		assertEquals(12, list.getPrevious(list.getPrevious(list.getTail())).getData());
	}
	
	@Test
	void insertDoubleNodeAfterTest() {
		DoublyLinkedListDS list = new DoublyLinkedListDS();
		list.insertDoubleNode(12);
		list.insertDoubleNode(24);
		list.insertDoubleNode(36);
		
		list.insertDoubleNodeAfter(12, 100);
		
		System.out.print("Test 3 ");
		list.printList();
		
		assertEquals(100, list.getNext(list.getHead()).getData());
		assertEquals(100, list.getPrevious(list.getPrevious(list.getTail())).getData());
	}
	
	@Test
	void deleteDoubleNodeTest() {
		DoublyLinkedListDS list = new DoublyLinkedListDS();
		list.insertDoubleNode(12);
		list.insertDoubleNode(24);
		list.insertDoubleNode(36);
		
		list.deleteDoubleNode();
		
		System.out.print("Test 4 ");
		list.printList();
		
		assertEquals(24, list.getTail().getData());
		assertEquals(24, list.getNext(list.getHead()).getData());
	}
	
	@Test
	void deleteDoubleHeadTest() {
		DoublyLinkedListDS list = new DoublyLinkedListDS();
		list.insertDoubleNode(12);
		list.insertDoubleNode(24);
		list.insertDoubleNode(36);
		
		list.deleteDoubleNodeBegin();
		
		System.out.print("Test 5 ");
		list.printList();
		
		assertEquals(24, list.getHead().getData());
		assertEquals(24, list.getPrevious(list.getTail()).getData());
	}
	
	@Test
	void deleteDoubleNodeAfterTest() {
		DoublyLinkedListDS list = new DoublyLinkedListDS();
		list.insertDoubleNode(12);
		list.insertDoubleNode(24);
		list.insertDoubleNode(36);
		
		list.deleteDoubleNodeAfter(24);
		
		System.out.print("Test 6 ");
		list.printList();
	
		assertEquals(24, list.getTail().getData());
		assertEquals(24, list.getNext(list.getHead()).getData());
	}
	
	@Test
	void SearchDoubleNodeTest() {
		DoublyLinkedListDS list = new DoublyLinkedListDS();
		list.insertDoubleNode(12);
		list.insertDoubleNode(24);
		list.insertDoubleNode(36);
		
		assertEquals(24, list.searchDoubleNode(24));
		assertThrows(NoSuchElementException.class, ()->list.searchDoubleNode(120));
	}

}
