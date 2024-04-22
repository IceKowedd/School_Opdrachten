package com.example.school_management_system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

  @Override
  public void start(Stage window) throws IOException {
    window.setOnCloseRequest(e -> {
      e.consume();
      boolean isConfirmed = ConfirmBox.display("Confirmation", "Are you sure you want to exit?");
      if (isConfirmed)
        window.close();
    });

    window.setResizable(true);
    FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml"));
    Pane root = fxmlLoader.load();
    AppController controller = fxmlLoader.getController();
    controller.setWindow(window);

    controller.getSlider().valueProperty().addListener((observable, oldValue, newValue) -> {
      root.setScaleX(newValue.doubleValue());
      root.setScaleY(newValue.doubleValue());
    });

    Scene scene = new Scene(root, 1920, 1080);

    window.setTitle("School Management System");
    window.setScene(scene);
    window.show();
  }

  public static void main(String[] args) {
    launch();
  }
}