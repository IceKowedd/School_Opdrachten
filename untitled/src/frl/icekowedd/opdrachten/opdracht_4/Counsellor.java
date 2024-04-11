package frl.icekowedd.opdrachten.opdracht_4;// Imports
import java.util.ArrayList; import java.util.InputMismatchException;
import java.util.List; import java.util.Scanner; import frl.icekowedd.opdrachten.opdracht_4.validator.mail;
import java.util.logging.Logger;

// Counsellor class - What defines A counsellor?
public class Counsellor { private String name;
  private String email;
  private String residence;
  private String phoneNumber;
  private String workerNumber;
  private int age;
  private static final ArrayList<Counsellor> counsellors = new ArrayList<>();

  // Counsellor Constructor
  public Counsellor(String name, String email, String residence, int age, String phoneNumber, String workerNumber) {
    this.setName(name); this.setAge(age); this.setPhoneNumber(phoneNumber); this.setEmail(email);
    this.setResidence(residence); this.setWorkerNumber(workerNumber);}

  public static List<Counsellor> getCounsellors() {
    return counsellors;
  }

  // getName Method.
  public String getName() {return name; }

  // ToString Method is a method that will automatically be used when we want to print an object in Java (so no need to call).
  @Override
  public String toString() { return "\nName: (" + getName() + ")\nAge: (" + getAge() + ")\nResidence: (" + getResidence()
      +
        ")\nEmail: (" + getEmail() + ")\nPhone Number: (" + getPhoneNumber() + ")\nWorker Number: (" + getWorkerNumber()
      + ")\n"; }

  // Checks if name is Valid (minimum of 3 char).
  public static boolean isValidName(String name) { if (name.length() < 3) { return true; }
    for (char c : name.toCharArray()) { if (!Character.isLetter(c)) { return true; } } return false; }

  // Checks if phone Number is valid (10 digits.).
  public static boolean isValidPhoneNumber(String phoneNumber) { if (phoneNumber.length() != 10)
  { return true; } for (char c : phoneNumber.toCharArray()) {
    if (!Character.isDigit(c)) { return true; } } return false; }

  // checks if worker number is valid (4 digits).
  public static boolean isValidWork(String workerNumber) { if (workerNumber.length() != 4) {return true;}
    for (char c : workerNumber.toCharArray()) { if (!Character.isDigit(c)) { return true; } } return false; }

  // this method will create a counsellor object and place it in "counsellors" ArrayList.
  public static void addNewCounsellor(Scanner scanner) {
    Logger logger = Logger.getLogger(Opdracht_4.class.getName());
    String name = getName(scanner);
    int age = getAge(scanner);
    String phoneNumber = getPhoneNumber(scanner);
    String email = getEmail(scanner);
    String residence = getResidence(scanner, name);
    String workerNumber = getWorkerNumber(scanner);

    // Here the counsellor object is constructed.
    Counsellor newCounsellor = new Counsellor(name, email, residence, age, phoneNumber, workerNumber);
    getCounsellors().add(newCounsellor); // Here it is added to the "counsellors" ArrayList.
    String message = String.format("""
        %s has been added to your counsellor list.
        """, name); logger.info(message);}


  private static String getName(Scanner scanner) {
    Logger logger = Logger.getLogger(Opdracht_4.class.getName());
    // Get counsellor name.
    String name;
    do { logger.info("\nType the name of the counsellor you want to add!: ");
    name = scanner.next(); // GET NAME
      if (isValidName(name)) { logger.info("Invalid name format. Please try again.");
      } } while (isValidName(name)); // VALIDATOR
    return name;
  }

  private static String getWorkerNumber(Scanner scanner) {
    Logger logger = Logger.getLogger(Opdracht_4.class.getName());
    // Get counsellor worker number.
    String workerNumber;
    do {logger.info("\nType the worker number of the counsellor you want to add!: ");
    workerNumber = scanner.next(); // GET WORKER NUMBER
    if (isValidWork(workerNumber)) {logger.info("Invalid worker number format. Please try again.");
    } } while (isValidWork(workerNumber)); // VALIDATOR
    return workerNumber;
  }

  private static String getResidence(Scanner scanner, String name) {
    Logger logger = Logger.getLogger(Opdracht_4.class.getName());
    // Get counsellor residence.
    String residence;
    do {
    logger.info("\nType the residence of the counsellor you want to add!: ");
    residence = scanner.next(); if (isValidName(name)) { // GET RESIDENCE
      logger.info("Invalid residence format. Please try again.");
    } } while (isValidName(name)); // VALIDATOR
    return residence;
  }

  private static String getEmail(Scanner scanner) {
    Logger logger = Logger.getLogger(Opdracht_4.class.getName());
    // Get counsellor email.
    String email;
    do { logger.info("\nType the email of the counsellor you want to add!: ");
    email = scanner.next(); // GET EMAIL
      if (mail.isValidEmail(email)) {logger.info("Invalid email address format. Please try again.");
      } } while (mail.isValidEmail(email)); // VALIDATOR
    return email;
  }

  private static String getPhoneNumber(Scanner scanner) {
    Logger logger = Logger.getLogger(Opdracht_4.class.getName());
    // Get counsellor phone number.
    String phoneNumber;
    do { logger.info("\nEnter Phone Number (Must be 10 digits): ");
    phoneNumber = scanner.next(); // GET PHONE NUMBER
      if (isValidPhoneNumber(phoneNumber)) { logger.info("Invalid phone number format. Please try again.");
      } } while (isValidPhoneNumber(phoneNumber));
    return phoneNumber;
  }

  private static int getAge(Scanner scanner) {
    Logger logger = Logger.getLogger(Opdracht_4.class.getName());
    // Get counsellor age.
    int age = 0;
    boolean isValidInput = false;
    while (!isValidInput) {
      logger.info("\nType the age of the counsellor you want to add!: ");
      try { age = scanner.nextInt(); isValidInput = true;} // GET AGE + VALIDATOR
      catch (InputMismatchException e) { logger.info("Invalid input. Please enter a valid integer.");
        scanner.next(); } } // Clear the invalid input from the scanner
    return age;
  }

  // delete counsellor from ArrayList "counsellors".
  @SuppressWarnings("SuspiciousListRemoveInLoop")
  public static void deleteCounsellor(Scanner scanner) {
    Logger logger = Logger.getLogger(Opdracht_4.class.getName());
    printCounsellor();
    logger.info("\nEnter the name of the counsellor you want to delete: ");
    String name = scanner.next();
    boolean found = false;
    for (int i = 0; i < getCounsellors().size(); i++) { // LOOP TROUGH COUNSELLORS ARRAYLIST.
      if (getCounsellors().get(i).getName().equalsIgnoreCase(name)) { getCounsellors().remove(i);
        String message = String.format("""
            %s has been deleted from your counsellor list.
            """, name);
        logger.info(message);
        found = true; } }
    if (!found) { logger.info("\nCounsellor not found in the list."); } }

  // Print counsellor objects.
  public static void printCounsellor() {Logger logger = Logger.getLogger(Opdracht_4.class.getName()); if (getCounsellors().isEmpty()) {
    logger.info("\n list is empty.");
    } else { logger.info("\nYour Counsellor list:\n"); for (Counsellor counsellor : getCounsellors()) {
        logger.info(String.valueOf(counsellor)); } logger.info("\n"); } }

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

  public String getWorkerNumber() {
    return workerNumber;
  }

  public void setWorkerNumber(String workerNumber) {
    this.workerNumber = workerNumber;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}


