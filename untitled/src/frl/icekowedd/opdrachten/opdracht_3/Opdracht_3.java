package frl.icekowedd.opdrachten.opdracht_3;// imports
import java.util.logging.Logger;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

// opdr3
public class Opdracht_3 {

  // calling main method
  public static void main(String[] args){
    Logger logger = Logger.getLogger(Opdracht_3.class.getName());
    Scanner scanner = new Scanner(System.in);
    HashMap<String, Integer> fcList = new HashMap<>();
    boolean running = true;
    while (running) {
      char userChoiceFC = getUserInputFC(scanner);
      running = fcSwitch(userChoiceFC, fcList, scanner);
    }
    logger.info("\nThankyou for using FC! ^^,");
  }

  // get user input, what does the user want to do?
  private static char getUserInputFC(Scanner scanner) {
    Logger logger = Logger.getLogger(Opdracht_3.class.getName());
    logger.info("""
        Welcome to FC, what would you like to do?
         (1) add new friends!
         (2) delete a friend...
         (3) check all your friends!
         (4) Quit FC now.
         Your input here:\s""");
    return Character.toLowerCase(scanner.next().charAt(0));
  }

  // Switch case for selection from getUserInputFC.
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

  // add new friend to HashMap "fcList"
  private static void addNewFriend(HashMap<String, Integer> list, Scanner scanner) {
    Logger logger = Logger.getLogger(Opdracht_3.class.getName());
    logger.info("\nType the name of the person you want to add: ");
    String newName = scanner.next();
    logger.info("\nType the name of the person you want to add: ");
    int newAge = scanner.nextInt();
    list.put(newName, newAge);
  }

  // delete friend from HashMap "fcList"
    private static void deleteFriend(HashMap<String, Integer> list, Scanner scanner) {
      Logger logger = Logger.getLogger(Opdracht_3.class.getName());
      logger.info("\nEnter the name of the friend you want to delete: ");
      String name = scanner.next();
      if (list.containsKey(name)) {
        list.remove(name);
        String message = String.format("""
        %s has been deleted from your friends list.
        """, name);
        logger.info(message);
      } else {
        logger.info("\nFriend not found in the list.");
      }
    }

  // Print friend list from HashMap "fcList"
    private static void printFriends(HashMap<String, Integer> list) {
      Logger logger = Logger.getLogger(Opdracht_3.class.getName());
      if (list.isEmpty()) {
        logger.info("\nYour friends list is empty.");
      } else {
        logger.info("\nYour friends list:\n");
        for (Map.Entry<String, Integer> object : list.entrySet()) {
          String name = object.getKey();
          int age = object.getValue();
          String message = String.format("%s (Age: %d)", name, age);
          logger.info(message);

        }
        logger.info("");
      }

  }
}
