package frl.icekowedd.School_Opdr88.Opdracht_2;// importing packages
import java.util.Scanner;
import java.util.logging.Logger;

// opdr2
public class Opdracht_2 {
  // creating variables to be used trough this class.
  private static final double SOUND_TRAVEL_M = 343;
  private static final double METER_TO_FEET = 3.280839895;

  // Main method
  public static void main(String[] args) {
    Logger logger = Logger.getLogger(Opdracht_2.class.getName());
    Scanner scanner = new Scanner(System.in);
    char userChoiceCalc = getUserChoice(scanner); // call method (getUserChoice)
    while (true) { // for closing the application.// check what user input character is to see what to do next.
      if (userChoiceCalc == 'q') {
        break;
      } else if (userChoiceCalc != 'k' && userChoiceCalc != 'm') {
        logger.info("Error 101: wrong input, please select 'k', 'm', or 'q'");
        continue;
      }
      startApplication(scanner, userChoiceCalc); // Calling the start of the application.
    }// closing scanner
    logger.info("%nThankyou for using ThunderCalc!");
    scanner.close();
  }

  private static void startApplication(Scanner scanner, char userChoiceCalc) {
    // calling second user input method (get the seconds until bang).
    double secondsTillBang = getSecondsTillBang(scanner);
    // switch case to check what method should be used to calculate.
    switch (userChoiceCalc) {
      case 'k':
        calculateAndPrintMeters(secondsTillBang);
        break;
      case 'm':
        calculateAndPrintFeet(secondsTillBang);
        break;
      default: break;
    }
  }

  // get user input method, checks if user wants to quit or calc km's / miles. also converts char's to lower case.
  private static char getUserChoice(Scanner scanner) {
    Logger logger = Logger.getLogger(Opdracht_2.class.getName());
    logger.info("\nDo you want to calculate (k)KM's or (m)Miles? or press (q) to quit: ");
    return scanner.next().charAt(0);
  }

  // get user input method2, takes seconds until bang after lightning.
  private static double getSecondsTillBang(Scanner scanner) {
    Logger logger = Logger.getLogger(Opdracht_2.class.getName());
    logger.info("\nEnter how many seconds it lasted till you heard the bang after the thunder: ");
    return scanner.nextDouble();
  }

  // calculates and prints x amount of meters lightning has struck.
  private static void calculateAndPrintMeters(double secondsTillBang) {
    Logger logger = Logger.getLogger(Opdracht_2.class.getName());
    double meters = secondsTillBang * SOUND_TRAVEL_M;
    double kMeters = meters / 1000;
    String message = String.format("""
        %f seconds means it is %f meters away,
        that is the same as %f kilometer's""", secondsTillBang, meters, kMeters);

    logger.info(message);
  }

  // calculates and prints x amount of feet lightning has struck.
  private static void calculateAndPrintFeet(double secondsTillBang) {
    Logger logger = Logger.getLogger(Opdracht_2.class.getName());
    double feet = (secondsTillBang * SOUND_TRAVEL_M) * METER_TO_FEET;
    double miles = feet / 5280;
    String message = String.format("""
        %f seconds means it is %f feet away,
        that is the same as %f mile's
        """, secondsTillBang, feet, miles);
    logger.info(message);

  }
}
