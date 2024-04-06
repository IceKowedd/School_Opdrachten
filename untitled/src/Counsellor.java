// Imports
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


// Counsellor class - What defines A counsellor?
public class Counsellor {
  public String name, email, residence, phoneNumber, workerNumber;
  public int age;
  public static ArrayList<Counsellor> counsellors = new ArrayList<>();


  // Counsellor Constructor
  public Counsellor(String name, String email, String residence, int age, String phoneNumber, String workerNumber) {
    this.name = name;
    this.age = age;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.residence = residence;
    this.workerNumber = workerNumber;}


  // getName Method.
  public String getName() {return name; }


  public String getWorkerNumber() {
    return workerNumber;
  }


  // ToString Method is a method that will automatically be used when we want to print an object in Java (so no need to call).
  @Override
  public String toString() {
    return "\nName: (" + name + ")\nAge: (" + age + ")\nResidence: (" + residence +
        ")\nEmail: (" + email + ")\nPhone Number: (" + phoneNumber + ")\nWorker Number: (" + workerNumber + ")\n"; }


  // Here come some small methods that check if something is valid.
  // Checks if email address is valid.
  public static boolean isValidEmail(String email) {
    String emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
    return !email.matches(emailRegex); }


  // Checks if name is Valid (minimum of 3 char).
  public static boolean isValidName(String name) {
    if (name.length() < 3) { return true; } for (char c : name.toCharArray()) {
      if (!Character.isLetter(c)) { return true; } } return false; }


  // Checks if phone Number is valid (10 digits.).
  public static boolean isValidPhoneNumber(String phoneNumber) {
    if (phoneNumber.length() != 10) { return true; } for (char c : phoneNumber.toCharArray())
    { if (!Character.isDigit(c)) { return true; } } return false; }


  // checks if worker number is valid (4 digits).
  public static boolean isValidWork(String workerNumber) { if (workerNumber.length() != 4) {
      return true;} for (char c : workerNumber.toCharArray()) { if (!Character.isDigit(c)) {
        return true; } } return false; }


  // Here come the control methods.
  // this method will create a counsellor object and place it in "counsellors" ArrayList.
  public static void addNewCounsellor(Scanner scanner) {
    // Get counsellor name.
    String name; do { System.out.print("\nType the name of the counsellor you want to add!: ");
    name = scanner.next(); // GET NAME
      if (isValidName(name)) { System.out.println("Invalid name format. Please try again.");
      } } while (isValidName(name)); // VALIDATOR


    // Get counsellor age.
    int age = 0; boolean isValidInput = false; while (!isValidInput) {
      System.out.print("\nType the age of the counsellor you want to add!: ");
      try { age = scanner.nextInt(); isValidInput = true;} // GET AGE + VALIDATOR
      catch (InputMismatchException e) { System.out.println("Invalid input. Please enter a valid integer.");
        scanner.next(); } } // Clear the invalid input from the scanner


    // Get counsellor phone number.
    String phoneNumber; do { System.out.print("\nEnter Phone Number (Must be 10 digits): ");
    phoneNumber = scanner.next(); // GET PHONE NUMBER
      if (isValidPhoneNumber(phoneNumber)) { System.out.println("Invalid phone number format. Please try again.");
      } } while (isValidPhoneNumber(phoneNumber));


    // Get counsellor email.
    String email; do { System.out.print("\nType the email of the counsellor you want to add!: ");
    email = scanner.next(); // GET EMAIL
      if (isValidEmail(email)) {System.out.println("Invalid email address format. Please try again.");
      } } while (isValidEmail(email)); // VALIDATOR


    // Get counsellor residence.
    String residence; do {
    System.out.print("\nType the residence of the counsellor you want to add!: ");
    residence = scanner.next(); if (isValidName(name)) { // GET RESIDENCE
      System.out.println("Invalid residence format. Please try again.");
    } } while (isValidName(name)); // VALIDATOR


    // Get counsellor worker number.
    String workerNumber; do {System.out.print("\nType the worker number of the counsellor you want to add!: ");
    workerNumber = scanner.next(); // GET WORKER NUMBER
    if (isValidWork(workerNumber)) {System.out.println("Invalid phone number format. Please try again.");
    } } while (isValidWork(workerNumber)); // VALIDATOR


    // Here the counsellor object is constructed.
    Counsellor newCounsellor = new Counsellor(name, email, residence, age, phoneNumber, workerNumber);
    counsellors.add(newCounsellor); // Here it is added to the "counsellors" ArrayList.
    System.out.println("\n" + name + " has been added to your counsellor list.\n");}


  // delete counsellor from ArrayList "counsellors".
  @SuppressWarnings("SuspiciousListRemoveInLoop")
  public static void deleteCounsellor(Scanner scanner) {
    printCounsellor();
    System.out.print("\nEnter the name of the counsellor you want to delete: ");
    String name = scanner.next(); boolean found = false;
    for (int i = 0; i < counsellors.size(); i++) { // LOOP TROUGH COUNSELLORS ARAYLIST.
      if (counsellors.get(i).getName().equalsIgnoreCase(name)) { counsellors.remove(i);
        System.out.println("\n" + name + " has been deleted from your counsellor list.\n");
        found = true; } } if (!found) { System.out.println("\nCounsellor not found in the list."); } }


  // Print counsellor objects.
  public static void printCounsellor() {
    if (counsellors.isEmpty()) {
      System.out.println("\nYour Counsellor list is empty.");
    } else { System.out.println("\nYour Counsellor list:\n");
      for (Counsellor counsellor : counsellors) {
        System.out.println(counsellor); }
      System.out.println(); } } }


