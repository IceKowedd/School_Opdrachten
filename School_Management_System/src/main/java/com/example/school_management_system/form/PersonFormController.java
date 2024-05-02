package com.example.school_management_system.form;

// import the necessary classes
import java.util.UUID;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

// PersonFormController class
public class PersonFormController {

    // FXML fields
    @FXML
    private TextField nameField;
    @FXML
    private TextField lastnameField;
    @FXML
    private TextField birthdateField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField idField;

    // defaultID field
    private String defaultID;

    // PersonFormController constructor
    public PersonFormController() {
        this.defaultID = generateUniqueID();
    }

    // generateUniqueID method
protected String generateUniqueID() {
        // Generate a unique ID
    return UUID.randomUUID().toString();
    }

    // handleSubmitButtonAction method
    @FXML
protected void handleSubmitButtonAction() {
    String name = nameField.getText();
    String lastname = lastnameField.getText();
    String birthdate = birthdateField.getText();
    String phone = phoneField.getText();
    String email = emailField.getText();
    String address = addressField.getText();
    String city = cityField.getText();
    String id = idField.getText();

    // Validate the input
    if (name.isEmpty() || lastname.isEmpty() || birthdate.isEmpty() || phone.isEmpty() || email.isEmpty() || address.isEmpty() || city.isEmpty() ) {
        // Display an error message
        System.out.println("All fields must be filled out");
    } else {
        System.out.println("Created Name: " + name);
        }
    }

    // getName method
    protected String getName() {
        return nameField.getText();
    }

    // getLastname method
    protected String getLastname() {
        return lastnameField.getText();
    }

    // getBirthdate method
    protected String getBirthdate() {
        return birthdateField.getText();
    }

    // getPhone method
    protected String getPhone() {
        return phoneField.getText();
    }

    // getEmail method
    protected String getEmail() {
        return emailField.getText();
    }

    // getAddress method
    protected String getAddress() {
        return addressField.getText();
    }

    // getCity method
    protected String getCity() {
        return cityField.getText();
    }
}