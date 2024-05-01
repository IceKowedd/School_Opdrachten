package com.example.school_management_system;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppController {
  @FXML
  private ListView<String> functionList;
  @FXML
  private Button goodbyeButton;
  @FXML
  private Slider slider;
  @FXML
  private StackPane functionViewPane;
  @FXML
  private Label welcomeText;
  private VBox studentView;
  private VBox mentorView;
  private VBox classroomView;
  private Stage window;
  private Group group;

  private ViewInitializer viewInitializer = new ViewInitializer();

  public void initialize() {


    functionList.getItems().addAll("Classrooms", "Mentors", "Students");
    functionList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
      group.getChildren().clear();
      if (newValue.equals("Classrooms")) {
        group.getChildren().add(classroomView);
      } else if (newValue.equals("Mentors")) {
        group.getChildren().add(mentorView);
      } else if (newValue.equals("Students")) {
        group.getChildren().add(studentView);
      }
    });


    studentView = viewInitializer.initializeStudentView();
    mentorView = viewInitializer.initializeMentorView();
    classroomView = viewInitializer.initializeClassroomView();


    //group = new Group();
    //functionViewPane.getChildren().add(group);


    slider.valueProperty().addListener((observable, oldValue, newValue) -> {
      double newScale = newValue.doubleValue();
      if (functionList.getPrefHeight() * newScale > functionList.getPrefHeight()) {
        newScale = functionList.getPrefHeight() / functionList.getPrefHeight();
      }
      functionList.setScaleX(newScale);
      functionList.setScaleY(newScale);
    });
  }



  public void setWindow(Stage window) {
    this.window = window;
  }

  @FXML
  protected void onHelloButtonClick() {
    welcomeText.setText("Welcome to JavaFX Application!");
  }

  @FXML
  protected void onGoodbyeButtonClick() {
    boolean isConfirmed = ConfirmBox.display("Confirmation", "Are you sure you want to exit?");
    if (isConfirmed)
      window.close();
  }
  public Button getGoodbyeButton() {
    return goodbyeButton;
  }

  public ListView<String> getFunctionList() {
    return functionList;
  }

  public Slider getSlider() {
    return slider;
  }
}