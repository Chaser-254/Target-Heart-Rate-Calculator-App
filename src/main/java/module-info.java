module com.example.thrapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.thrapp to javafx.fxml;
    exports com.example.thrapp;
}