// Imports.
import java.util.Scanner;

// Main class
public class Opdracht_4 {

  // Main Method.
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    boolean running = true; while (running) {
      running = mainMenuSkoolList(scanner); }

    System.out.println("\n\nThank you for using the olSkoolList! ^^,"); }


  // user input skool menu - Switch Case user selection.
  private static boolean mainMenuSkoolList(Scanner scanner) {
    System.out.print("""
        
        Welcome to Skool List, what would you like to do?
         (1) Manage classes!
         (2) Manage Counsellors!
         (3) Manage Students!
         (4) Quit the program!
         Your input here:\s""");
    char userChoice = scanner.next().charAt(0);
    switch (userChoice) {
      case '1' -> { return getUserInputClass(scanner);}
      case '2' -> { return getUserInputCounsellor(scanner);}
      case '3' -> { return getUserInputStudent(scanner);}
      case '4' -> { return false;} default -> {
        System.out.println("Invalid input. Please enter a valid option.");
        return true; } } }


  // user input Class Menu - Switch Case user selection.
  private static boolean getUserInputClass(Scanner scanner) {
    boolean running = true; while (running) {
    System.out.print("""
        
        Welcome to Classes List, what would you like to do?
         (1) Add A new Class!
         (2) Delete a Class...
         (3) Manage your Classes!
         (4) Return to Main Menu.
         Your input here:\s""");
    char userChoice = scanner.next().charAt(0);
    switch (userChoice) {
      case '1': SkoolClasses.addNewClass(scanner); break;
      case '2': SkoolClasses.deleteClass(scanner); break;
      case '3': Opdracht_4.getUserInputClass2(scanner); break;
      case '4': running = false; default: break; } } return true;}


  // user input Class Menu 2 - Switch Case user selection.
  private static void getUserInputClass2(Scanner scanner) {
    boolean running = true; while (running) {
      System.out.print("""
        
        Welcome to Classes List, what would you like to do?
         (1) Add to A Class!
         (2) Delete from A Class...
         (3) Check all your Classes!
         (4) Return to Main Menu.
         Your input here:\s""");
      char userChoice = scanner.next().charAt(0);
      switch (userChoice) {
        case '1': SkoolClasses.addToClass(scanner); break;
        case '2': SkoolClasses.deleteFromClass(scanner); break;
        case '3': SkoolClasses.printClasses(); break;
        case '4': running = false; default: break; } } }


  // user input Counsellor Menu - Switch Case user selection.
  private static boolean getUserInputCounsellor(Scanner scanner) {
    boolean running = true; while (running) {
    System.out.print("""
        Welcome to Counsellor List, what would you like to do?
         (1) Add A new Counsellor!
         (2) Delete a Counsellor...
         (3) Check all your Counsellor's!
         (4) Return to Main Menu.
         Your input here:\s""");
    char userChoice = scanner.next().charAt(0);
    switch (userChoice) {
      case '1': Counsellor.addNewCounsellor(scanner);break;
      case '2': Counsellor.deleteCounsellor(scanner);break;
      case '3': Counsellor.printCounsellor();break;
      case '4': running = false; default: break; } } return true; }


  // user input Student Menu - Switch Case user selection.
  private static boolean getUserInputStudent(Scanner scanner) {
    boolean running = true; while (running) {
    System.out.print("""
        Welcome to Student List, what would you like to do?
         (1) Add new Student!
         (2) Delete a Student...
         (3) Check all your Students!
         (4) Return to Main Menu.
         Your input here:\s""");
    char userChoice = scanner.next().charAt(0);
    switch (userChoice) {case '1': Student.addNewStudent(scanner); break;
      case '2': Student.deleteStudent(scanner); break;
      case '3': Student.printStudent(); break;
      case '4': running = false; default: break;} } return true; } }

