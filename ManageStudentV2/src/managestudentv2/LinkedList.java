package managestudentv2;

public class LinkedList {

    Node head;

    // Chèn sinh viên vào danh sách
    public void insert(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Hiển thị tất cả hồ sơ sinh viên
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.student.id + ", Name: " + temp.student.fullName + ", GPA: " + temp.student.gpa);
            temp = temp.next;
        }
    }
    // Tìm sinh viên có GPA cao nhất

    public Student findHighestGPA() {
        if (head == null) {
            return null;
        }
        Student highest = head.student;
        Node temp = head;
        while (temp != null) {
            if (temp.student.gpa > highest.gpa) {
                highest = temp.student;
            }
            temp = temp.next;
        }
        return highest;
    }

    // Tìm sinh viên theo ID
    public Student findById(String id) {
        Node temp = head;
        while (temp != null) {
            if (temp.student.id.equals(id)) {
                return temp.student;
            }
            temp = temp.next;
        }
        return null; // Không tìm thấy
    }
    // Xóa sinh viên theo ID

    public void deleteById(String id) {
        if (head == null) {
            return;
        }

        if (head.student.id.equals(id)) {
            head = head.next;
            return;
        }
        Node current = head;
        Node previous = null;
        while (current != null && !current.student.id.equals(id)) {
            previous = current;
            current = current.next;
        }
        if (current != null) {
            previous.next = current.next;
        }
    }

}
