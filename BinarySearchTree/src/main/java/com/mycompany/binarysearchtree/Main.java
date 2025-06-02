package com.mycompany.binarysearchtree;
class Node {
    int value;      
    Node left;   
    Node right;   

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    Node root;    

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    public void levelOrder() {
    }

    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.value + " ");
            inOrderRec(root.right);
        }
    }

    public void postOrder() {
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.value + " ");
        }
    }

    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightRec(root.left);
        int rightHeight = heightRec(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(1);
        tree.insert(4);
        
        System.out.println("Pre-order traversal:");
        tree.preOrder();
        
        System.out.println("In-order traversal:");
        tree.inOrder();
        
        System.out.println("Post-order traversal:");
        tree.postOrder();
        
        System.out.println("Height of the tree: " + tree.height());
    }
}
