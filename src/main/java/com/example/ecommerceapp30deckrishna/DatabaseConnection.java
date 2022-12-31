package com.example.ecommerceapp30deckrishna;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {

    public Statement getStatement() {
        Statement statement = null;
        Connection connection;
        try {
            String databaseURL = "jdbc:mysql://127.0.0.1:3306/supply_chain";
            String username = "root";
            String password = "Jhaswin@143";
            connection = DriverManager.getConnection(databaseURL, username, password);
            statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return statement;
    }

    public ResultSet getQueryTable(String query) {
        Statement statement = getStatement();
        try {
            return statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        ResultSet resultSet = databaseConnection.getQueryTable("SELECT * FROM customer;");
        try {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("email") + " " + resultSet.getString("password") + " " +
                        resultSet.getString("first_name") + " " + resultSet.getString("mobile_number"));
        }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
