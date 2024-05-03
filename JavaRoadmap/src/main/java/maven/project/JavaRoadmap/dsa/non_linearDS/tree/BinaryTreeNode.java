package maven.project.JavaRoadmap.dsa.non_linearDS.tree;

public class BinaryTreeNode {
    private int data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    /**
     * Constrctor, creates new binary tree node.
     * @param data The node data.
     */
    public BinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    /**
     * Getter method, returns node data.
     * @return Node data.
     */
    public int getData() {
        return this.data;
    }

    /**
     * Setter method, changes the node data.
     * @param data
     */
    public void setData(int data) {
        this.data = data;
    }

    /** 
     * Getter method, returns the left node.
     * @return Left node.
     */
    public BinaryTreeNode getLeft() {
        return this.left;
    }

    /**
     * Getter method, teturns right node.
     * @return Right node.
     */
    public BinaryTreeNode getRight() {
        return this.right;
    }

    /**
     * Setter method, sets the left node.
     * @param left New left node.
     */
    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    /**
     * Setter method, sets the right node.
     * @param right New right node.
     */
    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
    
}