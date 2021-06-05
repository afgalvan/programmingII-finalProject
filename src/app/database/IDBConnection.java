package app.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public interface IDBConnection extends DataConnection {
    PreparedStatement prepareStatement(String statement) throws SQLException;

    Statement createStatement() throws SQLException;
}
