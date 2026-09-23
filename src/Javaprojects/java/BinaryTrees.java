package Javaprojects.java;


public class BinaryTrees {
    // Each Node stores:
    // data + left child + right child
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;

        }
    }
    // Keeps track of where we are in the array
    static class BinaryTree{
        static int idx =-1;
        // Builds a binary tree from preorder
        // -1 means "there is no node here"
        public static Node buildTree(int nodes[]) {
            // Move to the next value
            idx++;

            // If value is -1, there's no child
            if(nodes[idx]==-1) {
                return null;
            }

            // Create a new node
            Node newNode = new Node(nodes[idx]);
            // Build the left subtree
            newNode.left = buildTree(nodes);
            // Build the right subtree
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    public static void main(String[] arg) {
        int nodes[] = {1,2,4,-1,-1,3,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree= new BinaryTree();
        // Build the tree
        Node root= tree.buildTree(nodes);
        // Print root
        System.out.println(root.data);

    }
}
