module com.example.typespeed {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.typespeed to javafx.fxml;
    exports com.example.typespeed;
}