package frl.icekowedd.opdrachten.opdracht_4;
// Imports

import static java.util.logging.Logger.getLogger;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class SkoolClasses {

  private final String name;
  public static final String messageAvailableClasses = "Available classes:";
  public static final String messageCounselNum = "Counsellor number: ";
  public static final String messageStudNum = "Student number: ";
  public static final String mes = "%d. %s";
  private final ArrayList<Student> classStudents;
  private final ArrayList<Counsellor> classCounsellor;
  static final List<SkoolClasses> allClasses = new ArrayList<>();

  private ArrayList<Counsellor> getClassCounsellor() {
    return classCounsellor;
  }

  private ArrayList<Student> getClassStudents() {
    return classStudents;
  }

  public SkoolClasses(String name) {
    this.name = name;
    this.classStudents = new ArrayList<>();
    this.classCounsellor = new ArrayList<>();
  }

  public static void addToClass(Scanner scanner) {
    Logger logger = getLogger(Opdracht_4.class.getName());
    logger.info(messageAvailableClasses); // Print all available classes
    for (SkoolClasses skoolClass : allClasses) {
      logger.info("- " + skoolClass.getName());
    }
    // Prompt the user to enter the name of the class
    logger.info("Enter the name of the class to add students and counsellors: ");
    String className = scanner.next();
    // Check if the entered class name is valid
    SkoolClasses selectedClass = null;
    for (SkoolClasses skoolClass : allClasses) {
      if (skoolClass.getName().equalsIgnoreCase(className)) {
        selectedClass = skoolClass;
        break;
      }
    }
    if (selectedClass != null) {  // If the class name is valid, add students and counsellors
      addStudent2(scanner, selectedClass); // Add students to the class
      addCounsellor2(scanner, selectedClass); // Add counsellors to the class
    } else {
      logger.info("Invalid class name. Please enter a valid class name from the list.");
    }
  }

  public static void printClasses() {
    Logger logger = Logger.getLogger(Opdracht_4.class.getName());
    if (allClasses.isEmpty()) {
      logger.info("No classes available.");
    } else {
      logger.info("List of Classes:");
      for (SkoolClasses skoolClass : allClasses) {
        logger.info(skoolClass.getName());
        logger.info("Students:");
        for (Student student : skoolClass.getClassStudents()) {
          logger.info("- " + student.getName());
        } // print students of class.
        logger.info("Counsellor:");
        ArrayList<Counsellor> classCounsellor = skoolClass.getClassCounsellor();
        if (!classCounsellor.isEmpty()) {
          logger.info("- " + classCounsellor.getFirst()
              .getName()); // print the first counsellor that has been appointed. (if 2 or more accidentally have been appointed)
        } else {
          logger.info("- None");
        }
        logger.info("\n");
      }
    }
  } // Print None of no counsellors have been appointed.

  public static void addNewClass(Scanner scanner) {
    Logger logger = Logger.getLogger(Opdracht_4.class.getName());
    logger.info("Enter the name of the class: "); // Get the name of the class
    String className = scanner.next();
    SkoolClasses newClass = new SkoolClasses(className);
    String message = String.format("New class %s has been added.", className);
    allClasses.add(newClass);
    logger.info(message);
    addStudent2(scanner, newClass);// Choose students for the class
    addCounsellor2(scanner, newClass);
  }// Choose counsellor for the class

  public static void addStudent2(Scanner scanner, SkoolClasses selectedClass) {
    Logger logger = Logger.getLogger(Opdracht_4.class.getName());
    boolean addingStudents;
    addingStudents = true;
    if (addingStudents) {
      do {
        // Display students who are not already in the class
        ArrayList<Student> availableStudents = studentsToAvaiArray(selectedClass);
        int studentIndex = 0;
        boolean isValidInput = false;
        studentIndex = getStudentIndex(isValidInput, messageStudNum, studentIndex, scanner);
        scanner.nextLine();
        if (studentIndex == 0) {
          addingStudents = false;
        } else if (studentIndex > 0 && studentIndex <= availableStudents.size()) {
          Student selectedStudent = availableStudents.get(studentIndex - 1);
          selectedClass.addStudent(selectedStudent);
          logger.info(selectedStudent.getName() + " added to the class.");
        } else {
          logger.info("Invalid student number. Please try again.");
        }
      } while (addingStudents);
    }
  }

  private static int getStudentIndex(boolean isValidInput, String s, int studentIndex,
      Scanner scanner) {
    Logger logger = Logger.getLogger(Opdracht_4.class.getName());
    while (!isValidInput) {
      logger.info(s);
      try {
        studentIndex = scanner.nextInt();
        isValidInput = true;
      } // Get student number
      catch (InputMismatchException e) // CATCH EXCEPTION
      {
        logger.info("Invalid input. Please enter a valid integer.");
        scanner.next();
      }
    }// Clear the invalid input from the scanner
    return studentIndex;
  }

  private static ArrayList<Student> studentsToAvaiArray(SkoolClasses selectedClass) {
    Logger logger = Logger.getLogger(Opdracht_4.class.getName());
    logger.info("Select students to add to the class (Enter student number or 0 to finish):");
    ArrayList<Student> availableStudents = new ArrayList<>();
    for (Student student : Student.getStudentList()) {
      if (!selectedClass.getClassStudents().contains(student)) {
        availableStudents.add(student);
      }
    }
    for (int i = 0; i < availableStudents.size(); i++) {
      String message = String.format(mes, i + 1, availableStudents.get(i).getName());
      logger.info(message);
    }
    return availableStudents;
  }

  public static void addCounsellor2(Scanner scanner, SkoolClasses selectedClass) {
    Logger logger = Logger.getLogger(Opdracht_4.class.getName());
    logger.info("Select a counsellor to add to the class:");
    ArrayList<Counsellor> availableCounsellors = new ArrayList<>();
    for (Counsellor counsellor : Counsellor.getCounsellors()) {
      if (!selectedClass.getClassCounsellor().contains(counsellor)) {
        availableCounsellors.add(counsellor);
      }
    }
    for (int i = 0; i < availableCounsellors.size(); i++) {
      String message = String.format(mes, i + 1, availableCounsellors.get(i).getName());
      logger.info(message);
    }
    int counsellorIndex = 0;
    boolean isValidInput = false;
    counsellorIndex = getStudentIndex(isValidInput, messageCounselNum, counsellorIndex, scanner);
    if (counsellorIndex > 0 && counsellorIndex <= availableCounsellors.size()) {
      Counsellor selectedCounsellor = availableCounsellors.get(counsellorIndex - 1);
      selectedClass.addCounsellor(selectedCounsellor);
      logger.info(selectedCounsellor.getName() + " added as the counsellor for the class.");
    } else {
      logger.info("Invalid counsellor number. No counsellor added to the class.");
    }
  }

  public static void removeStudentFromClass(Scanner scanner, SkoolClasses selectedClass) {
    Logger logger = Logger.getLogger(Opdracht_4.class.getName());
    boolean removingStudents = true;
    while (removingStudents) {
      logger.info(
          "Select students to remove from the class (Enter student number or 0 to finish):");
      ArrayList<Student> classStudents = selectedClass.getClassStudents();
      for (int i = 0; i < classStudents.size(); i++) {
        String message = String.format(mes, i + 1, classStudents.get(i).getName());
        logger.info(message);
      }
      logger.info("\n");
      int studentIndex = 0;
      boolean isValidInput = false;
      studentIndex = getStudentIndex(isValidInput, messageStudNum, studentIndex, scanner);
      if (studentIndex == 0) {
        removingStudents = false;
      } else if (studentIndex > 0 && studentIndex <= classStudents.size()) {
        Student removedStudent = classStudents.remove(studentIndex - 1);
        logger.info(removedStudent.getName() + " removed from the class.");
      } else {
        logger.info("Invalid student number. Please try again.");
      }
    }
  }

  public static void removeCounsellorFromClass(Scanner scanner, SkoolClasses selectedClass) {
    Logger logger = Logger.getLogger(Opdracht_4.class.getName());
    ArrayList<Counsellor> classCounsellors = selectedClass.getClassCounsellor();
    if (classCounsellors.isEmpty()) {
      logger.info("There are no counsellors assigned to this class.");
      return;
    }
    logger.info("Select a counsellor to remove from the class:");
    for (int i = 0; i < classCounsellors.size(); i++) {
      String message = String.format(mes, i + 1, classCounsellors.get(i).getName());
      logger.info(message);
    }
    logger.info("\n");
    int counsellorIndex = 0;
    boolean isValidInput = false;
    counsellorIndex = getStudentIndex(isValidInput, messageCounselNum, counsellorIndex, scanner);
    if (counsellorIndex > 0 && counsellorIndex <= classCounsellors.size()) {
      Counsellor removedCounsellor = classCounsellors.remove(counsellorIndex - 1);
      logger.info(removedCounsellor.getName() + " removed as the counsellor for the class.");
    } else {
      logger.info("Invalid counsellor number. No counsellor removed from the class.");
    }
  }

  public static void deleteFromClass(Scanner scanner) {
    Logger logger = Logger.getLogger(Opdracht_4.class.getName());
    logger.info(messageAvailableClasses);
    for (SkoolClasses skoolClass : allClasses) {
      logger.info("- " + skoolClass.getName());
    }
    // Prompt the user to enter the name of the class
    logger.info("Enter the name of the class to add students and counsellors: ");
    String className = scanner.next();
    // Check if the entered class name is valid
    SkoolClasses selectedClass = null;
    for (SkoolClasses skoolClass : allClasses) {
      if (skoolClass.getName().equalsIgnoreCase(className)) {
        selectedClass = skoolClass;
        break;
      }
    }
    // If the class name is valid, proceed to add students and counsellors
    if (selectedClass != null) {
      removeStudentFromClass(scanner, selectedClass); // Remove students to the class
      removeCounsellorFromClass(scanner, selectedClass); // Add counsellors to the class
    } else {
      logger.info("Invalid class name. Please enter a valid class name from the list.");
    }
  }

  public void addStudent(Student student) {
    classStudents.add(student);
  }

  private void addCounsellor(Counsellor counsellor) {
    classCounsellor.add(counsellor);
  }

  // Method to delete the class
  public static void deleteClass(Scanner scanner) {
    Logger logger = Logger.getLogger(Opdracht_4.class.getName());
    logger.info(messageAvailableClasses);
    for (SkoolClasses skoolClass : allClasses) {
      logger.info("- " + skoolClass.getName());
    }
    logger.info("Enter the name of the class you want to delete: ");
    String className = scanner.next();
    SkoolClasses targetClass = null;
    for (SkoolClasses theClass : allClasses) {
      if (theClass.getName().equalsIgnoreCase(className)) {
        targetClass = theClass;
        break;
      }
    }
    if (targetClass != null) {
      allClasses.remove(targetClass);
      String message = String.format("Class '%s' has been deleted", className);
      logger.info(message);
    } else {
      String message = String.format("Class '%s' not found.", className);
      logger.info(message);
    }
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "CLASS NAME: " + name + "\nCOUNSELLOR: " + classCounsellor + "\nSTUDENTS: "
        + classStudents;
  }
}
