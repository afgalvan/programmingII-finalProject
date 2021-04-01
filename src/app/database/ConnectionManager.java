package app.database;

import java.sql.*;

public class ConnectionManager {

    private final String URL = "jdbc:sqlite:./src/app/database/database.sqlite";
    protected Connection connection;

    public ConnectionManager() {
        connection = null;
    }

    public void open() throws SQLException {
        this.connection = DriverManager.getConnection(URL);
    }

    public void close() {
        try {
            this.connection.close();
        } catch (SQLException | NullPointerException ignore) {
            System.out.println(connection);
        }
    }

    public PreparedStatement prepareStatement(String statement) throws SQLException {
        return this.connection.prepareStatement(statement);
    }

    public Statement createStatement() throws SQLException {
        return this.connection.createStatement();
    }
}
