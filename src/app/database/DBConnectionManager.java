package app.database;

import java.sql.*;
import lombok.Data;

/**
 * Class to manage the connection between the software and the database
 */
@Data
public class DBConnectionManager implements DBConnection {

    private String url;
    private Connection _connection;

    public DBConnectionManager() {
        this("jdbc:sqlite:./src/app/database/database.sqlite");
    }

    public DBConnectionManager(String driverUrl) {
        this._connection = null;
        this.url = driverUrl;
    }

    /**
     * Open the connection with the sqlite file to able the queries.
     *
     * @throws SQLException When database file not found.
     */
    @Override
    public void open() throws SQLException {
        this._connection = DriverManager.getConnection(url);
    }

    /**
     * Close the connection between file and program to avoid memory leak.
     */
    @Override
    public void close() {
        try {
            if (_connection != null) {
                this._connection.close();
            }
        } catch (SQLException error) {
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
        return this._connection.prepareStatement(statement);
    }

    /**
     * Convert a String to a SQL statement to be executed immediately.
     *
     * @return A statement interface instance to be executed.
     * @throws SQLException For a statements with syntax errors or non match queries.
     */
    public Statement createStatement() throws SQLException {
        return this._connection.createStatement();
    }
}
