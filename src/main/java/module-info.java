module com.example.supplychain_nov {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.supplychain_nov to javafx.fxml;
    exports com.example.supplychain_nov;
}