package maven.project.JavaRoadmap.JUnitTests.DSTests.NonLinearDSTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import maven.project.JavaRoadmap.dsa.non_linearDS.tree.BinarySearchTreeDS;

class BinarySearchTreeDSTest {

	@Test
	void insertionTest() {
		BinarySearchTreeDS bst = new BinarySearchTreeDS();
		bst.insert(10);
		bst.insert(20);
		bst.insert(30);
		bst.insert(5);
		
		assertEquals(10, bst.getRoot().getData());
		assertEquals(5, bst.getRoot().getLeft().getData());
		assertEquals(20, bst.getRoot().getRight().getData());
		assertEquals(30, bst.getRoot().getRight().getRight().getData());
	}
	
	@Test
	void traversalTest() {
		BinarySearchTreeDS bst = new BinarySearchTreeDS();
		bst.insert(10);
		bst.insert(20);
		bst.insert(30);
		bst.insert(5);
		
		bst.traverseInorder(bst.getRoot());
		System.out.println();
		bst.traversePreorder(bst.getRoot());
		System.out.println();
		bst.traversePostorder(bst.getRoot());
	}
	
	@Test
	void deletionTest() {
		BinarySearchTreeDS bst = new BinarySearchTreeDS();
		bst.insert(10);
		bst.insert(20);
		bst.insert(30);
		bst.insert(5);
		
		assertEquals(10, bst.getRoot().getData());
		assertEquals(10, bst.delete(10));;
		assertEquals(20, bst.getRoot().getData());
		assertEquals(5, bst.getRoot().getLeft().getData());
		assertEquals(30, bst.getRoot().getRight().getData());
		assertEquals(30, bst.delete(30));
		assertEquals(null, bst.getRoot().getRight());
		bst.delete(5);
		assertThrows(NoSuchElementException.class, () -> bst.delete(34));
		assertEquals(20, bst.delete(20));
		assertThrows(NoSuchElementException.class, ()->bst.delete(0));
	}
	
	@Test
	void sizeHeightTest() {
		BinarySearchTreeDS bst = new BinarySearchTreeDS();
		assertEquals(true, bst.isEmpty());
		assertEquals(0, bst.size());
		assertEquals(0, bst.height());
		bst.insert(10);
		bst.insert(20);
		bst.insert(30);
		bst.insert(5);
		assertEquals(false, bst.isEmpty());
		assertEquals(4, bst.size());
		assertEquals(3, bst.height());
		
		bst.delete(30);
		assertEquals(3, bst.size());
		assertEquals(2, bst.height());
	}
	
	@Test
	void searchTest() {
		BinarySearchTreeDS bst = new BinarySearchTreeDS();
		assertEquals(false, bst.search(10));
		bst.insert(10);
		bst.insert(20);
		bst.insert(30);
		bst.insert(5);
		
		assertEquals(false, bst.search(50));
		assertEquals(true, bst.search(20));
		assertEquals(true, bst.search(10));
	}
	
	@Test 
	void findMaxMinTest(){
		BinarySearchTreeDS bst = new BinarySearchTreeDS();
		bst.insert(10);
		bst.insert(20);
		bst.insert(30);
		bst.insert(5);
		
		assertEquals(5, bst.findMin(bst.getRoot()).getData());
		assertEquals(30, bst.findMax(bst.getRoot()).getData());
	}
	

}
