package com.example.supplychainkrishna29dec;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SupplyChain extends Application {
    public static final int width = 700, height = 600, header = 60;
    BorderPane root;

    ProductDetails productDetails = new ProductDetails();
    GridPane getHeaderBar() {
        TextField searchTextField = new TextField();
        searchTextField.setPromptText("Search product");
        searchTextField.setPrefWidth(200);
        searchTextField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String productName = searchTextField.getText();

                root.setLeft(null);
                root.setLeft(productDetails.getProductsByName(productName));
            }
        });

        Button searchButton = new Button("Search");
        searchButton.setPrefWidth(100);
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String productName = searchTextField.getText();

                root.setLeft(null);
                root.setLeft(productDetails.getProductsByName(productName));
            }
        });

        GridPane headerBar = new GridPane();
        headerBar.setHgap(5);
        headerBar.setStyle("-fx-background-color: Black");

        headerBar.add(searchTextField,0,0);
        headerBar.add(searchButton,1,0);
        headerBar.setPrefSize(width,header);
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
        loginPage.setTranslateX(-40);
        loginPage.setTranslateY(20);
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
        root = new BorderPane();
        root.setStyle("-fx-background-color: Yellow");

        root.setTop(getHeaderBar());
//        root.setRight(getBodyPane());
        root.setLeft(productDetails.getAllProducts());
        return root;
    }
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(createContent(),width,height);
        stage.setTitle("Supply Chain Management");
        stage.setScene(scene);
        stage.setMinHeight(height);
        stage.setMinWidth(width);
        stage.setMaxWidth(width);
        stage.setMaxHeight(height);
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}