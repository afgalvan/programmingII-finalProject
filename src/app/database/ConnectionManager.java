package app.database;

import java.sql.*;
import lombok.Data;

@Data
public class ConnectionManager {

    private String url;
    protected Connection connection;

    public ConnectionManager() {
        this("jdbc:sqlite:./src/app/database/database.sqlite");
    }

    public ConnectionManager(String url) {
        this.connection = null;
        this.url = url;
    }

    public void open() throws SQLException {
        this.connection = DriverManager.getConnection(url);
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
