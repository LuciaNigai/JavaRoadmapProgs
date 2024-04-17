package maven.project.JavaRoadmap.JUnitTests.DSTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import maven.project.JavaRoadmap.dsa.linearDS.CircularSinglyLinkedListDS;

class CircularSinglyLinkedListDSTest {

	@Test
	void insertAtEndTest() {
		CircularSinglyLinkedListDS list = new CircularSinglyLinkedListDS();
		list.insertNode(100);
		list.insertNode(200);
		list.insertNode(300);
		
		list.printList();
		assertEquals(100, list.getHead().getData());
		assertEquals(200, list.getNext(list.getHead()).getData());
		assertEquals(100, list.getNext(list.getNext(list.getNext(list.getHead()))).getData());
	}
	
	@Test
	void insertHeadTet() {
		CircularSinglyLinkedListDS list = new CircularSinglyLinkedListDS();
		list.insertNode(100);
		list.insertNode(200);
		list.insertNode(300);
		
		list.insertNodeBegin(50);
		list.printList();
		
		assertEquals(50, list.getHead().getData());
		assertEquals(100, list.getNext(list.getHead()).getData());
		assertEquals(50, list.getNext(list.getNext(list.getNext(list.getNext(list.getHead())))).getData());
	}
	
	@Test
	void insertAfterTest() {
		CircularSinglyLinkedListDS list = new CircularSinglyLinkedListDS();
		list.insertNode(100);
		list.insertNode(200);
		list.insertNode(300);
		
		list.insertNodeAfter(300, 400);
		list.printList();
		
		assertEquals(400, list.getNext(list.getNext(list.getNext(list.getHead()))).getData());
	
		list.insertNodeAfter(100, 150);
		assertEquals(150, list.getNext(list.getHead()).getData());
		assertThrows(NoSuchElementException.class, ()->list.insertNodeAfter(22, 22));
		
		CircularSinglyLinkedListDS emptyList = new CircularSinglyLinkedListDS();
		assertThrows(NoSuchElementException.class, ()->emptyList.insertNodeAfter(22, 22));
		
	}
	
	@Test
	void deleteNodeTest() {
		CircularSinglyLinkedListDS list = new CircularSinglyLinkedListDS();
		list.insertNode(100);
		list.insertNode(200);
		list.insertNode(300);
		
		list.deleteNode();
		list.printList();
		
		assertEquals(100, list.getNext(list.getNext(list.getHead())).getData());
	}
	
	@Test
	void deleteHeadTest() {
		CircularSinglyLinkedListDS list = new CircularSinglyLinkedListDS();
		list.insertNode(100);
		list.insertNode(200);
		list.insertNode(300);
		
		list.deleteHead();
		list.printList();
		
		assertEquals(200, list.getHead().getData());
		assertEquals(200, list.getNext(list.getNext(list.getHead())).getData());
		
		CircularSinglyLinkedListDS emptyList = new CircularSinglyLinkedListDS();
		assertThrows(NoSuchElementException.class, ()->emptyList.deleteHead());
	}
	
	@Test
	void deleteNodeAfterTest() {
		CircularSinglyLinkedListDS list = new CircularSinglyLinkedListDS();
		list.insertNode(100);
		list.insertNode(200);
		list.insertNode(300);
		
		list.deleteNodeAfter(100);
		list.printList();
		
		assertEquals(300, list.getNext(list.getHead()).getData());
		assertEquals(100, list.getNext(list.getNext(list.getHead())).getData());
		assertThrows(NoSuchElementException.class, ()->list.deleteNodeAfter(239));
	}
	
	@Test
	void searchNodeTest() {
		CircularSinglyLinkedListDS list = new CircularSinglyLinkedListDS();
		
		assertThrows(NoSuchElementException.class, ()->list.searchNode(303));
		
		list.insertNode(100);
		list.insertNode(200);
		list.insertNode(300);
		
		assertEquals(200, list.searchNode(200));
		assertThrows(NoSuchElementException.class, ()->list.searchNode(555));
	}
	
	
	

}
