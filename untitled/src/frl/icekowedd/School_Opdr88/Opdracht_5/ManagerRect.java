package frl.icekowedd.School_Opdr88.Opdracht_5;

import java.util.Scanner;

// rectangle manager class.
public class ManagerRect {
  public static final String invalidInput = "Invalid input. Please enter a valid number.";

  // constructor
  private ManagerRect () {}

  // method that creates a *rectangle*
  public static Rectangle createRectangle(Scanner scanner) {
    double len = 0;
    double wid = 0;
    boolean validInput = false;

    // ask for input.
    do {
      try {
        System.out.println("Type the Length of the Rectangle:");
        len = Double.parseDouble(scanner.nextLine());

        System.out.println("Type the Width of the Rectangle:");
        wid = Double.parseDouble(scanner.nextLine());

        validInput = true;
      } catch (NumberFormatException e) {
        System.out.println(invalidInput);
      }
    } while (!validInput);

    // *rectangle* creation
    Rectangle rectangle = new Rectangle(len, wid);
    System.out.printf("Rectangle with Length: %f Width: %f created", len, wid);
    return rectangle;
  }
    // method for modification of a *rectangle*
  public static void modifyRectangle(Scanner scanner, Rectangle rectangle) {
    double len = 0;
    double wid = 0;
    boolean validInput = false;
    // ask for input.
    do {
      try {
        System.out.println("Type new Length of the Rectangle:");
        len = Double.parseDouble(scanner.nextLine());

        System.out.println("Type new Width of the Rectangle:");
        wid = Double.parseDouble(scanner.nextLine());

        validInput = true;
      } catch (NumberFormatException e) {
        System.out.println(invalidInput);
      }
    } while (!validInput);

    // call of method that will set new values to the *rectangle*
    rectangle.setLength(len);
    rectangle.setWidth(wid);
    System.out.printf("Rectangle with Length: %f Width: %f created", len, wid);
  }

  // calls getCirc method found in Rectangle to get circumference of *rectangle*
  public static void rectCircumference(Rectangle rectangle) {
    double value = Rectangle.getCircumference(rectangle);
    System.out.println("you have selected Rectangle: \n");
    System.out.println("The circumference is: " + value);
  }

  // calls getM2 method found in Rectangle to get M² of *rectangle*
  public static void rectM2(Rectangle rectangle) {
    double value = rectangle.getArea(rectangle);
    System.out.println("you have selected Rectangle: \n");
    System.out.println("The M2 is: " + value);
  }

  // calls pole method found in Poles to get amount of *meters* needed between poles
  public static void rectPolePoles(Scanner scanner, Rectangle rectangle) {
    int poles = 0;
    boolean validInput = false;
    // ask for input.
    do {
      try {
        System.out.print("Type amount of poles to use: ");
        poles = Integer.parseInt(scanner.nextLine());
        validInput = true;
      } catch (NumberFormatException e) {
        System.out.println(invalidInput);
      }
    } while (!validInput);

    // call of pole method.
    double value = Poles.pole(poles, rectangle);
    System.out.println("Poles per meter: " + value);
  }

  // calls pole method found in Poles to get amount of *poles* needed.
  public static void rectMeterPoles(Scanner scanner, Rectangle rectangle) {
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

    // call of pole method.
    double value = Poles.pole(meters, rectangle);
    System.out.println("Total poles to use: " + value);
  }
}
