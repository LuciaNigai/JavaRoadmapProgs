package maven.project.JavaRoadmap.JUnitTests.DSTests;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import maven.project.JavaRoadmap.dsa.linearDS.SinglyLinkedListDS;

class SinglyLinkedListDSTest {

	@Test
	void InsertingNodeAtEndTest() {
		SinglyLinkedListDS list = new SinglyLinkedListDS();

	    // Test inserting a node into an empty lists
	    list.insertNode(12);
	    assertEquals(12, list.getHead().getData());
	    assertNull(list.getNextNode(list.getHead()));

	    // Test inserting a node into a non-empty list
	    list.insertNode(24);
	    assertEquals(12, list.getHead().getData());
	    assertNotNull(list.getNextNode(list.getHead()));
	    assertEquals(24, list.getNextNode(list.getHead()).getData());
	    assertNull(list.getNextNode(list.getNextNode(list.getHead())));
	    
	    list.insertNode(48);
	    assertEquals(48, list.getNextNode(list.getNextNode(list.getHead())).getData());
	    assertNull(list.getNextNode(list.getNextNode(list.getNextNode(list.getHead()))));
	    list.printList();
	}
	
	@Test
	void InsertingNodeAtBeginingTest() {
		SinglyLinkedListDS list = new SinglyLinkedListDS();
		list.insertNode(12);
		list.insertNode(24);
		list.insertNodeBegin(6);
		assertEquals(6, list.getHead().getData());
		assertEquals(12, list.getNextNode(list.getHead()).getData());
		assertEquals(24, list.getNextNode(list.getNextNode(list.getHead())).getData());
		assertNull(list.getNextNode(list.getNextNode(list.getNextNode(list.getHead()))));
		list.printList();
	}
	
	@Test
	void InsertNodeAfterNodeTest() {
		SinglyLinkedListDS list = new SinglyLinkedListDS();
		list.insertNode(12);
		list.insertNode(24);
		list.insertNodeAfter(100,12);
		assertEquals(100, list.getNextNode(list.getHead()).getData());
		assertEquals(24, list.getNextNode(list.getNextNode(list.getHead())).getData());
		assertNull(list.getNextNode(list.getNextNode(list.getNextNode(list.getHead()))));
		list.printList();
	}
	
	@Test
	void insertNodeAfterNodeWrongTest() {
		SinglyLinkedListDS list = new SinglyLinkedListDS();
		list.insertNode(12);
		list.insertNode(24);
		assertThrows(IllegalArgumentException.class, () -> list.insertNodeAfter(1, 2));
	}
	
	@Test
	void deletingFromEndTest() {
		SinglyLinkedListDS list = new SinglyLinkedListDS();
		list.insertNode(12);
		list.insertNode(24);
		list.insertNode(48);
		list.deleteNode();
		assertEquals(24, list.getNextNode(list.getHead()).getData());
		assertNull(list.getNextNode(list.getNextNode(list.getHead())));
		list.printList();
	}
	
	@Test 
	void deleteFromBeginingTest() {
		SinglyLinkedListDS list = new SinglyLinkedListDS();
		list.insertNode(12);
		list.insertNode(24);
		list.insertNode(48);
		list.deleteNodeHead();
		assertEquals(24, list.getHead().getData());
		assertEquals(48, list.getNextNode(list.getHead()).getData());
		assertNull(list.getNextNode(list.getNextNode(list.getHead())));
		list.printList();
	}
	
	@Test
	void deleteAfterTest() {
		SinglyLinkedListDS list = new SinglyLinkedListDS();
		list.insertNode(12);
		list.insertNode(24);
		list.insertNode(48);
		list.deleteNodeAfter(12);
		assertEquals(48, list.getNextNode(list.getHead()).getData());
		assertNull(list.getNextNode(list.getNextNode(list.getHead())));
		list.printList();
	}
	
	@Test
	void findNodeTest() {
		SinglyLinkedListDS list = new SinglyLinkedListDS();
		list.insertNode(12);
		list.insertNode(24);
		list.insertNode(48);
		int expected = 48;
		assertEquals(expected, list.findNode(48));
		assertThrows(IllegalArgumentException.class, ()->list.findNode(33));
	}
}
