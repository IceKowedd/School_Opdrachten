package com.example.test.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CircleTest {

  @Test
  void calculatorTest(){
    Circle circle = new Circle(10);

    double radius = circle.getRadius();
    int diameter = circle.toDiameter(10);
    Assertions.assertEquals(radius, 10);
    Assertions.assertEquals(diameter, 20);

    double result = circle.getCircleCirc(diameter);
    Assertions.assertEquals(result, 62.83185307179586);

    result = circle.getCircleM2(diameter);
    Assertions.assertEquals(result, 125.66370614359172);
    result = circle.pole(15);
    Assertions.assertEquals(result, 4.1887902047863905);
  }


  @Test
  void calculatorTest2(){
    Circle circle2 = new Circle();
    int diameter = circle2.toDiameter();
    double radius = circle2.toRadius(diameter);
    Assertions.assertEquals(radius, 8);
    Assertions.assertEquals(diameter, 16);

    double result = circle2.getCircleCirc(radius);
    Assertions.assertEquals(result, 50.26548245743669);

    result = circle2.getCircleM2(radius);
    Assertions.assertEquals(result, 100.53096491487338);

    circle2.setNewValue(15);
    diameter = circle2.getDiameter();
    Assertions.assertEquals(diameter, 15);

    result = circle2.pole(3.9);
    Assertions.assertEquals(result, 12.083048667653049);
  }

}