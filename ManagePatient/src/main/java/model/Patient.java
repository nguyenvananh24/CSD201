package model;

public class Patient {

    String name;
    int age;

    Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }

}
