// Imports
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


// Student class - What defines A student?
public class Student {
  public String name, email, residence, phoneNumber;
  public int age, studentNumber;
  public static ArrayList<Student> studentList = new ArrayList<>();


  // Student Constructor.
  public Student(String name, int age, String phoneNumber, String email, String residence, int studentNumber) {
    this.name = name;
    this.age = age;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.residence = residence;
    this.studentNumber = studentNumber; }


  // getName Method.
  public String getName() { return name; }


  // ToString Method is a method that will automatically be used when we want to print an object in Java (so no need to call).
  @Override public String toString() {
    return "\nName: (" + name + ")\nAge: (" + age + ")\nResidence: (" + residence +
        ")\nEmail: (" + email + ")\nPhone Number: (" + phoneNumber + ")\nStudent Number: (" + studentNumber + ")\n"; }


  // Here come some small methods that check if something is valid.
  // Checks if email address is valid.
  public static boolean isValidEmail(String email) {
    String emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
    return !email.matches(emailRegex); }


  // Checks if name is Valid (minimum of 3 char).
  public static boolean isValidName(String name) {
    if (name.length() < 3) { return true; }
    // Check if the name contains only letters
    for (char c : name.toCharArray()) { if (!Character.isLetter(c)) { return true; } } return false; }


  // Checks if phone Number is valid (10 digits.).
  public static boolean isValidPhoneNumber(String phoneNumber) {
    if (phoneNumber.length() != 10) { return true; } for (char c : phoneNumber.toCharArray()) {
      if (!Character.isDigit(c)) { return true; } } return false; }


  // checks if student number is valid (4 digits).
  public static boolean isValidStud(int studentNumber) { if (studentNumber > 9999) {return true; } return false;}



  // Here come the control methods.
  // this method will create a student object and place it in "studentList".
  public static void addNewStudent(Scanner scanner) {
    String name; do { // Get the name of the Student.
      System.out.print("\nType the name of the person you want to add: ");
      name = scanner.next(); // GET NAME
      if (isValidName(name)) {
        System.out.println("Invalid name format. Please try again.");}}
    while (isValidName(name)); // VALIDATOR


    // Get the age of the Student.
    int age = 0; boolean isValidInput = false; while (!isValidInput) {
      System.out.print("\nType the age of the person you want to add: ");
      try { age = scanner.nextInt(); isValidInput = true; } // GET AGE
      catch (InputMismatchException e) // CATCH EXCEPTION
      {System.out.println("Invalid input. Please enter a valid integer.");
        scanner.next(); } }// Clear the invalid input from the scanner


    // Get the phone number of the Student.
    String phoneNumber; do {
    System.out.print("\nEnter phone number (Must contain 10 digits): ");
    phoneNumber = scanner.next(); // GET PHONE NUMBER
      if (isValidPhoneNumber(phoneNumber)) {
        System.out.println("Invalid phone number format. Please try again.");}}
    while (isValidPhoneNumber(phoneNumber)); // VALIDATOR


    // Get the email of the Student.
    String email; do {
    System.out.print("\nType the E-mail address of the person you want to add: ");
      email = scanner.next(); // GET EMAIL.
      if (isValidEmail(email)) { System.out.println("Invalid email address format. Please try again.");}}
    while (isValidEmail(email)); // VALIDATOR


    // Get the residence of the Student.
    String residence; do {
    System.out.print("\nType the residence of the person you want to add: ");
    residence = scanner.next(); // GET RESIDENCE
    if (isValidName(residence)) { System.out.println("Invalid residence format. Please try again.");
    } } while (isValidName(residence)); // VALIDATOR


    // Get studentNumber of the Student.
    int studentNumber; do {
    System.out.print("\nType the student number of the person you want to add: ");
    studentNumber = scanner.nextInt(); // GET STUDENT NUMBER
      if (isValidStud(studentNumber)) { System.out.println("Invalid student number format. Please try again.");
      } } while (isValidStud(studentNumber)); // VALIDATOR


    // Here the constructor is called and the object will be created and added to ArrayList "studentList"
    Student newStudent = new Student(name, age, phoneNumber, email, residence, studentNumber);
    studentList.add(newStudent); System.out.println("\n" + name + " has been added to your student list.\n"); }


  // delete Student from ArrayList "studentList".
  @SuppressWarnings("SuspiciousListRemoveInLoop")
  public static void deleteStudent(Scanner scanner) {
    printStudent();
    System.out.print("\nEnter the name of the student you want to delete: ");
    String name = scanner.next(); boolean found = false;
    for (int i = 0; i < studentList.size(); i++) { // LOOP TROUGH STUDENT LIST
      if (studentList.get(i).getName().equalsIgnoreCase(name)) { studentList.remove(i);
        System.out.println("\n" + name + " has been deleted from your student list.\n");
        found = true; } } if (!found) { System.out.println("\nStudent not found in the list."); } }


  // Getter method for studentNumber
  public int getStudentNumber() {
    return studentNumber;
  }


  // Print Students from ArrayList "studentList"
  public static void printStudent() {
    if (studentList.isEmpty()) { System.out.println("\nYour Student list is empty.");
    } else { System.out.println("\nYour Student list:\n"); for (Student student : studentList) // LOOP TROUGH STUDENT LIST.
    { System.out.println(student); } System.out.println(); } } }
