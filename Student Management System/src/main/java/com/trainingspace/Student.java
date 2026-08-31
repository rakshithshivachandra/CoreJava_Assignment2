package com.trainingspace;

public class Student {

    private int studentId;
    private String studentName;
    private int age;
    private String department;
    private double marks;

    public Student(int studentId, String studentName, int age, String department, double marks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.department = department;
        this.marks = marks;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public double getMarks() {
        return marks;
    }

    public void displayStudent(){
        System.out.println("ID           : " + getStudentId());
        System.out.println("Name         : " + getStudentName());
        System.out.println("Age          : " + getAge());
        System.out.println("Department   : " + getDepartment());
        System.out.println("Marks        : " + getMarks());
    }
}
