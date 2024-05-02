// StudentFormController.java
package com.example.school_management_system.form;

// Import the necessary classes
import com.example.school_management_system.personages.Student;
import java.util.Random;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

// StudentFormController class
public class StudentFormController extends PersonFormController {
    // FXML fields
    @FXML
    private TextField idField;

    // StudentFormController constructor
    public StudentFormController() {
        super();
    }

    // generateUniqueID method
    @Override
    protected String generateUniqueID() {
        // Generate a unique student ID
        return String.valueOf(new Random().nextInt(10000));
    }

    // handleSubmitButtonAction method
    @FXML
    @Override
    protected void handleSubmitButtonAction() {
        // Call the super method
        super.handleSubmitButtonAction();

        String id = idField.getText();

        if (id.isEmpty()) {
            // Use the default ID
            id = generateUniqueID();
        }

        // Create a new student
        Student newStudent = new Student(getName(), getLastname(), getBirthdate(), getPhone(), getEmail(), getAddress(), getCity(), id, null);

        // Add the new student to the list
        // This will depend on how we're going to store the students ofc.
    }
}