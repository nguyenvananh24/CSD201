package managestudentv2;

public class ManageStudentV2 {

    public static void main(String[] args) {
        LinkedList studentList = new LinkedList();
        studentList.insert(new Student("S001", "Alice Johnson", 3.5));
        studentList.insert(new Student("S002", "Bob Smith", 3.9));
        studentList.insert(new Student("S003", "Charlie Nguyen", 2.8));
        studentList.insert(new Student("S004", "Diana Evans", 3.7));
        studentList.insert(new Student("S005", "Eric Wu", 3.2));

        System.out.println("All Students:");
        studentList.display();

        // Tìm sinh viên có GPA cao nhất
        Student highestGPAStudent = studentList.findHighestGPA();
        if (highestGPAStudent != null) {
            System.out.println("\nStudent with Highest GPA:");
            System.out.println("ID: " + highestGPAStudent.id + ", Name: " + highestGPAStudent.fullName + ", GPA: " + highestGPAStudent.gpa);
        }
        
        // Tìm sinh viên theo ID
        String searchId = "S003";
        Student foundStudent = studentList.findById(searchId);
        if (foundStudent != null) {
            System.out.println("\nFound Student:");
            System.out.println("ID: " + foundStudent.id + ", Name: " + foundStudent.fullName + ", GPA: " + foundStudent.gpa);
        } else {
            System.out.println("\nStudent with ID " + searchId + " not found.");
        }
        
         // Xóa sinh viên theo ID
        studentList.deleteById("S002");
        System.out.println("\nAfter Deleting ID S002:");
        studentList.display();
    }

}
