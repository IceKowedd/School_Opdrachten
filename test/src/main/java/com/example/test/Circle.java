package com.example.test;

public class Circle {

  private double radius;
  private int diameter;
  private static final double PIE = 3.14159265358979323846;

  public Circle (double radius) {
    this.radius = radius;
  }

  public Circle () {
    this.radius = 8.0;
  }

  public int toDiameter (double radius) {
    return (int) (radius * 2.0);
  }

  public int toDiameter () {
    return (int) (this.radius * 2.0);
  }

  public double toRadius (int diameter) {
    radius = diameter / 2.0;
    this.diameter = diameter;
    return radius;
  }

  public double getCircleCirc (int diameter) {
    return PIE * diameter;
  }

  public double getCircleCirc (double radius) {
    return ((radius * 2) * PIE);
  }

  public double getCircleM2 (int diameter) {
    return ((diameter * 2) * PIE);
  }

  public double getCircleM2 (double radius) {
    return ((radius * 4) * PIE);
  }

  public double getRadius () {
    return this.radius;
  }

  public int getDiameter () {
    return this.diameter;
  }

  public void setNewValue (int diameter) {
    this.diameter = diameter;
    this.radius = (double) diameter / 2;
  }

  public double pole (int poles) {
    double result = getCircleCirc(this.radius);
    return result / poles;
  }

  public double pole (double perM2) {
    double result = getCircleCirc(this.radius);
    return result / perM2;
  }
}
