package com.mycompany.managingstudentrecordsusingsinglylinkedlist;

class AVLTreenode {
    private Product product;
    private AVLTreenode left;
    private AVLTreenode right;
    private int height;

    public AVLTreenode(Product product) {
        this.product = product;
        this.height = 1; // New node is initially added at leaf
    }

    public Product getProduct() {
        return product;
    }

    public AVLTreenode getLeft() {
        return left;
    }

    public void setLeft(AVLTreenode left) {
        this.left = left;
    }

    public AVLTreenode getRight() {
        return right;
    }

    public void setRight(AVLTreenode right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
