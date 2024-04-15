package frl.icekowedd.School_Opdr88.Opdracht_4;// Imports

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import frl.icekowedd.School_Opdr88.Opdracht_4.validator.Mail;
import java.util.logging.Logger;

// Student class
public class Student {

  private String name;
  private String email;
  private String residence;
  private String phoneNumber;
  private int age;
  private int studentNumber;
  private static final List<Student> studentList = new ArrayList<>();

  // Student Constructor.
  public Student(String name, int age, String phoneNumber, String email, String residence, int studentNumber) {
    this.setName(name);
    this.setAge(age);
    this.setPhoneNumber(phoneNumber);
    this.setEmail(email);
    this.setResidence(residence);
    this.setStudentNumber(studentNumber);
  }

  public static List<Student> getStudentList() {
    return studentList;
  }

  // getName Method.
  public String getName() {
    return name;
  }

  // ToString Method is a method that will automatically be used when we want to print an object in Java (so no need to call).
  @Override
  public String toString() {
    return "\nName: (" + getName() + ")\nAge: (" + getAge() + ")\nResidence: (" + getResidence() +
        ")\nEmail: (" + getEmail() + ")\nPhone Number: (" + getPhoneNumber()
        + ")\nStudent Number: (" + getStudentNumber()
        + ")\n";
  }

  // Checks if name is Valid (minimum of 3 char).
  public static boolean isValidName(String name) {
    if (name.length() < 3) {
      return true;
    }
    // Check if the name contains only letters
    for (char c : name.toCharArray()) {
      if (!Character.isLetter(c)) {
        return true;
      }
    }
    return false;
  }

  // Checks if phone Number is valid (10 digits.).
  public static boolean isValidPhoneNumber(String phoneNumber) {
    if (phoneNumber.length() != 10) {
      return true;
    }
    for (char c : phoneNumber.toCharArray()) {
      if (!Character.isDigit(c)) {
        return true;
      }
    }
    return false;
  }

  // checks if student number is valid (4 digits).
  public static boolean isValidStud(int studentNumber) {
    return studentNumber > 9999;
  }

  // this method will create a student object and place it in "studentList".
  public static void addNewStudent(Scanner scanner) {
    Logger logger = Logger.getLogger(Opdracht_4.class.getName());
    String name = getResidence("\nType the name of the person you want to add: ", scanner,
        "Invalid name format. Please try again.");
    int age = getAge(scanner);
    String phoneNumber = getPhoneNumber(scanner);
    String email = getEmail(scanner);
    // Get the residence of the Student.
    String residence = getResidence("\nType the residence of the person you want to add: ", scanner,
        "Invalid residence format. Please try again.");
    int studentNumber = getStudentNumber(scanner);
    // Here the constructor is called and the object will be created and added to ArrayList "studentList"
    Student newStudent = new Student(name, age, phoneNumber, email, residence, studentNumber);
    String message = String.format("""
        %s has been added to your student list.
        """, name);
    getStudentList().add(newStudent);
    logger.info(message);
  }

  private static int getStudentNumber(Scanner scanner) {
    Logger logger = Logger.getLogger(Opdracht_4.class.getName());
    // Get studentNumber of the Student.
    int studentNumber;
    do {
      logger.info("\nType the student number of the person you want to add: ");
      studentNumber = scanner.nextInt(); // GET STUDENT NUMBER
      if (isValidStud(studentNumber)) {
        logger.info("Invalid student number format. Please try again.");
      }
    } while (isValidStud(studentNumber)); // VALIDATOR
    return studentNumber;
  }

  private static String getResidence(String s, Scanner scanner, String x) {
    Logger logger = Logger.getLogger(Opdracht_4.class.getName());
    String residence;
    do {
      logger.info(s);
      residence = scanner.next(); // GET RESIDENCE
      if (isValidName(residence)) {
        logger.info(x);
      }
    } while (isValidName(residence)); // VALIDATOR
    return residence;
  }

  private static String getEmail(Scanner scanner) {
    Logger logger = Logger.getLogger(Opdracht_4.class.getName());
    // Get the email of the Student.
    String email;
    do {
      logger.info("\nType the E-mail address of the person you want to add: ");
      email = scanner.next(); // GET EMAIL.
      if (Mail.isValidEmail(email)) {
        logger.info("Invalid email address format. Please try again.");
      }
    }
    while (Mail.isValidEmail(email)); // VALIDATOR
    return email;
  }

  private static String getPhoneNumber(Scanner scanner) {
    Logger logger = Logger.getLogger(Opdracht_4.class.getName());
    // Get the phone number of the Student.
    String phoneNumber;
    do {
      logger.info("\nEnter phone number (Must contain 10 digits): ");
      phoneNumber = scanner.next(); // GET PHONE NUMBER
      if (isValidPhoneNumber(phoneNumber)) {
        logger.info("Invalid phone number format. Please try again.");
      }
    }
    while (isValidPhoneNumber(phoneNumber)); // VALIDATOR
    return phoneNumber;
  }

  private static int getAge(Scanner scanner) {
    Logger logger = Logger.getLogger(Opdracht_4.class.getName());
    // Get the age of the Student.
    int age = 0;
    boolean isValidInput = false;
    while (!isValidInput) {
      logger.info("\nType the age of the person you want to add: ");
      try {
        age = scanner.nextInt();
        isValidInput = true;
      } // GET AGE
      catch (InputMismatchException e) // CATCH EXCEPTION
      {
        logger.info("Invalid input. Please enter a valid integer.");
        scanner.next();
      }
    }// Clear the invalid input from the scanner
    return age;
  }

  // delete Student from ArrayList "studentList".
  @SuppressWarnings("SuspiciousListRemoveInLoop")
  public static void deleteStudent(Scanner scanner) {
    Logger logger = Logger.getLogger(Opdracht_4.class.getName());
    printStudent();
    logger.info("\nEnter the name of the student you want to delete: ");
    String name = scanner.next();
    boolean found = false;
    for (int i = 0; i < getStudentList().size(); i++) { // LOOP TROUGH STUDENT LIST
      if (getStudentList().get(i).getName().equalsIgnoreCase(name)) {
        getStudentList().remove(i);
        String message = String.format("""
            %s has been deleted from your student list
            """, name);
        logger.info(message);
        found = true;
      }
    }
    if (!found) {
      logger.info("\nStudent not found in the list.");
    }
  }

  // Print Students from ArrayList "studentList"
  public static void printStudent() {
    Logger logger = Logger.getLogger(Opdracht_4.class.getName());
    if (getStudentList().isEmpty()) {
      logger.info("\nYour Student list is empty.");
    } else {
      logger.info("\nYour Student list:\n");
      for (Student student : getStudentList()) // LOOP TROUGH STUDENT LIST.
      {
        logger.info(String.valueOf(student));
      }
      logger.info("\n");
    }
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getResidence() {
    return residence;
  }

  public void setResidence(String residence) {
    this.residence = residence;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getStudentNumber() {
    return studentNumber;
  }

  public void setStudentNumber(int studentNumber) {
    this.studentNumber = studentNumber;
  }
}
