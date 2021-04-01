package app.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {

    private final String URL = "jdbc:sqlite:./src/app/database/database.sqlite";
    protected Connection connection;

    public DBConnection() {
        connection = null;
    }

    public void open() {
        try {
            this.connection = DriverManager.getConnection(URL);
            System.out.println("Successfully connected to SQLite");
        } catch (SQLException throwables) {
            System.out.println("Opps! error while connecting with SQLite");
            throwables.printStackTrace();
        }
    }

    public void close() {
        try {
            this.connection.close();
            System.out.println("Successfully closed connection with SQLite");
        } catch (SQLException throwables) {
            System.out.println("Opps! error while closing connection with SQLite");
            throwables.printStackTrace();
        }
    }

    public PreparedStatement prepareStatement(String statement) throws SQLException {
        return this.connection.prepareStatement(statement);
    }
}
