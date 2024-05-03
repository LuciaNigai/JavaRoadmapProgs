package maven.project.JavaRoadmap.JUnitTests.DSTests.NonLinearDSTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import maven.project.JavaRoadmap.dsa.non_linearDS.tree.BinaryTreeDS;

class BinaryTreeDSTest {

	@Test
	void insertionTest() {
		BinaryTreeDS tree = new BinaryTreeDS();
		tree.insert(10);
		assertEquals(10, tree.getRoot().getData());
		tree.insert(20);
		tree.insert(15);
		assertEquals(20, tree.getRoot().getLeft().getData());
		assertEquals(15, tree.getRoot().getRight().getData());
		tree.insert(7);
		assertEquals(7, tree.getRoot().getLeft().getLeft().getData());
	}

	@Test
	void deletionTest() {
		BinaryTreeDS tree = new BinaryTreeDS();
		assertThrows(NoSuchElementException.class,()-> tree.delete(10));
		tree.insert(10);
		tree.insert(20);
		tree.insert(15);
		tree.insert(7);

		assertEquals(10, tree.getRoot().getData());
		tree.delete(10);
		assertEquals(7, tree.getRoot().getData());
		assertEquals(20, tree.getRoot().getLeft().getData());
		assertEquals(15, tree.getRoot().getRight().getData());
		assertThrows(NoSuchElementException.class,()-> tree.delete(44));
	}

	@Test
	void traversalTest() {
		BinaryTreeDS tree = new BinaryTreeDS();
		assertEquals(true, tree.isEmpty());
		tree.insert(10);
		tree.insert(20);
		tree.insert(15);
		tree.insert(7);
		assertEquals(false, tree.isEmpty());
		tree.traversePreorder(tree.getRoot());
		System.out.println();
		tree.traverseInorder(tree.getRoot());
		System.out.println();
		tree.traversePostorder(tree.getRoot());
	}

	@Test
	void searchTest() {
		BinaryTreeDS tree = new BinaryTreeDS();
		tree.insert(10);
		tree.insert(20);
		tree.insert(15);
		tree.insert(7);
		
		assertEquals(10, tree.find(10).getData());
		assertEquals(15, tree.find(15).getData());
		assertThrows(NoSuchElementException.class, ()->tree.find(0));
	}
	
	@Test
	void heightSizeTest() {
		BinaryTreeDS tree = new BinaryTreeDS();
		tree.insert(10);
		tree.insert(20);
		
		assertEquals(2, tree.height());
		assertEquals(2, tree.size());
		
		tree.insert(15);
		tree.insert(7);
		
		assertEquals(3, tree.height());
		assertEquals(4, tree.size());
		
	}

}
