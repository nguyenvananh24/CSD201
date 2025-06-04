package org.example;

public class Main {
    public static void main(String[] args) {
        StudentBST bst = new StudentBST();

        bst.insert(new Student("S001", "Alice", 85));
        bst.insert(new Student("S002", "Bob", 92));
        bst.insert(new Student("S003", "Charlie", 78));

        System.out.println("Danh sách sinh viên:");
        bst.traverseInOrder();

        String searchID = "S002";
        Student foundStudent = bst.search(searchID);
        if (foundStudent != null) {
            System.out.println("Thông tin sinh viên tìm thấy: " + foundStudent.studentID + " - " + foundStudent.name + " - " + foundStudent.score);
        } else {
            System.out.println("Không tìm thấy sinh viên với ID: " + searchID);
        }

        String deleteID = "S003";
        bst.delete(deleteID);
        System.out.println("Danh sách sinh viên sau khi xóa:");
        bst.traverseInOrder();

        Student maxScoreStudent = bst.findMaxScore();
        if (maxScoreStudent != null) {
            System.out.println("Sinh viên có điểm cao nhất: " + maxScoreStudent.studentID + " - " + maxScoreStudent.name + " - " + maxScoreStudent.score);
        }
    }
}
