module com.example.school_management_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;

    exports com.example.school_management_system.form to javafx.fxml;
    exports com.example.school_management_system.personages;
    exports com.example.school_management_system.app;
    opens com.example.school_management_system.form to javafx.fxml;
    opens com.example.school_management_system.app to javafx.fxml;
    opens com.example.school_management_system to javafx.fxml;
}