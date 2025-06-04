package org.example;

public class Node {
        Student student;
        Node left;
        Node right;

        public Node(Student student) {
            this.student = student;
            this.left = null;
            this.right = null;
        }
}
