package com.example.school_management_system.personages;

public abstract class Employee extends Person {

  protected String employeeID;
  protected String classroomID;


  public Employee(String name, String lastname, String birthdate, String phone, String email,
      String address, String city, String employeeID, String classroomID) {

    super(name, lastname, birthdate, phone, email, address, city);
    this.employeeID = employeeID;
    this.classroomID = classroomID;
  }

  public String getEmployeeID() {
    return employeeID;
  }

  public String getClassroomID() {
    return classroomID;
  }

  public void setEmployeeID(String employeeID) {
    this.employeeID = employeeID;
  }

  public void setClassroomID(String classroomID) {
    this.classroomID = classroomID;
  }
}
