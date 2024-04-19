package frl.icekowedd.School_Opdr88.Opdracht_5;

  // Circle class
public class Circle {
  private double radius;
  private static final double PIE = 3.14159265358979323846;

  //constructor
  public Circle (double radius) {
    this.radius = radius;
  }

    // getter en setters.
  public static double getCircleCirc(double radius) {
    return ((radius * 2) * PIE);
  }

  public double getCircleM2 (double radius) {
    return ((radius * 4) * PIE);
  }

  public double getRadius () {
    return this.radius;
  }

  public void setNewValue (double radius) {
    this.radius = radius;
  }
}
