package org.example;

public class Student {
    String studentID;
    String name;
    int score;

    public Student(String studentID, String name, int score) {
        this.studentID = studentID;
        this.name = name;
        this.score = score;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

