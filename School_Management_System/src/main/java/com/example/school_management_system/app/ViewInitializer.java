package com.example.school_management_system.app;

// imports from the javafx package
import com.example.school_management_system.form.PersonFormController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.TableView;
// imports from the school_management_system package
import com.example.school_management_system.personages.Person;
// imports from the java.util package
import java.util.List;

// ViewInitializer class
public class ViewInitializer {

  // initializeClassroomView method
  public VBox initializeClassroomView() {
    // VBox object being created.
    VBox classroomView = new VBox();
    // Button object being created.
    Button addClassroomButton = new Button("Add Classroom");
    // setOnAction method being called on the addClassroomButton object.
    addClassroomButton.setOnAction(e -> System.out.println("Classroom added!"));
    // add method being called on the classroomView object.
    classroomView.getChildren().add(addClassroomButton);
    return classroomView;
  }

  // initializeTeacherView method
  public VBox initializeTeacherView() {
    VBox teacherView = new VBox();
    Button addTeacherButton = new Button("Add Teacher");
    addTeacherButton.setOnAction(e -> System.out.println("Teacher added!"));
    teacherView.getChildren().add(addTeacherButton);
    return teacherView;
  }

  // initializeMentorView method
  public VBox initializeMentorView() {
    VBox mentorView = new VBox();
    Button addMentorButton = new Button("Add Mentor");
    addMentorButton.setOnAction(e -> System.out.println("Mentor added!"));
    mentorView.getChildren().add(addMentorButton);
    return mentorView;
  }

  // initializeStudentView method
  public VBox initializeStudentView() {
    VBox studentView = new VBox();

    // Load the form when initializing the view
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/school_management_system/person-form.fxml"));
    try {
        Pane personForm = fxmlLoader.load();
        PersonFormController controller = fxmlLoader.getController();
        // controller.setDefaultID(generateUniqueStudentID()); // Implement this method

        studentView.getChildren().add(personForm);
    } catch (IOException ex) {
        ex.printStackTrace();
    }

    // Use the "Add" button as the submit button
    Button otherButton = new Button("different button");
    otherButton.setOnAction(e -> {
        System.out.println("you clicked the different button!");
    });

    studentView.getChildren().add(otherButton);

    return studentView;
}

  // initializeTableView method
  public void populateTableView(List<? extends Person> people, TableView<Person> tableView) {
    // Clear the existing items in the table
    tableView.getItems().clear();

    // Add all the people to the table
    tableView.getItems().addAll(people);
}

}