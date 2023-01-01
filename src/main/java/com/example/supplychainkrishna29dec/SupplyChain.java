package com.example.supplychainkrishna29dec;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SupplyChain extends Application {
    public static final int width = 920, height = 650, header = 60;
    BorderPane root;

    ProductDetails productDetails = new ProductDetails();
    GridPane getHeaderBar() {
        Image logo = new Image("C:\\Users\\krish_uv7qyqm\\IdeaProjects\\ECommerceApp\\src\\main\\eShopLogo.png");
        ImageView imageView = new ImageView(logo);
        imageView.setImage(logo);
        imageView.setFitWidth(40);
        imageView.setFitHeight(40);

        Button logoButton = new Button();
        logoButton.setGraphic(imageView);
        logoButton.setStyle("-fx-background-color: Black");
        logoButton.setCursor(Cursor.OPEN_HAND);
        logoButton.setPrefSize(40,40);
        logoButton.setTranslateX(10);

        logoButton.setOnAction(actionEvent -> {
            root.setCenter(productDetails.getAllProducts());
            root.setBottom(getFooter());
        });

        TextField searchTextField = new TextField();
        searchTextField.setPromptText("Search product");
        searchTextField.setFont(new Font("Times New Roman",13));
        searchTextField.setPrefWidth(300);

        searchTextField.setOnAction(actionEvent -> {
            String productName = searchTextField.getText();

            root.setCenter(productDetails.getProductsByName(productName));
            root.setBottom(getFooter());
        });

        Button searchButton = new Button("Search");
        searchButton.setPrefWidth(100);
        searchButton.setTranslateX(-20);
        searchButton.setFont(new Font("Times New Roman",13));
        searchButton.setStyle("-fx-background-color: White");

        searchButton.setOnAction(actionEvent -> {
            String productName = searchTextField.getText();

            root.setCenter(productDetails.getProductsByName(productName));
            root.setBottom(getFooter());
        });

        Image cartLogo = new Image("C:\\Users\\krish_uv7qyqm\\IdeaProjects\\ECommerceApp\\src\\main\\cartLogo.png");
        ImageView cart = new ImageView(cartLogo);
        cart.setImage(cartLogo);
        cart.setFitWidth(40);
        cart.setFitHeight(40);

        Button cartLogoButton = new Button();
        cartLogoButton.setGraphic(cart);
        cartLogoButton.setStyle("-fx-background-color: Black");
        cartLogoButton.setCursor(Cursor.OPEN_HAND);
        cartLogoButton.setPrefSize(40,40);
        cartLogoButton.setTranslateX(30);

        cartLogoButton.setOnAction(actionEvent -> {
            root.setCenter(productDetails.getAllProducts());
            root.setBottom(getFooter());
        });

        Button loginButton = new Button("Login");
        loginButton.setPrefWidth(100);
        loginButton.setTranslateX(30);
        loginButton.setFont(new Font("Times New Roman",13));
        loginButton.setStyle("-fx-background-color: White");

        loginButton.setOnAction(actionEvent -> {
            root.setBottom(null);
            root.setCenter(getLoginPage());
        });

        Button signUpButton = new Button("Register");
        signUpButton.setPrefWidth(100);
        signUpButton.setTranslateX(20);
        signUpButton.setFont(new Font("Times New Roman",13));
        signUpButton.setStyle("-fx-background-color: White");

        signUpButton.setOnAction(actionEvent -> {
            root.setBottom(null);
            root.setCenter(getSignUpPage());
        });

        GridPane headerBar = new GridPane();
        headerBar.setPrefHeight(header);
        headerBar.setHgap(30);
        headerBar.setTranslateY(7);
        headerBar.setStyle("-fx-background-color: Black");


        headerBar.add(logoButton,0,0);
        headerBar.add(searchTextField,1,0);
        headerBar.add(searchButton,2,0);
        headerBar.add(loginButton,3,0);
        headerBar.add(signUpButton,4,0);
        headerBar.add(cartLogoButton,5,0);
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
        loginButton.setStyle("-fx-background-color: White");
        loginButton.setFont(new Font("Times New Roman",13));
        loginButton.setAlignment(Pos.CENTER);

        GridPane loginPage = new GridPane();
        loginPage.setPrefSize(width, height);
        loginPage.setAlignment(Pos.CENTER);
        loginPage.setVgap(5);
        loginPage.add(emailTextField,0,0);
        loginPage.add(passwordField,0,1);
        loginPage.add(loginButton,0,2);

        return loginPage;
    }
    GridPane getSignUpPage() {
        TextField firstNameField = new TextField();
        firstNameField.setPromptText("Enter your first name");
        firstNameField.setPrefWidth(170);
        firstNameField.setFocusTraversable(false);

        TextField lastNameField = new TextField();
        lastNameField.setPromptText("Enter your last name");
        lastNameField.setPrefWidth(170);
        lastNameField.setFocusTraversable(false);

        TextField mobileNumberField = new TextField();
        mobileNumberField.setPromptText("Enter your mobile number");
        mobileNumberField.setPrefWidth(170);
        mobileNumberField.setFocusTraversable(false);

        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email");
        emailField.setPrefWidth(170);
        emailField.setFocusTraversable(false);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter a strong password");
        passwordField.setPrefWidth(170);
        passwordField.setFocusTraversable(false);

        Button registerButton = new Button("Register");
        registerButton.setPrefWidth(170);
        registerButton.setStyle("-fx-background-color: White");
        registerButton.setFont(new Font("Times New Roman",13));
        registerButton.setAlignment(Pos.CENTER);

        GridPane registerPage = new GridPane();
        registerPage.setPrefSize(width, height);
        registerPage.setAlignment(Pos.CENTER);
        registerPage.setVgap(5);

        registerPage.add(firstNameField,0,0);
        registerPage.add(lastNameField,0,1);
        registerPage.add(mobileNumberField,0,2);
        registerPage.add(emailField,0,3);
        registerPage.add(passwordField,0,4);
        registerPage.add(registerButton,0,5);

        return registerPage;
    }

    GridPane getFooter() {
        Button addTocartButton = new Button("Add to Cart");
        addTocartButton.setPrefWidth(170);
        addTocartButton.setStyle("-fx-background-color: White");
        addTocartButton.setFont(new Font("Times New Roman",13));
        addTocartButton.setTranslateX(-50);

        Button buyNowButton = new Button("Buy Now");
        buyNowButton.setPrefWidth(170);
        buyNowButton.setStyle("-fx-background-color: White");
        buyNowButton.setFont(new Font("Times New Roman",13));
        buyNowButton.setTranslateX(50);

        GridPane footer = new GridPane();
        footer.setPrefSize(width,header);
        footer.setStyle("-fx-background-color: Black");
        footer.setAlignment(Pos.CENTER);

        footer.add(addTocartButton,0,0);
        footer.add(buyNowButton,1,0);

        return footer;
    }

    BorderPane createContent(){
        root = new BorderPane();

        root.setTop(getHeaderBar());
        root.setCenter(productDetails.getAllProducts());
        root.setBottom(getFooter());

        Image backgroundImage = new Image("C:\\Users\\krish_uv7qyqm\\IdeaProjects\\ECommerceApp\\src\\main\\background.jpg");
        BackgroundSize bSize = new BackgroundSize(height, width, false, false, true, false);
        root.setBackground(new Background(new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize)));

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
        Image logo = new Image("C:\\Users\\krish_uv7qyqm\\IdeaProjects\\ECommerceApp\\src\\main\\eShopLogo.png");
        stage.getIcons().add(logo);
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}