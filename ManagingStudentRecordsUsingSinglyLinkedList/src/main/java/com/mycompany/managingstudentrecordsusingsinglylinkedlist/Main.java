package com.mycompany.managingstudentrecordsusingsinglylinkedlist;

public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.insert(new Product(1, "Product A", 100.0));
        tree.insert(new Product(2, "Product B", 150.0));
        tree.insert(new Product(3, "Product C", 80.0));
        tree.insert(new Product(4, "Product D", 200.0));

        System.out.println("In-order traversal of the AVL tree:");
        tree.inOrder();

        Product maxPriceProduct = tree.findMaxPrice();
        System.out.println("Product with max price: " + maxPriceProduct.getName() + " - " + maxPriceProduct.getPrice());

        Product minPriceProduct = tree.findMinPrice();
        System.out.println("Product with min price: " + minPriceProduct.getName() + " - " + minPriceProduct.getPrice());

        tree.deleteNode(2);
        System.out.println("In-order traversal after deleting product with ID 2:");
        tree.inOrder();
    }
}

