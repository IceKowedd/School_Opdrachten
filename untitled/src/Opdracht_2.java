// importing packages
import java.util.Scanner;

// calling class
public class Opdracht_2 {
  // creating variables to be used trough this class.
  private static final double SOUND_TRAVEL_M = 343;
  private static final double METER_TO_FEET = 3.280839895;

  // Main method
  public static void main(String[] args) {
    // calling scanner
    Scanner scanner = new Scanner(System.in);
    // starting while loop.
    while (true) {
      char userChoiceCalc = getUserChoice(scanner); // call method (getUserChoice)
      // check what user input character is to see what to do next.
      if (userChoiceCalc == 'q') {
        break;
      } else if (userChoiceCalc != 'k' && userChoiceCalc != 'm') {
        System.out.println("Error 101: wrong input, please select 'k', 'm', or 'q'");
        continue;
      }
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
      }
    }
    // closing scanner
    System.out.println("\nThankyou for using ThunderCalc!");
    scanner.close();
  }


  // get user input method, checks if user wants to quit or calc km's / miles. also converts char's to lower case.
  private static char getUserChoice(Scanner scanner) {
    System.out.print("\nDo you want to calculate (k)KM's or (m)Miles? or press (q) to quit: ");
    return Character.toLowerCase(scanner.next().charAt(0));
  }

  // get user input method2, takes seconds until bang after lightning.
  private static double getSecondsTillBang(Scanner scanner) {
    System.out.print("\nEnter how many seconds it lasted till you heard the bang after the thunder: ");
    return scanner.nextDouble();
  }

  // calculates and prints x amount of meters lightning has struck.
  private static void calculateAndPrintMeters(double secondsTillBang) {
    double meters = secondsTillBang * SOUND_TRAVEL_M;
    double kMeters = meters / 1000;
    System.out.println("\n" + secondsTillBang + " seconds means it is " + meters +
        " meters away. \nthat is the same as " + kMeters + " Kilometer's\n");
  }

  // calculates and prints x amount of feet lightning has struck.
  private static void calculateAndPrintFeet(double secondsTillBang) {
    double feet = (secondsTillBang * SOUND_TRAVEL_M) * METER_TO_FEET;
    double miles = feet / 5280;
    System.out.println("\n" + secondsTillBang + " seconds means it is " + feet +
        " feet away. \nthat is the same as " + miles + " Mile's\n");

  }
}
