package frl.icekowedd.School_Opdr88.Opdracht_5;

  // rectangle class
public class Rectangle extends Shape {
  private double length;
  private double width;

  /* Constructor.
  method getSetWidth - is called so Rectangle does not have to be static-
  and *width* can be accessed statically and non statically.
   */
  public Rectangle (double length, double width) {
    this.length = length;
    this.width = width;
  }
// calculates total M² of a rectangle
  @Override
  public double getArea() {
    return this.length * this.width;
  }

// calculates total circumference of a rectangle
  @Override
  public double getCircumference() {
    return ((this.length * 2) + (this.width * 2));
  }

    // getters / setters
  @Override
  public void setLength(double length) {
    this.length = length;
  }

  @Override
  public void setWidth(double width) {
    this.width = width;
  }

  public double getLength() {
    return this.length;
  }

  @Override
  public double getWidth() {
    return this.width;
  }
}
