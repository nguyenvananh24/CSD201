package com.mycompany.managingstudentrecordsusingsinglylinkedlist;

public class AVLTree {
    private AVLTreenode root;

    public void insert(Product product) {
        root = insert(root, product);
    }

    private AVLTreenode insert(AVLTreenode node, Product product) {
        if (node == null) 
            return new AVLTreenode(product);

        if (product.getId() < node.getProduct().getId())
            node.setLeft(insert(node.getLeft(), product));
        else if (product.getId() > node.getProduct().getId())
            node.setRight(insert(node.getRight(), product));
        else 
            return node;

        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));

        int balance = getBalance(node);

        if (balance > 1 && product.getId() < node.getLeft().getProduct().getId())
            return rotateRight(node);
        if (balance < -1 && product.getId() > node.getRight().getProduct().getId())
            return rotateLeft(node);
        if (balance > 1 && product.getId() > node.getLeft().getProduct().getId()) {
            node.setLeft(rotateLeft(node.getLeft()));
            return rotateRight(node);
        }
        if (balance < -1 && product.getId() < node.getRight().getProduct().getId()) {
            node.setRight(rotateRight(node.getRight()));
            return rotateLeft(node);
        }

        return node;
    }

    private int height(AVLTreenode N) {
        if (N == null) return 0;
        return N.getHeight();
    }

    private int getBalance(AVLTreenode N) {
        if (N == null) return 0;
        return height(N.getLeft()) - height(N.getRight());
    }

    private AVLTreenode rotateRight(AVLTreenode y) {
        AVLTreenode x = y.getLeft();
        AVLTreenode T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);

        return x;
    }

    private AVLTreenode rotateLeft(AVLTreenode x) {
        AVLTreenode y = x.getRight();
        AVLTreenode T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        return y;
    }

    public void deleteNode(int productId) {
        root = deleteNode(root, productId);
    }

    private AVLTreenode deleteNode(AVLTreenode root, int productId) {
        if (root == null) return root;

        if (productId < root.getProduct().getId())
            root.setLeft(deleteNode(root.getLeft(), productId));
        else if (productId > root.getProduct().getId())
            root.setRight(deleteNode(root.getRight(), productId));
        else {
            if ((root.getLeft() == null) || (root.getRight() == null)) {
                AVLTreenode temp = (root.getLeft() != null) ? root.getLeft() : root.getRight();
                if (temp == null) {
                    return null;
                } else {
                    return temp;
                }
            } else {
                AVLTreenode temp = minValueNode(root.getRight());
                root = new AVLTreenode(temp.getProduct());
                root.setRight(deleteNode(root.getRight(), temp.getProduct().getId()));
            }
        }

        root.setHeight(1 + Math.max(height(root.getLeft()), height(root.getRight())));

        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.getLeft()) >= 0)
            return rotateRight(root);
        if (balance < -1 && getBalance(root.getRight()) <= 0)
            return rotateLeft(root);
        if (balance > 1 && getBalance(root.getLeft()) < 0) {
            root.setLeft(rotateLeft(root.getLeft()));
            return rotateRight(root);
        }
        if (balance < -1 && getBalance(root.getRight()) > 0) {
            root.setRight(rotateRight(root.getRight()));
            return rotateLeft(root);
        }

        return root;
    }

    private AVLTreenode minValueNode(AVLTreenode node) {
        AVLTreenode current = node;
        while (current.getLeft() != null)
            current = current.getLeft();
        return current;
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(AVLTreenode node) {
        if (node != null) {
            inOrderRec(node.getLeft());
            System.out.println("Product ID: " + node.getProduct().getId() + ", Name: " + node.getProduct().getName() + ", Price: " + node.getProduct().getPrice());
            inOrderRec(node.getRight());
        }
    }

    public Product findMaxPrice() {
        AVLTreenode current = root;
        while (current.getRight() != null)
            current = current.getRight();
        return current.getProduct();
    }

    public Product findMinPrice() {
        AVLTreenode current = root;
        while (current.getLeft() != null)
            current = current.getLeft();
        return current.getProduct();
    }
}

