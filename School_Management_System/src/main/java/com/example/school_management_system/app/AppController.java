package com.example.school_management_system.app;

// imports from school_management_system
import com.example.school_management_system.personages.Mentor;
import com.example.school_management_system.personages.Person;
import com.example.school_management_system.personages.Student;
import com.example.school_management_system.personages.Teacher;

// imports from java util
import java.util.ArrayList;
import java.util.List;

// imports from javafx
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.Group;

// AppController class
public class AppController {

  // FXML fields
  @FXML
  private TabPane tabPane;
  @FXML
  private Button goodbyeButton;
  @FXML
  private BorderPane borderPane;
  @FXML
  private TableView<Person> studentTable;
  @FXML
  private TableView<Person> teacherTable;
  @FXML
  private TableView<Person> mentorTable;

  // VBox Fields
  private VBox studentView;
  private VBox mentorView;
  private VBox classroomView;
  private VBox teacherView;

  // Group field
  private Group group;

  // List fields
  private List<Student> studentList = new ArrayList<>();
  private List<Teacher> teacherList = new ArrayList<>();
  private List<Mentor> mentorList = new ArrayList<>();

  // View initializer object being created.
  private ViewInitializer viewInitializer = new ViewInitializer();


  // This method is called by the FXMLLoader when initialization is complete.
  public void initialize() {

    group = new Group();

    // Initialize the views
    studentView = viewInitializer.initializeStudentView();
    mentorView = viewInitializer.initializeMentorView();
    classroomView = viewInitializer.initializeClassroomView();
    teacherView = viewInitializer.initializeTeacherView();


    // Create tabs for each view
    // classroomTab
    Tab classroomsTab = new Tab("Classrooms");
    // setOnSelectionChanged method being called on the classroomsTab object.
    classroomsTab.setOnSelectionChanged(event -> {
      if (classroomsTab.isSelected()) {
        // setCenter method being called on the borderPane object.
        borderPane.setCenter(classroomView);
      }
    });

    // teacherTab
    Tab teacherTab = new Tab("Teachers");
    teacherTab.setOnSelectionChanged(event -> {
      if (teacherTab.isSelected()) {
        borderPane.setCenter(teacherView);
      }
    });

    // mentorsTab
    Tab mentorsTab = new Tab("Mentors");
    mentorsTab.setOnSelectionChanged(event -> {
      if (mentorsTab.isSelected()) {
        borderPane.setCenter(mentorView);
      }
    });

    // studentsTab
    Tab studentsTab = new Tab("Students");
    studentsTab.setOnSelectionChanged(event -> {
      if (studentsTab.isSelected()) {
        borderPane.setCenter(studentView);
      }
    });

    // Add the tabs to the tab pane
    tabPane.getTabs().addAll(classroomsTab, teacherTab, mentorsTab, studentsTab);

    // Create table views for each type of person
    studentTable = new TableView<>();
    teacherTable = new TableView<>();
    mentorTable = new TableView<>();

    // Add the table views to the group
    viewInitializer.populateTableView(studentList, studentTable);
    viewInitializer.populateTableView(teacherList, teacherTable);
    viewInitializer.populateTableView(mentorList, mentorTable);
  }

  // Event handler for the goodbye button
  @FXML
  protected void onGoodbyeButtonClick() {
    // Display a confirmation box
    boolean isConfirmed = ConfirmBox.display("Confirmation", "Are you sure you want to exit?");
    // If the user confirms, exit the application
    if (isConfirmed)
      Platform.exit();
  }
}