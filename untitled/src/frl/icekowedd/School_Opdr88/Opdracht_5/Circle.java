package frl.icekowedd.School_Opdr88.Opdracht_5;

  // Circle class
public class Circle extends Shape {

    private double radius;
    private final double PIE = 3.14159265358979323846;

    //constructor
    public Circle(double radius) {
      this.radius = radius;
    }

    @Override
    public double getCircumference(double radius) {
      return ((radius * 2) * PIE);
    }

    @Override
    public double getArea(double radius) {
      return ((radius * 4) * PIE);
    }

    @Override
    public void setLength(double radius) {
      this.radius = radius;
    }

    @Override
    public void setWidth(double radius) {
      this.radius = radius;
    }

    @Override
    public double getLength() {
      return radius;
    }

    @Override
    public double getWidth() {
      return radius;
    }
  }