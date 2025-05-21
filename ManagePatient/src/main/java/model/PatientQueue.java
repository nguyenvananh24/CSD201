package model;

import java.util.LinkedList;

public class PatientQueue {
    private LinkedList<Patient> queue;

    public PatientQueue() {
        queue = new LinkedList<>();
    }

    public void registerPatient(String name, int age) {
        Patient patient = new Patient(name, age);
        queue.addLast(patient);
        System.out.println("Registered patient: " + patient);
    }

    public void processPatient() {
        if (!queue.isEmpty()) {
            Patient patient = queue.removeFirst();
            System.out.println("Processing patient: " + patient);
        } else {
            System.out.println("Queue is empty!");
        }
    }

    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            System.out.println("Current queue status:");
            for (Patient patient : queue) {
                System.out.println(patient);
            }
        }
    }
}
