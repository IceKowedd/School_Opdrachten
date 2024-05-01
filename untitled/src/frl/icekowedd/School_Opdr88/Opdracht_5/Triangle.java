package frl.icekowedd.School_Opdr88.Opdracht_5;

public class Triangle extends Shape {

  private double length;
  private double width;

  public Triangle(double length, double width) {
    this.length = length;
    this.width = width;
  }

  @Override
  public double getArea() {
    return (this.length * this.width) / 2;
  }

  @Override
  public double getCircumference() {
    double schuin = Math.sqrt((this.length * this.length) + (this.width * this.width));
    return this.length + this.width + schuin;
  }

  @Override
  public void setLength(double length) {
    this.length = length;
  }

  @Override
  public void setWidth(double width) {
    this.width = width;
  }

  @Override
  public double getLength() {
    return this.length;
  }

  @Override
  public double getWidth() {
    return this.width;
  }

}
