package com.trainingspace;

public class Student {

    int studentId;
    String studentName;
    int age;
    String department;
    double marks;

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

    public String getstudentName() {
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
        System.out.println("ID           : " + studentId);
        System.out.println("Name         : " + studentName);
        System.out.println("Age          : " + age);
        System.out.println("Department   : " + department);
        System.out.println("Marks        : " + marks);
    }
}
