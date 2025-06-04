package org.example;

public class StudentBST {
        private Node root;

        public StudentBST() {
            this.root = null;
        }

        public void insert(Student student) {
            root = insertRec(root, student);
        }

        private Node insertRec(Node root, Student student) {
            if (root == null) {
                root = new Node(student);
                return root;
            }

            if (student.studentID.compareTo(root.student.studentID) < 0) {
                root.left = insertRec(root.left, student);
            } else if (student.studentID.compareTo(root.student.studentID) > 0) {
                root.right = insertRec(root.right, student);
            }
            return root;
        }

        public void traverseInOrder() {
            traverseInOrderRec(root);
        }

        private void traverseInOrderRec(Node root) {
            if (root != null) {
                traverseInOrderRec(root.left);
                System.out.println(root.student.studentID + ": " + root.student.name + " - " + root.student.score);
                traverseInOrderRec(root.right);
            }
        }

        public Student search(String studentID) {
            return searchRec(root, studentID);
        }

        private Student searchRec(Node root, String studentID) {
            if (root == null || root.student.studentID.equals(studentID)) {
                return root != null ? root.student : null;
            }
            return studentID.compareTo(root.student.studentID) < 0 ?
                    searchRec(root.left, studentID) :
                    searchRec(root.right, studentID);
        }

        public void delete(String studentID) {
            root = deleteRec(root, studentID);
        }

        private Node deleteRec(Node root, String studentID) {
            if (root == null) return root;

            if (studentID.compareTo(root.student.studentID) < 0) {
                root.left = deleteRec(root.left, studentID);
            } else if (studentID.compareTo(root.student.studentID) > 0) {
                root.right = deleteRec(root.right, studentID);
            } else {
                if (root.left == null) return root.right;
                else if (root.right == null) return root.left;

                root.student = minValue(root.right);
                root.right = deleteRec(root.right, root.student.studentID);
            }
            return root;
        }

        private Student minValue(Node root) {
            Student minv = root.student;
            while (root.left != null) {
                minv = root.left.student;
                root = root.left;
            }
            return minv;
        }

        public Student findMaxScore() {
            return findMaxScoreRec(root);
        }

        private Student findMaxScoreRec(Node root) {
            if (root == null) return null;
            Student rightMax = findMaxScoreRec(root.right);
            if (rightMax != null && rightMax.score > root.student.score) {
                return rightMax;
            }
            return root.student;
        }
    }


