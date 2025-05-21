package org.example;

import model.PatientQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientQueue patientQueue = new PatientQueue();

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Register Patient");
            System.out.println("2. Process Patient");
            System.out.println("3. Display Queue");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter patient age: ");
                    int age = scanner.nextInt();
                    patientQueue.registerPatient(name, age);
                    break;
                case 2:
                    patientQueue.processPatient();
                    break;
                case 3:
                    patientQueue.displayQueue();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (true);
    }
}
