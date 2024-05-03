package maven.project.JavaRoadmap.dsa.non_linearDS.tree;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * The class implements the binary tree
 * @version 2.0
 * @since 2024-04-24
 */
public class BinaryTreeDS {

    BinaryTreeNode root; //tree root

    /**
     * Getter method, returns the tree root.
     * @return Tree root.
     */
    public BinaryTreeNode getRoot() {
        return root;
    }
    /**
     * Method inserts new node into the tree, the node is inserted atmost left as possible.
     * @param data New node data.
     */
    public void insert(int data) {
        BinaryTreeNode newNode = new BinaryTreeNode(data);
        if (root == null) { //if the root is empty the new node will become root
            root = newNode;
        } else {
            Queue<BinaryTreeNode> queue = new LinkedList<>(); // we create a queue that will save the elements as we traverse them.
            queue.add(root); //adding the first element to the queue 
            while (!queue.isEmpty()) {
                BinaryTreeNode current = queue.poll(); // polling the element from the queue to check it
                if (current.getLeft() == null) { //check the left child, if it is null we add the new element
                    current.setLeft(newNode);
                    return;
                } else if (current.getRight() == null) { // else check the right child, if it is null we add the new element
                    current.setRight(newNode);
                    return;
                } else { //else add those child nodes to the queue
                    queue.add(current.getLeft());
                    queue.add(current.getRight());
                }
            }
        }
    }

    /**
     * Method deletes the specified node from the tree.
     * @param del The element to be deleted.
     */
    public void delete(int del) {
        if (root == null) { // if the tree is empty throws an exception
            throw new NoSuchElementException("The tree is empty.");
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>(); //creating a queue to store nodes as we traverse them
        queue.add(root); //adding the root node to the queue
        BinaryTreeNode toDelete = null;
        BinaryTreeNode last = null;

        while (!queue.isEmpty()) { //while the queue has elements left
            last = queue.poll();
            if (last.getData() == del) { // check if node data equals data we want to delete
                toDelete = last;
            }
            if (last.getLeft() != null) { // if the left node is not empty adding it to the queue
                queue.add(last.getLeft());
            }
            if (last.getRight() != null) { // if the right element not empty adding it to the queue
                queue.add(last.getRight());
            }
        }

        if (toDelete != null) {
            int temp = last.getData(); 
            toDelete.setData(temp); // changing the node data to the last node data
            removeDeepest(last); //deleting the last node from its parent
        } else {
            throw new NoSuchElementException("The element you are trying to delete does not exist.");
        }
    }

    /**
     * Method removes the last element from the tree.
     * @param delNode The last node to be deleted.
     */
    private void removeDeepest(BinaryTreeNode delNode) {
        Queue<BinaryTreeNode> queue = new LinkedList<>(); // creating a queue where the elements will be stored while we traverse the trees
        queue.add(root); //adding the root node to the queue.
        BinaryTreeNode parent = null;

        while (!queue.isEmpty()) {
            BinaryTreeNode temp = queue.poll();
            if (temp.getLeft() == delNode || temp.getRight() == delNode) { // if the current node is the parent of the node to delete
                parent = temp;
            }
            if (temp.getLeft() != null) { // if the left node equals to node we want to deleted we delete the reference to that node
                queue.add(temp.getLeft()); // else we add the node to the queue to be checked further
            }
            if (temp.getRight() != null) { // if the right node equals to node we want to delete we delete the reference to that node
                queue.add(temp.getRight()); // else we add this node to the queue to be further checked
            }
        }

        if (parent != null) {
            if (parent.getLeft() == delNode) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        }
    }


    /**
     * Method returns the size of the binary tree.
     * @return Teh tree size.
     */
    public int size() {
        if (root == null) { 
            return 0;
        }

        int count = 0;
        Queue<BinaryTreeNode> queue = new LinkedList<>(); // the queue to store elements while we travrse them
        queue.add(root);
        while (!queue.isEmpty()) { // while there are elements left 
            BinaryTreeNode current = queue.poll();
            count++; // update count
            if (current.getLeft() != null) { // if element is not empty add it to the queue
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) { // if element is not empty add it to the queue
                queue.add(current.getRight());
            }
        }
        return count; // return count
    }

    /**
     * Method checks if the tree is empty or not.
     * @return Truw if empty, false otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /** Method returns the tree hight.
     * @return Tree hight.
     */
    public int height() {
        return calculateHeight(root);
    }

    /**
     * Method calculates the tree hight recursively.
     * @param node The node to be checked.
     * @return Tree hight.
     */
    private int calculateHeight(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = calculateHeight(node.getLeft());
        int rightHeight = calculateHeight(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * Methods searches for the specified node in the tree.
     * @param data The data to be searched for.
     * @return The node we are searching for.
     */
    public BinaryTreeNode find(int data) {
        if (root == null) {
            throw new NoSuchElementException("The tree is empty");
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode current = queue.poll();
            if (current.getData() == data) {
                return current;
            }
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
        throw new NoSuchElementException("The element was not found");
    }

    /**
     * Method traverses the tree inorder.
     * @param node The node to be traversed recursively.
     */
    public void traverseInorder(BinaryTreeNode node) {
        if (node != null) {
            traverseInorder(node.getLeft());
            System.out.print(node.getData() + " ");
            traverseInorder(node.getRight());
        }
    }

    /**
     * Method traverses tree postorder recursively.
     * @param node The node to be traversed.
     */
    public void traversePostorder(BinaryTreeNode node) {
        if (node != null) {
            traversePostorder(node.getLeft());
            traversePostorder(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

    /**
     * Method traverses the tree preorder recursively.
     * @param node The order to be traversed.
     */
    public void traversePreorder(BinaryTreeNode node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            traversePreorder(node.getLeft());
            traversePreorder(node.getRight());
        }
    }
}

