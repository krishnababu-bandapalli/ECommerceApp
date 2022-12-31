module com.example.ecommerceapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.ecommerceapp30deckrishna to javafx.fxml;
    exports com.example.ecommerceapp30deckrishna;
}