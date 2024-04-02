// imports
import java.util.Scanner;
import java.util.HashMap;

// class call
public class Opdracht_3 {

  // calling main method
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    HashMap<String, Integer> fcList = new HashMap<>();
    boolean running = true;
    while (running) {
      char userChoiceFC = getUserInputFC(scanner);
      running = fcSwitch(userChoiceFC, fcList, scanner);
    }
    System.out.println("\nThankyou for using FC! ^^,");
  }

  // get user input, what does the user want to do?
  private static char getUserInputFC(Scanner scanner) {
    System.out.print("""
        Welcome to FC, what would you like to do?
         (1) add new friends!
         (2) delete a friend...
         (3) check all your friends!
         (4) Quit FC now.
         Your input here:\s""");
    return Character.toLowerCase(scanner.next().charAt(0));
  }

  private static boolean fcSwitch(char userC, HashMap<String, Integer> list, Scanner scanner) {
    switch (userC) {
      case '1': addNewFriend(list, scanner); break;
      case '2': deleteFriend(list, scanner); break;
      case '3': printFriends(list); break;
      case '4': return false;
      default: break;
    }
    return true;
  }

  private static void addNewFriend(HashMap<String, Integer> list, Scanner scanner) {
    System.out.print("\nType the name of the person you want to add: ");
    String newName = scanner.next();
    System.out.print("\nType the name of the person you want to add: ");
    int newAge = scanner.nextInt();
    list.put(newName, newAge);
  }

    private static void deleteFriend(HashMap<String, Integer> list, Scanner scanner) {
      System.out.print("\nEnter the name of the friend you want to delete: ");
      String name = scanner.next();
      if (list.containsKey(name)) {
        list.remove(name);
        System.out.println("\n" +name + " has been deleted from your friends list.\n");
      } else {
        System.out.println("\nFriend not found in the list.");
      }
    }

    private static void printFriends(HashMap<String, Integer> list) {
      if (list.isEmpty()) {
        System.out.println("\nYour friends list is empty.");
      } else {
        System.out.println("\nYour friends list:\n");
        for (String name : list.keySet()) {
          int age = list.get(name);
          System.out.println(name + " (Age: " + age + ")");

        }
        System.out.println();
      }

  }
}
