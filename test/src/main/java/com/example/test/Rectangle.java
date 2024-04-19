package com.example.test;

public class Rectangle {

  private final int length;
  private final int width;

  public Rectangle () {
  this.length = 40;
  this.width = 20;
  }

  public Rectangle (int width) {
  this.length = 4;
  this.width = width;
  }

  public Rectangle (int length, int width) {
  this.length = length;
  this.width = width;
  }

  public int overloadM2(Rectangle rectangle) {
    return rectangle.length * width;
  }

  public int overloadM2(int length, int width) {
    return length * width;
  }

  public int overloadM2(int length) {
    return length * width;
  }

  public int overloadM2() {
    return length * 2;
  }

  public int overloadCirc(Rectangle rectangle) {
    return ((rectangle.length * 2) + (width * 2));
  }

  public int overloadCirc(int length, int width) {
    return ((length * 2) + (width * 2));
  }

  public int overloadCirc(int length) {
    return ((length * 2) + (width * 2));
  }

  public int overloadCirc() {
    return ((length * 2) + (2 * 2));
  }

  public int getLength() {
    return length;
  }

  public int getWidth() {
    return width;
  }

  public int calcFit(Rectangle rectangle) {
    Rectangle rectangleTest = new Rectangle();
    int fitLength = rectangleTest.length / rectangle.length;
    int fitWidth = rectangleTest.width / rectangle.width;
    return fitLength * fitWidth;
  }

  public int calcFit(int length, int width) {
    Rectangle rectangleTest = new Rectangle();
    int fitLength = rectangleTest.length / length;
    int fitWidth = rectangleTest.width / width;
    return fitLength * fitWidth;
  }

  public int calcFit(int length) {
    Rectangle rectangleTest = new Rectangle();
    int fitLength = rectangleTest.length / length;
    int fitWidth = rectangleTest.width / width;
    return fitLength * fitWidth;
  }

  public int calcFit() {
    Rectangle rectangleTest = new Rectangle();
    int fitLength = rectangleTest.length / length;
    int fitWidth = rectangleTest.width / 2;
    return fitLength * fitWidth;
  }
}