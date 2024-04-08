
// Imports
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SkoolClasses {
  private final String name;
  private final ArrayList<Student> classStudents;
  private final ArrayList<Counsellor> classCounsellor;
  public static ArrayList<SkoolClasses> allClasses = new ArrayList<>();
  private ArrayList<Counsellor> getClassCounsellor() {return classCounsellor;}

  private ArrayList<Student> getClassStudents() { return classStudents;}

  public SkoolClasses(String name) { this.name = name; this.classStudents = new ArrayList<>(); this.classCounsellor = new ArrayList<>(); }

  public static void addToClass(Scanner scanner) {
    System.out.println("Available classes:"); // Print all available classes
    for (SkoolClasses skoolClass : allClasses) { System.out.println("- " + skoolClass.getName()); }
    // Prompt the user to enter the name of the class
    System.out.print("Enter the name of the class to add students and counsellors: ");
    String className = scanner.next();
    // Check if the entered class name is valid
    SkoolClasses selectedClass = null; for (SkoolClasses skoolClass : allClasses) {
      if (skoolClass.getName().equalsIgnoreCase(className)) { selectedClass = skoolClass; break; } }
    if (selectedClass != null) {  // If the class name is valid, add students and counsellors
      addStudent2(scanner, selectedClass); // Add students to the class
      addCounsellor2(scanner, selectedClass); // Add counsellors to the class
    } else { System.out.println("Invalid class name. Please enter a valid class name from the list."); } }

  public static void printClasses() {
    if (allClasses.isEmpty()) {
      System.out.println("No classes available."); } else { System.out.println("List of Classes:");
      for (SkoolClasses skoolClass : allClasses) { System.out.println(skoolClass.getName());
        System.out.println("Students:");
        for (Student student : skoolClass.getClassStudents()) { System.out.println("- " + student.getName()); } // print students of class.
        System.out.println("Counsellor:"); ArrayList<Counsellor> classCounsellor = skoolClass.getClassCounsellor();
        if (!classCounsellor.isEmpty()) { System.out.println("- " + classCounsellor.getFirst().getName()); // print the first counsellor that has been appointed. (if 2 or more accidentally have been appointed)
        } else { System.out.println("- None"); } System.out.println(); } } } // Print None of no counsellors have been appointed.

  public static void addNewClass(Scanner scanner) {
    System.out.print("Enter the name of the class: "); // Get the name of the class
    String className = scanner.next(); SkoolClasses newClass = new SkoolClasses(className);
    allClasses.add(newClass); System.out.println("New class " + className + " has been added.");
    addStudent2(scanner, newClass);// Choose students for the class
    addCounsellor2(scanner, newClass);}// Choose counsellor for the class

  public static void addStudent2(Scanner scanner, SkoolClasses selectedClass) {
    boolean addingStudents = true; while (addingStudents) {
      // Display students who are not already in the class
      System.out.println("Select students to add to the class (Enter student number or 0 to finish):");
      ArrayList<Student> availableStudents = new ArrayList<>();
      for (Student student : Student.studentList) {
        if (!selectedClass.getClassStudents().contains(student)) { availableStudents.add(student); } }
      for (int i = 0; i < availableStudents.size(); i++) {
        System.out.println((i + 1) + ". " + availableStudents.get(i).getName()); }
      int studentIndex = 0; boolean isValidInput = false; while (!isValidInput) {
        System.out.print("Student number: ");
        try { studentIndex = scanner.nextInt(); isValidInput = true; } // Get student number
        catch (InputMismatchException e) // CATCH EXCEPTION
        {System.out.println("Invalid input. Please enter a valid integer.");
          scanner.next(); } }// Clear the invalid input from the scanner
      scanner.nextLine(); if (studentIndex == 0) { addingStudents = false;
      } else if (studentIndex > 0 && studentIndex <= availableStudents.size()) {
        Student selectedStudent = availableStudents.get(studentIndex - 1);
        selectedClass.addStudent(selectedStudent);
        System.out.println(selectedStudent.getName() + " added to the class.");
      } else { System.out.println("Invalid student number. Please try again."); } } }

  public static void addCounsellor2(Scanner scanner, SkoolClasses selectedClass) {
    System.out.println("Select a counsellor to add to the class:");
    ArrayList<Counsellor> availableCounsellors = new ArrayList<>();
    for (Counsellor counsellor : Counsellor.counsellors) {
      if (!selectedClass.getClassCounsellor().contains(counsellor)) {
        availableCounsellors.add(counsellor); } }
    for (int i = 0; i < availableCounsellors.size(); i++) {
      System.out.println((i + 1) + ". " + availableCounsellors.get(i).getName()); }
    System.out.print("Counsellor number: ");
    int counsellorIndex = 0; boolean isValidInput = false; while (!isValidInput) {
      System.out.print("Counsellor number: ");
      try { counsellorIndex = scanner.nextInt(); isValidInput = true; } // Get counsellor number
      catch (InputMismatchException e) // CATCH EXCEPTION
      {System.out.println("Invalid input. Please enter a valid integer.");
        scanner.next(); } }// Clear the invalid input from the scanner
    if (counsellorIndex > 0 && counsellorIndex <= availableCounsellors.size()) {
      Counsellor selectedCounsellor = availableCounsellors.get(counsellorIndex - 1);
      selectedClass.addCounsellor(selectedCounsellor);
      System.out.println(selectedCounsellor.getName() + " added as the counsellor for the class.");
    } else { System.out.println("Invalid counsellor number. No counsellor added to the class."); } }

  public static void removeStudentFromClass(Scanner scanner, SkoolClasses selectedClass) {
    boolean removingStudents = true;
    while (removingStudents) {
      System.out.println("Select students to remove from the class (Enter student number or 0 to finish):");
      ArrayList<Student> classStudents = selectedClass.getClassStudents();
      for (int i = 0; i < classStudents.size(); i++) {
        System.out.println((i + 1) + ". " + classStudents.get(i).getName()); }
      System.out.print("Student number: "); int studentIndex = 0; boolean isValidInput = false; while (!isValidInput) {
        System.out.print("Counsellor number: "); try { studentIndex = scanner.nextInt(); isValidInput = true; } // Get counsellor number
        catch (InputMismatchException e) // CATCH EXCEPTION
         {System.out.println("Invalid input. Please enter a valid integer."); scanner.next(); } }// Clear the invalid input from the scanner
      if (studentIndex == 0) { removingStudents = false;
      } else if (studentIndex > 0 && studentIndex <= classStudents.size()) {
        Student removedStudent = classStudents.remove(studentIndex - 1);
        System.out.println(removedStudent.getName() + " removed from the class.");
      } else { System.out.println("Invalid student number. Please try again."); } } }

  public static void removeCounsellorFromClass(Scanner scanner, SkoolClasses selectedClass) {
    ArrayList<Counsellor> classCounsellors = selectedClass.getClassCounsellor();
    if (classCounsellors.isEmpty()) {
      System.out.println("There are no counsellors assigned to this class."); return;}
    System.out.println("Select a counsellor to remove from the class:");
    for (int i = 0; i < classCounsellors.size(); i++) {
      System.out.println((i + 1) + ". " + classCounsellors.get(i).getName()); }
    System.out.print("Counsellor number: "); int counsellorIndex = 0; boolean isValidInput = false; while (!isValidInput) {
      System.out.print("Counsellor number: "); try { counsellorIndex = scanner.nextInt(); isValidInput = true; } // Get counsellor number
      catch (InputMismatchException e) // CATCH EXCEPTION
      {System.out.println("Invalid input. Please enter a valid integer."); scanner.next(); } }// Clear the invalid input from the scanner
    if (counsellorIndex > 0 && counsellorIndex <= classCounsellors.size()) {
      Counsellor removedCounsellor = classCounsellors.remove(counsellorIndex - 1);
      System.out.println(removedCounsellor.getName() + " removed as the counsellor for the class.");
    } else { System.out.println("Invalid counsellor number. No counsellor removed from the class."); } }

  public static void deleteFromClass(Scanner scanner) {
    System.out.println("Available classes:");
    for (SkoolClasses skoolClass : allClasses) {
      System.out.println("- " + skoolClass.getName()); }
    // Prompt the user to enter the name of the class
    System.out.print("Enter the name of the class to add students and counsellors: ");
    String className = scanner.next();
    // Check if the entered class name is valid
    SkoolClasses selectedClass = null;
    for (SkoolClasses skoolClass : allClasses) {
      if (skoolClass.getName().equalsIgnoreCase(className)) {
        selectedClass = skoolClass; break; } }
    // If the class name is valid, proceed to add students and counsellors
    if (selectedClass != null) {
      removeStudentFromClass(scanner, selectedClass); // Remove students to the class
      removeCounsellorFromClass(scanner, selectedClass); // Add counsellors to the class
    } else { System.out.println("Invalid class name. Please enter a valid class name from the list."); } }

  public void addStudent(Student student) { classStudents.add(student); }

  private void addCounsellor(Counsellor counsellor) { classCounsellor.add(counsellor); }

  // Method to delete the class
  public static void deleteClass(Scanner scanner) {
    System.out.println("Available classes:");
    for (SkoolClasses skoolClass : allClasses) { System.out.println("- " + skoolClass.getName()); }
    System.out.print("Enter the name of the class you want to delete: ");
    String className = scanner.next(); SkoolClasses targetClass = null;
    for (SkoolClasses theClass : allClasses) { if (theClass.getName().equalsIgnoreCase(className)) {
        targetClass = theClass; break; } } if (targetClass != null) {
      allClasses.remove(targetClass); System.out.println("Class '" + className + "' has been deleted.");
    } else { System.out.println("Class '" + className + "' not found."); } }

  public String getName() { return name; }

  @Override
  public String toString() { return "CLASS NAME: " + name + "\nCOUNSELLOR: " + classCounsellor + "\nSTUDENTS: " + classStudents; } }
