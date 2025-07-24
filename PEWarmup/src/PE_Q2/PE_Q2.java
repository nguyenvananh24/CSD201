// File: PE_Q2.java
package PE_Q2;

class Crypto {

    String name;
    int month, year;

    public Crypto(String name, int month, int year) {
        this.name = name;
        this.month = month;
        this.year = year;
    }

    // So sánh theo thời gian (năm, rồi đến tháng)
    public int compareTime(Crypto other) {
        if (this.year != other.year) {
            return this.year - other.year;
        }
        return this.month - other.month;
    }

    public String toString() {
        return name + " - " + month + "/" + year;
    }
}

class Node {

    Crypto data;
    Node left, right;
    int height;

    public Node(Crypto data) {
        this.data = data;
        height = 1;
    }
}

class AVL_ModelTree {

    private Node root;

    public AVL_ModelTree() {
        root = null;
    }

    private int height(Node n) {
        return (n == null) ? 0 : n.height;
    }

    private int getBalance(Node n) {
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }

    private void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    public void insert(Crypto data) {
        root = insert(root, data);
    }

    private Node insert(Node node, Crypto data) {
        if (node == null) {
            return new Node(data);
        }

        if (data.compareTime(node.data) < 0) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }

        updateHeight(node);
        int balance = getBalance(node);

        if (balance > 1 && data.compareTime(node.left.data) < 0) {
            return rotateRight(node);
        }

        if (balance < -1 && data.compareTime(node.right.data) > 0) {
            return rotateLeft(node);
        }

        if (balance > 1 && data.compareTime(node.left.data) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && data.compareTime(node.right.data) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }
}

public class PE_Q2 {

    public static void main(String[] args) {
        AVL_ModelTree tree = new AVL_ModelTree();

        tree.insert(new Crypto("Bitcoin", 9, 2009));
        tree.insert(new Crypto("Ethereum", 10, 2015));
        tree.insert(new Crypto("Ripple", 6, 2012));
        tree.insert(new Crypto("Litecoin", 11, 2011));
        tree.insert(new Crypto("Cardano", 5, 2017));
        tree.insert(new Crypto("Solana", 6, 2020));
        tree.insert(new Crypto("Dogecoin", 2, 2013));
        tree.insert(new Crypto("Polkadot", 1, 2020));
        tree.insert(new Crypto("Chainlink", 3, 2017));
        tree.insert(new Crypto("Tether", 2, 2014));

        System.out.println("In-order traversal of Crypto models (by time):");
        tree.inOrder();
    }
}
