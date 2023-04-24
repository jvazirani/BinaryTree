import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        // If val is in the tree, return true
        if (root.getVal() == val) {
            return true;
        }
        return searchHelp(root, val);
    }

    public boolean searchHelp(BSTNode node, int val){
        if (node.getVal() == val) {
            return true;
        }
        // If you've reached the end
        if (node.getRight() == null || node.getLeft() == null){
            return false;
        }
        if(node.getRight().getVal() > val){
            // If val is less than the node, go to the left and recurse
            return searchHelp(node.getLeft(), val);
        }
        else{
            // If val is greater than the node, go to the right and recurse
            return searchHelp(node.getRight(), val);
        }
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        // Create arrayList for sorted nodes, sort it, then return it
        ArrayList<BSTNode> sorted = new ArrayList<BSTNode>();
        inOrderHelp(root, sorted);
        return sorted;
    }

    public void inOrderHelp(BSTNode node, ArrayList<BSTNode> sorted){
        // Base case
        // If a node has no children, don't recurse on it
        if(node == null){
            return;
        }
        // First recurse to the left
        inOrderHelp(node.getLeft(), sorted);
        // Add the current node, the first time it is visited
        sorted.add(node);
        // Then explore the right
        inOrderHelp(node.getRight(), sorted);
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal\
        // Create arrayList for sorted nodes, sort it, then return it
        ArrayList<BSTNode> sorted = new ArrayList<BSTNode>();
        PreorderHelp(root, sorted);
        return sorted;
    }

    public void PreorderHelp(BSTNode node, ArrayList<BSTNode> sorted){
        // Add the current node, the first time it is visited
        sorted.add(node);
        // Base case
        // If a node has no children, don't recurse on it
        if((node.getLeft() == null) && (node.getRight() == null)){
                return;
        }
        // First recurse to the left
        PreorderHelp(node.getLeft(), sorted);
        // Then explore the right
        PreorderHelp(node.getRight(), sorted);
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        // Create arrayList for sorted nodes, sort it, then return it
        ArrayList<BSTNode> sorted = new ArrayList<BSTNode>();
        postorderHelp(root, sorted);
        return sorted;
    }

    public void postorderHelp(BSTNode node, ArrayList<BSTNode> sorted){
        // Base case
        // If a node is null, don't recurse
        if(node == null){
            return;
        }
        // First recurse to the left
        postorderHelp(node.getLeft(), sorted);
        // Then explore the right
        postorderHelp(node.getRight(), sorted);
        // Add the current node, the first time it is visited
        sorted.add(node);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val){
        root = insertHelp(val, root);
    }
    public BSTNode insertHelp(int val, BSTNode node) {
        // If node is null, create new node
        if(node == null){
            BSTNode n = new BSTNode(val);
            return n;
        }
        // If node is the value it is already in the tree so just return it
        if(val == node.getVal()){
            return node;
        }
        // If val is greater than value of node then keep searching to the right
        if(val > node.getVal()){
            node.setRight(insertHelp(val, node.getRight()));
            return node;
        }
        // If it is less than val keep searching to left
        node.setLeft(insertHelp(val, node.getLeft()));
        return node;
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
//    public boolean isValidBST() {
//        // TODO: Optional Challenge!
//        return false;
//    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
//
        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
