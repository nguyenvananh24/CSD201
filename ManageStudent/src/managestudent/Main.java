package managestudent;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        // add student
        manager.addStudent(new Student("S001", "Alice Johnson", 3.5));
        manager.addStudent(new Student("S002", "Bob Smith", 3.9));
        manager.addStudent(new Student("S003", "Charlie Nguyen", 2.8));
        manager.addStudent(new Student("S004", "Diana Evans", 3.7));
        manager.addStudent(new Student("S005", "Eric Wu", 3.2));

        // display list student
        System.out.println("Student List:");
        manager.displayStudents();

        // find top student
        System.out.println("\nStudent with highest GPA:");
        manager.findHighestGPA();

        // find student by id
        System.out.print("\nEnter Student ID to search: ");
        String searchId = scanner.nextLine();
        manager.searchStudent(searchId);

        // sort by GPA
        manager.sortByGPA();

        scanner.close();
    }
}
