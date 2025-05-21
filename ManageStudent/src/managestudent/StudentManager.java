package managestudent;
import java.util.ArrayList;
import java.util.List;

class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void findHighestGPA() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        Student topStudent = students.get(0);
        for (Student student : students) {
            if (student.getGpa() > topStudent.getGpa()) {
                topStudent = student;
            }
        }
        System.out.println("Student with highest GPA: " + topStudent);
    }

    public void searchStudent(String id) {
        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id)) {
                System.out.println("Found: " + student);
                return;
            }
        }
        System.out.println("Student ID not found.");
    }

    public void sortByGPA() {
        students.sort((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()));
        System.out.println("\nStudents sorted by GPA (Descending):");
        displayStudents();
    }
}
