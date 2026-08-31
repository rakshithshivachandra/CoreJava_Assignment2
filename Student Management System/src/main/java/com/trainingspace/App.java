package com.trainingspace;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class App 
{
    private static final Scanner sc = new Scanner(System.in);
    private static final HashMap<Integer, Student> studentMap = new HashMap<>();
    private static final LinkedHashMap<Integer, Student> linkedStudentMap = new LinkedHashMap<>();

    public static void main( String[] args )    {

        initialiseSampleData();

        int choice;
        do {
            System.out.println("--------------------------------------------------------------");
            displayMenu();
            System.out.println("--------------");
            System.out.print("Enter action ID: ");
            choice = sc.nextInt();
            System.out.println("--------------");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    removeStudent();
                    break;
                case 6:
                    displayStudentsByDepartment();
                    break;
                case 7:
                    displayTopStudent();
                    break;
                case 8:
                    displayStudentMap();
                    break;
                case 9:
                    searchStudentUsingMap();
                    break;
                case 10:
                    displayLinkedHashMapStudents();
                    break;
                case 0:
                    System.out.println("Exiting Program");
                    break;
                default:
                    System.out.println("Invalid choice - enter a number between 0 and 10");
            }
        }while (choice != 0);

    }

    /*
     * Display menu for the application
     * */
    private static void displayMenu(){
        System.out.println("=========================================");
        System.out.println("        Student Management System");
        System.out.println("=========================================");
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Remove Student");
        System.out.println("6. Display Students by Department");
        System.out.println("7. Display Top Student");
        System.out.println("8. Display Student Map (Hashmap)");
        System.out.println("9. Search Student Using Map");
        System.out.println("10. Display Students Using LinkedHashMap");
        System.out.println("0. Exit");
    }

    /*
     * Initialise sample data for application
     * */
    private static void initialiseSampleData(){
        int inputId = 101;
        String inputName = "Ravi";
        int inputAge = 20;
        String inputDepartment = "CSE";
        double inputMarks = 85.5;

        Student newStudent = new Student(inputId, inputName, inputAge, inputDepartment, inputMarks);

        studentMap.put(inputId, newStudent);
        linkedStudentMap.put(inputId, newStudent);
    }

    /*
    * Add student method
    * */
    private static void addStudent() {

        System.out.print("Enter Student ID: ");
        int inputId = sc.nextInt();
        if(inputId <= 0){
            System.out.println("Invalid Student ID.");
            return;
        }

        if(studentMap.containsKey(inputId)){
            System.out.println("Student ID already exists.");
            return;
        }

        sc.nextLine();
        String inputName = readNonEmpty("Student Name: ");
        if (inputName == null) return;

        System.out.print("Enter Age: ");
        int inputAge = sc.nextInt();

        if (inputAge <= 0 || inputAge >= 150){
            System.out.println("Invalid Age.");
            return;
        }

        sc.nextLine();
        String inputDepartment = readNonEmpty("Department: ");
        if (inputDepartment == null) return;

        double inputMarks = validateMarks("Enter Marks: ");
        if (Double.isNaN(inputMarks)) return;

        Student newStudent = new Student(inputId, inputName, inputAge, inputDepartment, inputMarks);

        studentMap.put(inputId, newStudent);
        linkedStudentMap.put(inputId, newStudent);

        System.out.println("Student added successfully.");
    }

    /*
    * Display all students method
    * */
    private static void displayAllStudents(){
        if(studentMap.isEmpty()){
            System.out.println("No Students to display");
            return;
        }
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-15s %-10s%n","ID", "Name", "Age", "Department", "Marks");

        System.out.println("------------------------------------------------------------");

        for(Student temp: studentMap.values()){
            System.out.printf("%-10d %-10s %-10d %-15s %-10.1f%n",temp.getStudentId(),
                    temp.getStudentName(), temp.getAge(), temp.getDepartment(), temp.getMarks());
        }
        System.out.println("------------------------------------------------------------");
    }

    /*
     * Method to search for an individual student
     * */
    private static void searchStudent(){
        if(studentMap.isEmpty()) {
            System.out.println("No Students to display");
            return;
        }

        System.out.print("Enter Student ID: ");
        int inputId = sc.nextInt();
        Student temp = studentMap.get(inputId);

        if (temp == null){
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Student Found");
        temp.displayStudent();
    }

    /*
     * Method to update student record
     * */
    private static void updateStudent(){

        if(studentMap.isEmpty()) {
            System.out.println("No Students to display");
            return;
        }

        System.out.print("Enter Student ID: ");
        int inputID = sc.nextInt();
        Student temp = studentMap.get(inputID);

        if (temp == null){
            System.out.println("Student not found.");
            return;
        }

        sc.nextLine();
        String inputName = readNonEmpty("New Name: ");
        if (inputName == null) return;

        System.out.print("Enter New Age: ");
        int inputAge = sc.nextInt();

        if (inputAge <= 0 || inputAge >= 150){
            System.out.println("Invalid Age.");
            return;
        }

        sc.nextLine();
        String inputDepartment = readNonEmpty("New Department: ");
        if (inputDepartment == null) return;

        double inputMarks = validateMarks("Enter New Marks: ");
        if (Double.isNaN(inputMarks)) return;

        Student updated = new Student(inputID, inputName, inputAge, inputDepartment, inputMarks);
        studentMap.put(inputID, updated);
        linkedStudentMap.put(inputID, updated);

        System.out.println("Student updated successfully.");
    }

    /*
     * Method to update student record
     * */
    private static void removeStudent(){

        if(studentMap.isEmpty()) {
            System.out.println("No Students to display");
            return;
        }

        System.out.println("Enter Student ID: ");
        int inputID = sc.nextInt();
        Student temp = studentMap.get(inputID);

        if (temp == null){
            System.out.println("Student not found.");
            return;
        }

        studentMap.remove(inputID);
        linkedStudentMap.remove(inputID);

        System.out.println("Student removed successfully.");
    }

    /*
     * Method for displaying student by department
     * */
    private static void displayStudentsByDepartment(){
        sc.nextLine();
        String inputDepartment = readNonEmpty("Department: ");
        if (inputDepartment == null) return;

        System.out.println("-------------"+ inputDepartment + " Students -------------");

        boolean results = false;
        for (Student temp: studentMap.values()){
            if (temp.getDepartment().equalsIgnoreCase(inputDepartment)){
                System.out.printf("%-10d %-10s %-10s %-10.1f%n", temp.getStudentId(), temp.getStudentName(),
                        temp.getDepartment(), temp.getMarks());
                results = true;
            }
        }

        if (!results){
            System.out.println("No students in the department");
        }
    }

    /*
    * Method for displaying top student
    * */
    private static void displayTopStudent(){
        if(studentMap.isEmpty()) {
            System.out.println("No Students to display");
            return;
        }

        Student tempTop = null;
        for (Student temp: studentMap.values()){
            if (tempTop == null || temp.getMarks() > tempTop.getMarks()){
                tempTop = temp;
            }
        }

        System.out.println("=============================");
        System.out.println("        Top Student");
        System.out.println("=============================");
        tempTop.displayStudent();
        System.out.println("=============================");
    }

    /*
    * Method for displaying student map
    * */
    private static void displayStudentMap(){
        if(studentMap.isEmpty()) {
            System.out.println("No Students to display");
            return;
        }

        System.out.println("=============================");
        System.out.println("        Student Map");
        System.out.println("=============================");

        for (Student temp: studentMap.values()){
            System.out.println(temp.getStudentId() + " -> " + temp.getStudentName());
        }
    }

    /*
    * Method to search student using HashMap
    * */
    private static void searchStudentUsingMap(){
        if(studentMap.isEmpty()) {
            System.out.println("No Students to display");
            return;
        }

        System.out.print("Enter Student ID: ");
        int inputId = sc.nextInt();
        Student temp = studentMap.get(inputId);

        if (temp == null){
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Student Found");
        temp.displayStudent();
    }

    /*
    * Method to display students using LinkedHashMap
    * */
    private static void displayLinkedHashMapStudents(){
        if(linkedStudentMap.isEmpty()) {
            System.out.println("No Students to display");
            return;
        }

        for (Student temp: linkedStudentMap.values()){
            System.out.println(temp.getStudentId() + " -> " + temp.getStudentName());
        }

    }


    //-------------  Validation Methods
   /*
     * Method for validating input data is not NULL for name and department
     * */
    private static String readNonEmpty(String query) {
        System.out.print("Enter "+ query);
        String inputValue = sc.nextLine();

        if(inputValue.isEmpty()){
            System.out.println(query + " cannot be empty.");
            return null;
        }
        return inputValue;
    }

    /*
     * Method for validating marks input on screen
     * */
    private static double validateMarks(String query){
        System.out.print(query);
        double marks = sc.nextDouble();
        if (marks < 0 || marks > 100){
            System.out.println("Marks should be between 0 and 100.");
            return Double.NaN;
        }
        return marks;
    }
}
