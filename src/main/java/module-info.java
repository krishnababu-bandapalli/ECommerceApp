module com.example.ecommerceapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.supplychainkrishna29dec to javafx.fxml;
    exports com.example.supplychainkrishna29dec;
}