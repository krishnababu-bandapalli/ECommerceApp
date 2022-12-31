package com.example.ecommerceapp30deckrishna;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SupplyChain extends Application {

    GridPane getHeaderBar() {
        TextField searchTextField = new TextField();
        searchTextField.setPromptText("Search product");
        searchTextField.setPrefWidth(200);

        Button searchButton = new Button("Search");
        searchButton.setPrefWidth(100);

        GridPane headerBar = new GridPane();
        headerBar.setHgap(5);

        headerBar.add(searchTextField,0,0);
        headerBar.add(searchButton,1,0);
        headerBar.setPrefSize(600,50);
        headerBar.setAlignment(Pos.CENTER);
        return headerBar;
    }

    GridPane getLoginPage() {
        TextField emailTextField = new TextField();
        emailTextField.setPromptText("Enter your email");
        emailTextField.setPrefWidth(170);
        emailTextField.setFocusTraversable(false);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter password");
        passwordField.setPrefWidth(170);
        passwordField.setFocusTraversable(false);

        Button loginButton = new Button("Login");
        loginButton.setPrefWidth(170);
        loginButton.setAlignment(Pos.CENTER);

        GridPane loginPage = new GridPane();
        loginPage.setVgap(5);
        loginPage.add(emailTextField,0,0);
        loginPage.add(passwordField,0,1);
        loginPage.add(loginButton,0,2);

        return loginPage;
    }

    GridPane getBodyPane() {
        GridPane bodyPane = new GridPane();
        bodyPane.setAlignment(Pos.CENTER);

        bodyPane.add(getLoginPage(),0,1);
        return bodyPane;
    }
    BorderPane createContent(){
        BorderPane root = new BorderPane();

        root.setTop(getHeaderBar());
        root.setCenter(getBodyPane());
        return root;
    }
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(createContent(),600,600);
        stage.setTitle("Supply Chain Management");
        stage.setScene(scene);
        stage.setMinWidth(600);
        stage.setMinHeight(600);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}