package com.example.school_management_system.classroom;
import com.example.school_management_system.personages.*;
import java.util.List;

public class ClassRoom {

  private String classroomID;
  private String classroomName;
  private List<Mentor> mentors;
  private List<Teacher> teachers;
  private List<Student> students;

  public ClassRoom(String classroomID, String classroomName, List<Mentor> mentors, List<Teacher> teachers, List<Student> students) {
    this.classroomID = classroomID;
    this.classroomName = classroomName;
    this.mentors = mentors;
    this.teachers = teachers;
    this.students = students;
  }
}
