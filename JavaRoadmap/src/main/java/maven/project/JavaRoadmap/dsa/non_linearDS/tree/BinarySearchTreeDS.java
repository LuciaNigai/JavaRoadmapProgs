package maven.project.JavaRoadmap.dsa.non_linearDS.tree;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;


/**
 * Class is an implementstion of the binary search tree.
 * @version 2.0
 * @since 2024-04-26
 */
public class BinarySearchTreeDS {
	BinaryTreeNode root;

	/**
	 * Getter method for tree node.
	 * @return Tree node.
	 */
	public BinaryTreeNode getRoot() {
		return root;
	}

	/**
	 * Method inserts a new node into the tree based on bst rules.
	 * @param data New node data.
	 */
	public void insert(int data) {
		BinaryTreeNode node = new BinaryTreeNode(data);
		if (this.isEmpty()) {
			root = node;
		} else {
			Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
			queue.add(root);
			while (!queue.isEmpty()) {
				BinaryTreeNode temp = queue.poll();
				if (temp != null) {
					if (temp.getData() > data && temp.getLeft() == null) {
						temp.setLeft(node);
						break;
					} else {
						queue.add(temp.getLeft());
					}
					if (temp.getData() < data && temp.getRight() == null) {
						temp.setRight(node);
						break;
					} else {
						queue.add(temp.getRight());
					}
				}

			}
		}
	}

	/**
	 * Method deletes the specified node if it is found, else throws NoSuchElementException .
	 * @param data The node data to be deleted.
	 * @return The deleted not data.
	 */
	public int delete(int data) {
	    if (isEmpty()) {
	        throw new NoSuchElementException("The tree is empty.");
	    }
	    
	    BinaryTreeNode toDelete = null;
	    BinaryTreeNode parent = null;
	    Queue<BinaryTreeNode> queue = new LinkedList<>();
	    queue.add(root);
	    
	    // Find the node to delete and its parent
	    while (!queue.isEmpty()) {
	        parent = queue.poll();
	        if (parent.getData() == data) {
	            toDelete = parent;
	        }
	        if (parent.getLeft() != null) {
	            if (parent.getLeft().getData() == data) {
	                toDelete = parent.getLeft();
	                break;
	            }
	            queue.add(parent.getLeft());
	        }
	        if (parent.getRight() != null) {
	            if (parent.getRight().getData() == data) {
	                toDelete = parent.getRight();
	                break;
	            }
	            queue.add(parent.getRight());
	        }
	    }

	    if (toDelete == null) {
	        throw new NoSuchElementException("The element you are trying to delete does not exist.");
	    }

	    int deletedData = toDelete.getData(); // Store the data of the node to be deleted

	    // Case 1: Node to delete has no children
	    if (toDelete.getLeft() == null && toDelete.getRight() == null) {
	        if (parent == null) { // Deleting the root node
	            root = null;
	        } else if (parent.getLeft() == toDelete) {
	            parent.setLeft(null);
	        } else {
	            parent.setRight(null);
	        }
	    }
	    // Case 2: Node to delete has one child
	    else if (toDelete.getLeft() == null || toDelete.getRight() == null) {
	        BinaryTreeNode child = (toDelete.getLeft() != null) ? toDelete.getLeft() : toDelete.getRight();
	        if (parent == null) { // Deleting the root node
	            root = child;
	        } else if (parent.getLeft() == toDelete) {
	            parent.setLeft(child);
	        } else {
	            parent.setRight(child);
	        }
	    }
	    // Case 3: Node to delete has two children
	    else {
	        // Find the leftmost node in the right subtree (or rightmost node in the left subtree)
	        BinaryTreeNode successor = findMin(toDelete.getRight());
	        // Replace the data of the node to delete with the data of the successor
	        toDelete.setData(successor.getData());
	        // Delete the successor node
	        delete(successor.getData());
	    }

	    return deletedData; // Return the data of the deleted node
	}
	
	/**
	 * Method calls recursive search method and checks if the searched element exists in the tree.
	 * @param data The data of the element we are searching for.
	 * @return True if the element is found, false otherwise.
	 */
	public boolean search(int data) {
	    return searchRecursive(root, data);
	}

	/**
	 * Method serches for the specified node recursively. 
	 * @param node The current node to be checked.
	 * @param data The data we are searching for.
	 * @return True if the element with the searched data exists, false otherwise.
	 */
	private boolean searchRecursive(BinaryTreeNode node, int data) {
	    if (node == null) {
	        return false; // Data not found
	    }

	    if (node.getData() == data) {
	        return true; // Data found
	    } else if (node.getData() > data) {
	        return searchRecursive(node.getLeft(), data); // Search left subtree
	    } else {
	        return searchRecursive(node.getRight(), data); // Search right subtree
	    }
	}


	/** Helper method to find the leftmost node in a subtree
	 * @param node The node of which the left node is searched.
	 * @return Left node of the current node.
	 */
	public BinaryTreeNode findMin(BinaryTreeNode node) {
	    while (node.getLeft() != null) {
	        node = node.getLeft();
	    }
	    return node;
	}
	
	public BinaryTreeNode findMax(BinaryTreeNode node) {
		while(node.getRight()!=null) {
			node=node.getRight();
		}
		return node;
	}

	/**
	 * The method returns the hight of the tree.
	 * @return Tree height.
	 */
	public int height() {
		return getHeight(this.getRoot());
	}

	/** 
	 * Helper methods, calculates the tree height recursively.
	 * @param node The current node of which the height is calculated.
	 * @return The tree height.
	 */
	public int getHeight(BinaryTreeNode node) {
		if (node == null) {
			return 0;
		}
		int heightLeft = getHeight(node.getLeft());
		int heightRight = getHeight(node.getRight());
		return Math.max(heightLeft, heightRight) + 1;
	}

	/**
	 * Method calculates the tree size.
	 * @return The tree size.
	 */
	public int size() {
		if (this.isEmpty()) {
			return 0;
		} else {
			Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
			queue.add(root);
			int size = 0;
			while (!queue.isEmpty()) {
				BinaryTreeNode temp = queue.poll();
				size++;
				if (temp.getLeft() != null) {
					queue.add(temp.getLeft());
				}
				if (temp.getRight() != null) {
					queue.add(temp.getRight());
				}
			}
			return size;
		}
	}

	/**
	 * Method check if the tree is empty.
	 * @return True if the tree is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Method traverses the tree inorder recursively.
	 * @param node The current node to be traversed.
	 */
	public void traverseInorder(BinaryTreeNode node) {
		if (node != null) {
			traverseInorder(node.getLeft());
			System.out.print(node.getData() + " ");
			traverseInorder(node.getRight());
		}
	}

	
	/**
	 * Method traverses the tree preorder recursively.
	 * @param node The current node to be traversed.
	 */
	public void traversePreorder(BinaryTreeNode node) {
		if (node != null) {
			System.out.print(node.getData() + " ");
			traversePreorder(node.getLeft());
			traversePreorder(node.getRight());
		}
	}

	/**
	 * Method traverses the tree postorder recursively.
	 * @param node The current node to be traversed.
	 */
	public void traversePostorder(BinaryTreeNode node) {
		if (node != null) {
			traversePostorder(node.getLeft());
			traversePostorder(node.getRight());
			System.out.print(node.getData() + " ");
		}
	}
}
