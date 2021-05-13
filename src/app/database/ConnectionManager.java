package app.database;

import java.sql.*;
import lombok.Data;

/**
 * Class to manage the connection between the software and the database
 */
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

    /**
     * Open the connection with the sqlite file to able the queries.
     *
     * @throws SQLException When database file not found.
     */
    public void open() throws SQLException {
        this.connection = DriverManager.getConnection(url);
    }

    /**
     * Close the connection between file and program to avoid memory leak.
     */
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException | NullPointerException error) {
            System.out.println(error.getMessage());
        }
    }

    /**
     * Convert a String to a SQL prepared statement to use placeholders for
     * being replaced with variables.
     *
     * @param statement String SQL statement with at least one placeholder.
     * @return A Prepared Statement interface instance to be executed.
     * @throws SQLException For a statements with syntax errors or non match queries.
     */
    public PreparedStatement prepareStatement(String statement) throws SQLException {
        return this.connection.prepareStatement(statement);
    }

    /**
     * Convert a String to a SQL statement to be executed immediately.
     *
     * @return A statement interface instance to be executed.
     * @throws SQLException For a statements with syntax errors or non match queries.
     */
    public Statement createStatement() throws SQLException {
        return this.connection.createStatement();
    }
}
