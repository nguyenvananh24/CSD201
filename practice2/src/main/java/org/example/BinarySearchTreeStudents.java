package org.example;
import java.util.*;

public class BinarySearchTreeStudents {

    static class Student {
        int rollNumber;
        double score;

        Student(int rollNumber, double score) {
            this.rollNumber = rollNumber;
            this.score = score;
        }

        @Override
        public String toString() {
            return "(" + rollNumber + ", " + score + ")";
        }
    }

    static class BSTNode {
        Student data;
        BSTNode left, right;

        BSTNode(Student data) {
            this.data = data;
            left = right = null;
        }
    }

    static class BST {
        BSTNode root;

        BST() {
            root = null;
        }

        public void insert(Student student) {
            BSTNode newNode = new BSTNode(student);
            if (root == null) {
                root = newNode;
                return;
            }
            BSTNode current = root;
            BSTNode parent = null;
            while (current != null) {
                parent = current;
                if (student.rollNumber < current.data.rollNumber) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            if (student.rollNumber < parent.data.rollNumber) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
        }

        public double averageScore() {
            if (root == null) return 0.0;
            class Accumulator {
                double sum = 0.0;
                int count = 0;
            }
            Accumulator acc = new Accumulator();

            Deque<BSTNode> stack = new ArrayDeque<>();
            BSTNode current = root;
            while (current != null || !stack.isEmpty()) {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                current = stack.pop();
                acc.sum += current.data.score;
                acc.count++;
                current = current.right;
            }
            return acc.count == 0 ? 0.0 : acc.sum / acc.count;
        }

        public List<Student> inOrderTraversal() {
            List<Student> result = new ArrayList<>();
            Deque<BSTNode> stack = new ArrayDeque<>();
            BSTNode current = root;
            while (current != null || !stack.isEmpty()) {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                current = stack.pop();
                result.add(current.data);
                current = current.right;
            }
            return result;
        }
    }

    static class BalancedBSTBuilder {
        static class Frame {
            int start, end;
            BSTNode parent;
            boolean isLeft;
            Frame(int s, int e, BSTNode p, boolean left) {
                start = s; end = e; parent = p; isLeft = left;
            }
        }

        public static BST createBalancedBSTFromSortedList(List<Student> sortedList) {
            BST bst = new BST();
            if (sortedList == null || sortedList.size() == 0) return bst; // cây rỗng

            Deque<Frame> stack = new ArrayDeque<>();
            BSTNode root = null;

            stack.push(new Frame(0, sortedList.size() - 1, null, false));

            while (!stack.isEmpty()) {
                Frame frame = stack.pop();
                int start = frame.start;
                int end = frame.end;
                if (start > end) continue;

                int mid = start + (end - start) / 2;
                BSTNode newNode = new BSTNode(sortedList.get(mid));

                if (frame.parent == null) {
                    root = newNode;
                } else {
                    if (frame.isLeft) {
                        frame.parent.left = newNode;
                    } else {
                        frame.parent.right = newNode;
                    }
                }

                stack.push(new Frame(mid + 1, end, newNode, false));
                stack.push(new Frame(start, mid - 1, newNode, true));
            }

            bst.root = root;
            return bst;
        }
    }

    static int height(BSTNode root) {
        if (root == null) return 0;
        Queue<BSTNode> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                BSTNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            height++;
        }
        return height;
    }

    public static void main(String[] args) {
        Student[] A = {
                new Student(5, 5.5),
                new Student(3, 3.3),
                new Student(2, 2.2),
                new Student(4, 4.4),
                new Student(7, 7.7),
                new Student(6, 6.6),
                new Student(8, 8.8),
                new Student(1, 1.1),
                new Student(9, 9.9),
                new Student(10, 10.0)
        };

        BST T = new BST();
        for (Student s : A) {
            T.insert(s);
        }

        double avg = T.averageScore();
        System.out.printf("Average score of BST T: %.2f\n", avg);

        List<Student> B = T.inOrderTraversal();
        System.out.println("Students in-order (sorted by rollNumber): " + B);

        BST T2 = BalancedBSTBuilder.createBalancedBSTFromSortedList(B);

        int h = height(T2.root);
        System.out.println("Height of balanced BST T2: " + h);
    }
}

