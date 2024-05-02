package com.example.school_management_system.app;

// imports from javafx
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

// imports from java
import java.io.IOException;

// MainApplication class
public class MainApplication extends Application {

  // start method
  @Override
  public void start(Stage window) throws IOException {
    // Set the window to not close when the close button is clicked
    window.setOnCloseRequest(e -> {
      e.consume();
      // Display a confirmation box
      boolean isConfirmed = ConfirmBox.display("Confirmation", "Are you sure you want to exit?");
      // If the user confirms, close the window
      if (isConfirmed)
        window.close();
    });

    // Set the window to be resizable
    window.setResizable(true);
    // Load the FXML file
    FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/example/school_management_system/hello-view.fxml"));
    // Load the root pane
    Pane root = fxmlLoader.load();
    // Create a new scene
    Scene scene = new Scene(root, 1920, 1080);
    // Set the scene
    window.setTitle("School Management System");
    window.setScene(scene);
    window.show();
  }
  // main method
  public static void main(String[] args) {
    // Launch the application
    launch();
  }
}