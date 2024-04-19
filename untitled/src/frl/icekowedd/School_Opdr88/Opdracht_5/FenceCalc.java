package frl.icekowedd.School_Opdr88.Opdracht_5;

import java.util.Scanner;

// Main class.
public class FenceCalc {
  private final Scanner scanner = new Scanner(System.in);
  private static final String b = "Goodbye!";
  private static final String x = "Invalid input...";

  // Main method.
  public static void main(String[] args) {
    System.out.println("Welcome to FenceCalc.");
    FenceCalc fenceCalc = new FenceCalc();
    fenceCalc.startApp();
  }

  // Start of Application. - choice menu.
  private void startApp() {
  while (true) {
    choiceMenu("Rectangles", "Circles");
    char choice = scanner.nextLine().charAt(0);
    switch (choice) {
      case '1': rectMenu(); // rectangle
      break;
      case '2': cirMenu(); // circle
      break;
      case 'q': System.out.println(b); // quit
      return;
      default: System.out.println(x);
      break;
    }
  }
  }

  // reusable choice menu
  private void choiceMenu(String string1, String string2) {
    System.out.println("Where would you like to work with?.");
    System.out.println("1. " + string1);
    System.out.println("2. " + string2);
    System.out.print("choose a option or (q) to quit: ");

  }

  // reusable choice menu
  private void choiceMenu(String string, String string1, String string2) {
    System.out.println("\nYou are now working with: " + string);
    System.out.println("1. " + string1);
    System.out.println("2. " + string2);
    System.out.println("3. " + "Calculate Circumference or M2");
    System.out.println("4. " + "Calculate Poles");
    System.out.print("choose a option or (q) to quit: ");

  }

  // rectangle menu.
  private void rectMenu () {
    Rectangle rectangle = null;
    while (true) {
      choiceMenu("Rectangles", "Create Rectangle", "Modify Rectangle");
      char choice = scanner.nextLine().charAt(0);
      switch (choice) {
        case '1': rectangle = ManagerRect.createRectangle(scanner); // creation
          break;
        case '2': ManagerRect.modifyRectangle(scanner, rectangle); // modification
          break;
        case '3': rectCircumferenceM2(scanner, rectangle); // circumference / M2.
          break;
        case '4': rectCalcPoles(scanner, rectangle); // poles calc per meter / poles.
          break;
        case 'q': System.out.println(b); // quit.
          return;
        default: System.out.println(x);
          break;
      }
    }
  }

  // circle menu.
  private void cirMenu () {
    Circle circle = null;
    while (true) {
      choiceMenu("Circle", "Create Circle", "Modify Circle");
      char choice = scanner.nextLine().charAt(0);

      switch (choice) {
        case '1': circle = ManagerCirc.createCircle(scanner); // creation
          break;
        case '2': ManagerCirc.modifyCirc(scanner, circle); // modification
          break;
        case '3': circCircumferenceM2(scanner, circle); // circumference / M²
          break;
        case '4': circCalcPoles(scanner, circle); // poles per meter / meter between poles.
          break;
        case 'q': System.out.println(b); // quit
          return;
        default: System.out.println(x);
          break;
      }
    }
  }

  // rectangle circumference/m² menu.
  private void rectCircumferenceM2 (Scanner scanner, Rectangle rectangle) {
    while (true) {
      choiceMenu("Circumference", "M2");
      char choice = scanner.nextLine().charAt(0);
      switch (choice) {
        case '1': ManagerRect.rectCircumference(rectangle); // calc circumference
          break;
        case '2': ManagerRect.rectM2(rectangle); // calc m²
          break;
        case 'q': System.out.println(b); // quit.
          return;
        default: System.out.println(x);
          break;
      }
    }
  }

  // rectangle poles menu.
  private void rectCalcPoles (Scanner scanner, Rectangle rectangle) {
    while (true) {
      choiceMenu("Calculate using poles", "Calculate using Meters per pole");
      char choice = scanner.nextLine().charAt(0);
      switch (choice) {
        case '1': ManagerRect.rectPolePoles(scanner, rectangle); // calc meters between poles
          break;
        case '2': ManagerRect.rectMeterPoles(scanner, rectangle); // calc poles to use.
          break;
        case 'q': System.out.println(b); // quit
          return;
        default: System.out.println(x);
          break;
      }
    }
  }


  // circle circumference menu.
  private void circCircumferenceM2 (Scanner scanner, Circle circle) {
    while (true) {
      choiceMenu("Circumference", "M2");
      char choice = scanner.nextLine().charAt(0);
      switch (choice) {
        case '1': ManagerCirc.circCircumference(circle); // calc circumference
          break;
        case '2': ManagerCirc.circM2(circle); // calc m²
          break;
        case 'q': System.out.println(b); // quit
          return;
        default: System.out.println(x);
          break;
      }
    }
  }

  // circle poles menu.
  private void circCalcPoles (Scanner scanner, Circle circle) {
    while (true) {
      choiceMenu("Calculate using poles", "Calculate using Meters per pole");
      char choice = scanner.nextLine().charAt(0);
      switch (choice) {
        case '1': ManagerCirc.circPolePoles(scanner, circle); // calc meters between poles.
          break;
        case '2': ManagerCirc.circMetersPoles(scanner, circle); // calc poles needed.
          break;
        case 'q': System.out.println(b); // quit.
          return;
        default: System.out.println(x);
          break;
      }
    }
  }
}
