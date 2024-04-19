package com.example.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleTest {

  @Test
  void calculatorTest(){
    Rectangle rectangle = new Rectangle();
    int[] dimensionTest = {40, 20};
    int[] dimension = new int[]{rectangle.getLength(), rectangle.getWidth()};
    Assertions.assertArrayEquals(dimension, dimensionTest);

    int result = rectangle.overloadM2(rectangle);
    Assertions.assertEquals(result, 800);

    int len = rectangle.getLength();
    int wid = rectangle.getWidth();
    result = rectangle.overloadM2(len, wid);
    Assertions.assertEquals(result, 800);

    result = rectangle.overloadM2(len);
    Assertions.assertEquals(result, 800);

    result = rectangle.overloadM2();
    Assertions.assertEquals(result, 80);

    result = rectangle.overloadCirc(rectangle);
    Assertions.assertEquals(result, 120);

    result = rectangle.overloadCirc(len, wid);
    Assertions.assertEquals(result, 120);

    result = rectangle.overloadCirc(len);
    Assertions.assertEquals(result, 120);

    result = rectangle.overloadCirc();
    Assertions.assertEquals(result, 84);

    result = rectangle.calcFit(rectangle);
    Assertions.assertEquals(result, 1);

    result = rectangle.calcFit(len, wid);
    Assertions.assertEquals(result, 1);

    result = rectangle.calcFit(len);
    Assertions.assertEquals(result, 1);

    result = rectangle.calcFit();
    Assertions.assertEquals(result, 10);
  }
  @Test
  void calculatorTest2(){
    Rectangle rectangle = new Rectangle(8);
    int[] dimensionTest = {4, 8};
    int[] dimension = new int[]{rectangle.getLength(), rectangle.getWidth()};
    Assertions.assertArrayEquals(dimension, dimensionTest);

    int result = rectangle.overloadM2(rectangle);
    Assertions.assertEquals(result, 32);

    int len = rectangle.getLength();
    int wid = rectangle.getWidth();
    result = rectangle.overloadM2(len, wid);
    Assertions.assertEquals(result, 32);

    result = rectangle.overloadM2(len);
    Assertions.assertEquals(result, 32);

    result = rectangle.overloadM2();
    Assertions.assertEquals(result, 8);

    result = rectangle.overloadCirc(rectangle);
    Assertions.assertEquals(result, 24);

    result = rectangle.overloadCirc(len, wid);
    Assertions.assertEquals(result, 24);

    result = rectangle.overloadCirc(len);
    Assertions.assertEquals(result, 24);

    result = rectangle.overloadCirc();
    Assertions.assertEquals(result, 12);

    result = rectangle.calcFit(rectangle);
    Assertions.assertEquals(result, 20);

    result = rectangle.calcFit(len, wid);
    Assertions.assertEquals(result, 20);

    result = rectangle.calcFit(len);
    Assertions.assertEquals(result, 20);

    result = rectangle.calcFit();
    Assertions.assertEquals(result, 100);
  }

  @Test
  void calculatorTest3(){
    Rectangle rectangle = new Rectangle(9,5);
    int[] dimensionTest = {9, 5};
    int[] dimension = new int[]{rectangle.getLength(), rectangle.getWidth()};
    Assertions.assertArrayEquals(dimension, dimensionTest);

    int result = rectangle.overloadM2(rectangle);
    Assertions.assertEquals(result, 45);

    int len = rectangle.getLength();
    int wid = rectangle.getWidth();
    result = rectangle.overloadM2(len, wid);
    Assertions.assertEquals(result, 45);

    result = rectangle.overloadM2(len);
    Assertions.assertEquals(result, 45);

    result = rectangle.overloadM2();
    Assertions.assertEquals(result, 18);

    result = rectangle.overloadCirc(rectangle);
    Assertions.assertEquals(result, 28);

    result = rectangle.overloadCirc(len, wid);
    Assertions.assertEquals(result, 28);

    result = rectangle.overloadCirc(len);
    Assertions.assertEquals(result, 28);

    result = rectangle.overloadCirc();
    Assertions.assertEquals(result, 22);

    result = rectangle.calcFit(rectangle);
    Assertions.assertEquals(result, 16);
    result = rectangle.calcFit(len, wid);
    Assertions.assertEquals(result, 16);

    result = rectangle.calcFit(len);
    Assertions.assertEquals(result, 16);

    result = rectangle.calcFit();
    Assertions.assertEquals(result, 40);
  }
}