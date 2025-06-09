package org.example;

public class BST {

    Node root;

    public void insert(Employee employee) {
        root = insertRec(root, employee);
    }

    private Node insertRec(Node root, Employee employee) {
        if (root == null) {
            root = new Node(employee);
            return root;
        }
        if (employee.id < root.employee.id) {
            root.left = insertRec(root.left, employee);
        } else if (employee.id > root.employee.id) {
            root.right = insertRec(root.right, employee);
        }
        return root;
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.employee.id + " " + root.employee.name + " " + root.employee.department + " " + root.employee.seniority);
            inOrderRec(root.right);
        }
    }

    public Employee search(String name) {
        return searchRec(root, name);
    }

    private Employee searchRec(Node root, String name) {
        if (root == null || root.employee.name.equals(name)) {
            return root != null ? root.employee : null;
        }
        Employee leftSearch = searchRec(root.left, name);
        return (leftSearch != null) ? leftSearch : searchRec(root.right, name);
    }

    public void delete(int id) {
        root = deleteRec(root, id);
    }

    private Node deleteRec(Node root, int id) {
        if (root == null) return root;

        if (id < root.employee.id) {
            root.left = deleteRec(root.left, id);
        } else if (id > root.employee.id) {
            root.right = deleteRec(root.right, id);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            root.employee = minValue(root.right);
            root.right = deleteRec(root.right, root.employee.id);
        }
        return root;
    }

    private Employee minValue(Node root) {
        Employee minv = root.employee;
        while (root.left != null) {
            minv = root.left.employee;
            root = root.left;
        }
        return minv;
    }

    public boolean checkBalance() {
        return checkBalanceRec(root) != -1;
    }

    private int checkBalanceRec(Node root) {
        if (root == null) return 0;

        int leftHeight = checkBalanceRec(root.left);
        if (leftHeight == -1) return -1;

        int rightHeight = checkBalanceRec(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public Employee findMaxSeniority() {
        return findMaxSeniorityRec(root);
    }

    private Employee findMaxSeniorityRec(Node root) {
        if (root == null) return null;

        Employee maxEmployee = root.employee;
        Employee leftMax = findMaxSeniorityRec(root.left);
        Employee rightMax = findMaxSeniorityRec(root.right);

        if (leftMax != null && leftMax.seniority > maxEmployee.seniority) {
            maxEmployee = leftMax;
        }
        if (rightMax != null && rightMax.seniority > maxEmployee.seniority) {
            maxEmployee = rightMax;
        }
        return maxEmployee;
    }
}

