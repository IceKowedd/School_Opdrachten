package frl.icekowedd.School_Opdr88.Opdracht_5;

  // rectangle class
public class Rectangle {
  private double length;
  private static double width;

  /* Constructor.
  method getSetWidth - is called so Rectangle does not have to be static-
  and *width* can be accessed statically and non statically.
   */
  public Rectangle (double length, double width) {
    this.length = length;
    getSetWidth(width);
  }
  // rectangle manipulation methods
    // calculates m²
  public double getM2(Rectangle rectangle) {
    return rectangle.length * width;
  }
    // calculates total circumference of a rectangle
  public static double getCirc(Rectangle rectangle) {
    return ((rectangle.length * 2) + (width * 2));
  }
    // set length of rectangle
  public void setLength(double length) {
    this.length = length;
  }
    // call static set width method.
  public void getSetWidth(double width) {
    setWidth2(width);
  }
    // set width of rectangle
  public static void setWidth2(double width) {
    Rectangle.width = width;
  }
}
