package singlylinkedlist;

public class SinglyLinkedList {

    Node head;

    // Hàm thêm một nút vào đầu danh sách
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Thêm vào một vị trí bất kỳ
    public void addAtPosition(int data, int p) {
        Node newNode = new Node(data);
        if (p == 0) {
            addFirst(data);
            return;
        }

        Node temp = head;
        for (int i = 0; i < p - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds");
        } else {
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    // Hàm thêm một nút vào cuối danh sách
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    // Hàm xóa nút cuối danh sách

    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    // Hàm duyệt qua danh sách và in ra các phần tử
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(8);
        list.addFirst(7);
        list.addFirst(4);
        list.display();
    }

}
