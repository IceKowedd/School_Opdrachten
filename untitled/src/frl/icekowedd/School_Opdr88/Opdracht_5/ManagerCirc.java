package frl.icekowedd.School_Opdr88.Opdracht_5;

import java.util.Scanner;

// circle manager class.
public class ManagerCirc {
  public static final String invalidInput = "Invalid input. Please enter a valid number.";

  // constructor
  private ManagerCirc () {}

  // method that creates a *circle*
  public static Circle createCircle(Scanner scanner) {
    double radius = 0;
    boolean validInput = false;
    // ask for input
    do {
      try {
        System.out.println("Type the Radius of the circle:");
        radius = Double.parseDouble(scanner.nextLine());
        validInput = true;
      } catch (NumberFormatException e) {
        System.out.println(invalidInput);
      }
    } while (!validInput);

    // *circle* creation.
    Circle circle = new Circle(radius);
    System.out.printf("Circle with radius of %f created", radius);
    return circle;
  }

  // method for modification of a *circle*
  public static void modifyCirc(Scanner scanner, Circle circle) {
    double radius = 0;
    boolean validInput = false;

    // ask for input.
    do {
      try {
        System.out.println("Type new Radius of the Circle:");
        radius = Double.parseDouble(scanner.nextLine());
        validInput = true;
      } catch (NumberFormatException e) {
        System.out.println(invalidInput);
      }
    } while (!validInput);

    // call of method that will set new values to the *circle*
    circle.setNewValue(radius);
    System.out.printf("Circle with radius of %f created", radius);
  }

  // call of method that will get circumference of a *circle*
  public static void circCircumference(Circle circle) {
    double radius = circle.getRadius();
    double value = Circle.getCircleCirc(radius);
    System.out.println("The circumference is: " + value);
  }

  // call of method that will get M² of a *circle*
  public static void circM2(Circle circle) {
    double radius = circle.getRadius();
    double value = circle.getCircleM2(radius);
    System.out.println("The M2 is: " + value);
  }

  // call of method that will get amount of *meters* between poles.
  public static void circPolePoles(Scanner scanner, Circle circle) {
    int poles = 0;
    boolean validInput = false;
    do {
      try {
        System.out.print("Type amount of poles to use: ");
        poles = Integer.parseInt(scanner.nextLine());
        validInput = true;
      } catch (NumberFormatException e) {
        System.out.println(invalidInput);
      }
    } while (!validInput);

    // call of circles radius + call of pole method to get *meters* between poles.
    double radius = circle.getRadius();
    double value = Poles.pole(poles, radius);
    System.out.println("Poles per meter: " + value);
  }

  // call of method that will get amount of *poles* needed.
  public static void circMetersPoles(Scanner scanner, Circle circle) {
    double meters = 0;
    boolean validInput = false;
    // ask for input.
    do {
      try {
        System.out.print("Type the amount of meters per pole: ");
        meters = Integer.parseInt(scanner.nextLine());
        validInput = true;
      } catch (NumberFormatException e) {
        System.out.println(invalidInput);
      }
    } while (!validInput);

    // call of circles radius to use at > call of pole method to get the amount of *poles* needed.
    double radius = circle.getRadius();
    double value = Poles.pole(meters, radius);
    System.out.println("Total poles to use: " + value);
  }

}
