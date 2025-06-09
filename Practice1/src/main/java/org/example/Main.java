package org.example;

public class Main {
    public static void main(String[] args) {

        BST bst = new BST();
        bst.insert(new Employee(104, "Nam Nguyen", "HR", 5));
        bst.insert(new Employee(102, "Linh Phan", "IT", 1));
        bst.insert(new Employee(103, "Minh Le", "Finance", 3));
        bst.insert(new Employee(101, "Ngoc Nguyen", "IT", 6));
        bst.insert(new Employee(107, "Huong Pham", "Finance", 3));
        bst.insert(new Employee(106, "Tuan Tran", "Finance", 2));
        bst.insert(new Employee(108, "Hang Le", "IT", 4));
        bst.insert(new Employee(105, "Hung Nguyen", "IT", 5));

        System.out.println("In-order traversal of the BST:");
        bst.inOrder();

        Employee foundEmployee = bst.search("Minh Le");
        if (foundEmployee != null) {
            System.out.println("Found employee: " + foundEmployee.name);
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("Is the BST balanced? " + bst.checkBalance());

        bst.delete(108);
        System.out.println("In-order traversal after deleting employee with ID 108:");
        bst.inOrder();
        System.out.println("Is the BST balanced? " + bst.checkBalance());

        Employee maxSeniorityEmployee = bst.findMaxSeniority();
        if (maxSeniorityEmployee != null) {
            System.out.println("Employee with highest seniority: " + maxSeniorityEmployee.name + " with seniority " + maxSeniorityEmployee.seniority);
        }
    }
}
