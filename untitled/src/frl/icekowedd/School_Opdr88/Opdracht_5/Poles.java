package frl.icekowedd.School_Opdr88.Opdracht_5;

  // Poles class
public class Poles {

  // empty + private poles constructor
  private Poles () {}

  /* overloaded method.
     *poles* - amount of poles there have to be in the project.
     *radius* - the radius of the circle.
     method getCircleCirc - found in class Circle.
     method getCirc - found in class Rectangle.*/
  public static double pole(int poles, double radius) {
    double result = Circle.getCircumference(radius);
    return result / poles;
  }

  public static double pole(double perM2, double radius) {
    double result = Circle.getCircumference(radius);
    return result / perM2;
  }

  public static double pole(int poles, Rectangle rectangle) {
    double result = Rectangle.getCircumference(rectangle);
    return result / poles;
  }

  public static double pole(double perM2, Rectangle rectangle) {
    double result = Rectangle.getCircumference(rectangle);
    return result / perM2;
  }

}
