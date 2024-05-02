package com.example.school_management_system.personages;

public class Student extends Person{
  private String studentID;
  private String classroomID;

  public Student(String name, String lastname, String birthdate, String phone, String email,
      String address, String city, String studentID, String classroomID) {

    super(name, lastname, birthdate, phone, email, address, city);
    this.studentID = studentID;
    this.classroomID = classroomID;
  }

  public String getStudentID() {
    return studentID;
  }

  public String getClassroomID() {
    return classroomID;
  }

  public void setStudentID(String studentID) {
    this.studentID = studentID;
  }

  public void setClassroomID(String classroomID) {
    this.classroomID = classroomID;
  }
}
