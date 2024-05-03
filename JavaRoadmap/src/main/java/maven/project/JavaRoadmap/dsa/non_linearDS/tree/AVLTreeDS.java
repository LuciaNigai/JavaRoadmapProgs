package maven.project.JavaRoadmap.dsa.non_linearDS.tree;

/**
 * Class is an implementation of the avl tree.
 * Wasn't written by me. I do understand how the avl trees work, but struggled with implementing it.
 * @version 1.0
 * @since 2024-04-25 
 */
public class AVLTreeDS {
	/**
	 * Class represents the single node of the avl tree. 
	 * It stores the references to left and right nodes, and also the node height.
	 */
	class Node {
	    int data, height;
	    Node left_child, right_child;
	    Node(int val){
	        data = val;
	        height = 0;
	    }
	}

    Node node;
    /**
     * Method returns the height of the root node.
     * @param root The root node.
     * @return The root node height.
     */
    int get_height(Node root){
        if(root == null)
            return -1;
        return root.height;
    }
    /**
     * The method returns the banalnce factor of the root node. (difference between the height of left subtree and right subtree)
     * @param root The root node.
     * @return The balance factor of the root node.
     */
    int get_balance_factor(Node root){
        if(root == null)
            return 0;
        return (get_height(root.left_child) - get_height(root.right_child));
    }
    
    /**
     * Method performs tree LL rotation.
     * @param root The root node.
     * @return The new node.
     */
    Node LL_rotation(Node root){
        Node child = root.left_child;
        root.left_child = child.right_child;
        child.right_child = root;
        root.height = Math.max(get_height(root.left_child), get_height(root.right_child)) + 1; // updsting the root height
        child.height = Math.max(get_height(child.left_child), get_height(child.right_child)) + 1; // updating the child height
        return child;
    }
    
    /**
     * Method performes RR rotation.
     * @param root The root node.
     * @return The child node.
     */
    Node RR_rotation(Node root){
        Node child = root.right_child;
        root.right_child = child.left_child;
        child.left_child = root;
        root.height = Math.max(get_height(root.left_child), get_height(root.right_child)) + 1;
        child.height = Math.max(get_height(child.left_child), get_height(child.right_child)) + 1;
        return child;
    }
    /**
     * Method performes the preorder tree traversal.
     * @param root The root node.
     */
    void pre_order(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            pre_order(root.left_child);
            pre_order(root.right_child);
        }
    }
    
    /**
     * Method performes inserion of the new node.
     * @param root The node after which the new node is inserted.
     * @param val The value of the new node that is inserted.
     * @return  The new root if the tree changed.
     */
    Node insert(Node root, int val){
    	// if the tree is empty new node becomes the root node.
        if (root == null)
            return (new Node(val));
        if (val < root.data) // if the value is less insert into left subtree 
            root.left_child = insert(root.left_child, val);
        else if (val > root.data) //if value is bigger insert into right subtree
            root.right_child = insert(root.right_child, val);
        else
            return node; 
        root.height = Math.max(get_height(root.left_child), get_height(root.right_child)) + 1; //update root height
        int b = get_balance_factor(root); //get the root balance factor
        if(b > 1){ //if it is bigger than 1
            // LL Rotation Case
            if(get_balance_factor(root.left_child) == 1){ //and left chils equals 1
                root = LL_rotation(root); //perfrom LL rotation
            }
            // LR Rotation Case
            else{
                root.left_child = RR_rotation(root.left_child); //else perform RL rotaion
                root = LL_rotation(root);
            }
        }
        else if(b < -1){ // if the root factor is less than -1
            // RR Rotation Case
            if(get_balance_factor(root.right_child) == -1){ // and right child balance factor  equals -1
                root = RR_rotation(root); //perforn RR rotation
            }
            // RL Rotation Case
            else{ // else perfromt LR rotation
                root.right_child = LL_rotation(root.right_child);
                root = RR_rotation(root);
            }
        }
        return root;
    }
    
    
    /**
     * Method to delete a node from the AVL tree.
     * @param data The value of the node to be deleted.
     */
    public void delete(int data) {
        node = deleteNode(node, data);
    }

    /**
     * Method to delete a node from the AVL tree recursively.
     * @param root The root node of the subtree.
     * @param data The value of the node to be deleted.
     * @return The root node of the updated subtree after deletion.
     */
    private Node deleteNode(Node root, int data) {
        // Base case: if the tree is empty
        if (root == null)
            return root;

        // If the data to be deleted is less than the root's data,
        // then it lies in the left subtree
        if (data < root.data)
            root.left_child = deleteNode(root.left_child, data);

        // If the data to be deleted is greater than the root's data,
        // then it lies in the right subtree
        else if (data > root.data)
            root.right_child = deleteNode(root.right_child, data);

        // If data is same as root's data, then this is the node to be deleted
        else {
            // Node with only one child or no child
            if ((root.left_child == null) || (root.right_child == null)) {
                Node temp = null;
                if (temp == root.left_child)
                    temp = root.right_child;
                else
                    temp = root.left_child;

                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else // One child case
                    root = temp; // Copy the contents of the non-empty child

            } else {
                // Node with two children: Get the inorder successor (smallest in the right subtree)
                Node temp = minValueNode(root.right_child);

                // Copy the inorder successor's data to this node
                root.data = temp.data;

                // Delete the inorder successor
                root.right_child = deleteNode(root.right_child, temp.data);
            }
        }

        // If the tree had only one node then return
        if (root == null)
            return root;

        // Update the height of the current node
        root.height = Math.max(get_height(root.left_child), get_height(root.right_child)) + 1;

        // Get the balance factor of this node to check whether it became unbalanced
        int balance = get_balance_factor(root);

        // If the node becomes unbalanced, there are four cases

        // Left Left Case
        if (balance > 1 && get_balance_factor(root.left_child) >= 0)
            return LL_rotation(root);

        // Left Right Case
        if (balance > 1 && get_balance_factor(root.left_child) < 0) {
            root.left_child = RR_rotation(root.left_child);
            return LL_rotation(root);
        }

        // Right Right Case
        if (balance < -1 && get_balance_factor(root.right_child) <= 0)
            return RR_rotation(root);

        // Right Left Case
        if (balance < -1 && get_balance_factor(root.right_child) > 0) {
            root.right_child = LL_rotation(root.right_child);
            return RR_rotation(root);
        }

        return root;
    }

    /**
     * Method to find the node with the minimum value in a subtree.
     * @param root The root node of the subtree.
     * @return The node with the minimum value in the subtree.
     */
    private Node minValueNode(Node root) {
        Node current = root;

        // Loop down to find the leftmost leaf
        while (current.left_child != null)
            current = current.left_child;

        return current;
    }

    /**
     * Main method cheks the AVL tree implementation
     * @param args
     */
    public static void main(String[] args) {
    	AVLTreeDS tree = new AVLTreeDS();
        tree.node = tree.insert(tree.node, 17);
        tree.node = tree.insert(tree.node, 18);
        tree.node = tree.insert(tree.node, 19);
        tree.node = tree.insert(tree.node, 11);
        tree.node = tree.insert(tree.node, 10);
        System.out.println("Pre-order Traversal of the AVL Tree is : ");
        tree.pre_order(tree.node);
        tree.delete(17);
        System.out.println();
        tree.pre_order(tree.node);
    }
}