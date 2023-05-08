module com.example.usermanagesystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.usermanagesystem to javafx.fxml;
    exports com.example.usermanagesystem;
}