package app.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public interface DBConnection extends DataConnection {
    Connection get_connection();

    String getUrl();

    PreparedStatement prepareStatement(String statement) throws SQLException;

    Statement createStatement() throws SQLException;
}
