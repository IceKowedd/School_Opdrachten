package com.example.school_management_system.app;

// imports for JavaFX
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

// ConfirmBox class
public class ConfirmBox {

    // static variable to store the answer
    static boolean answer;

    // static method to display the confirmation box
    public static boolean display(String title, String message) {
        // create a new window
        Stage window = new Stage();

        // set the properties of the window
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        // create a new label
        Label label = new Label();
        label.setText(message);

        // create two buttons
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        // set the actions for the buttons
        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });

        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        // create a new VBox layout
        VBox layout = new VBox(10);
        // add the label and buttons to the layout
        layout.getChildren().addAll(label, yesButton, noButton);
        // set the alignment of the layout
        layout.setAlignment(Pos.CENTER);

        // create a new scene
        Scene scene = new Scene(layout);
        // set the scene of the window
        window.setScene(scene);
        // show the window and wait for it to be closed
        window.showAndWait();

        return answer;
    }
}