import java.util.Scanner;
import java.util.ArrayList;

public class Opdracht_4 {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> studentList = new ArrayList<>();
    boolean running = true;
    while (running) {
      char userChoiceSL = getUserInputSL(scanner);
      running = slSwitch(userChoiceSL, studentList, scanner);
    }
    System.out.println("\nThankyou for using StudentList! ^^,");
  }

  // get user input, what does the user want to do?
  private static char getUserInputSL(Scanner scanner) {
    System.out.print("""
        Welcome to Student List, what would you like to do?
         (1) add new Student!
         (2) delete a Student...
         (3) check all your Students!
         (4) Quit Student List now.
         Your input here:\s""");
    return Character.toLowerCase(scanner.next().charAt(0));
  }

  // Switch case for selection from getUserInputSL.
  private static boolean slSwitch(char userC, ArrayList<String> list, Scanner scanner) {
    switch (userC) {
      case '1': addNewStudent(list, scanner); break;
      case '2': deleteStudent(list, scanner); break;
      case '3': printStudent(list); break;
      case '4': return false;
      default: break;
    }
    return true;
  }


  // add new Student to ArrayList "studentList"
  private static void addNewStudent(ArrayList<String> list, Scanner scanner) {
    System.out.print("\nType the name of the person you want to add: ");
    String name = scanner.next();
    System.out.print("\nType the age of the person you want to add: ");
    int age = scanner.nextInt();
    System.out.print("\nType the phone number of the person you want to add: ");
    int phoneNumber = scanner.nextInt();
    System.out.print("\nType the E-mail address of the person you want to add: ");
    String email = scanner.next();
    System.out.print("\nType the residence of the person you want to add: ");
    String residence = scanner.next();
    System.out.print("\nType the student number of the person you want to add: ");
    int studentNumber = scanner.nextInt();
    Student newStudent = new Student(name, age, phoneNumber, email, residence, studentNumber);
    list.add(String.valueOf(newStudent));
    System.out.println("\n" + name + " has been added to your student list.\n");
  }

  // delete Student from ArrayList "studentList"
  private static void deleteStudent(ArrayList<String> list, Scanner scanner) {
    System.out.print("\nEnter the name of the student you want to delete: ");
    String name = scanner.next();
    boolean found = false;
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).startsWith(name)) {
        list.remove(i);
        System.out.println("\n" + name + " has been deleted from your student list.\n");
        found = true;
        break;
      }
    }
    if (!found) {
      System.out.println("\nStudent not found in the list.");
    }
  }

  // Print Students from ArrayList "studentList"
  private static void printStudent(ArrayList<String> list) {
    if (list.isEmpty()) {
      System.out.println("\nYour Student list is empty.");
    } else {
      System.out.println("\nYour Student list:\n");
      for (String student : list) {
        System.out.println(student);
      }
      System.out.println();
    }

  }
}
class Student {
  private String name;
  private int age;
  private int phoneNumber;
  private String email;
  private String residence;
  private int studentNumber;

  public Student(String name, int age, int phoneNumber, String email, String residence, int studentNumber) {
    this.name = name;
    this.age = age;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.residence = residence;
    this.studentNumber = studentNumber;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Name: " + name + ", Age: " + age + ", Phone number: " + phoneNumber +
        ", Email: " + email + ", Residence: " + residence + ", Student number: " + studentNumber;
  }
}