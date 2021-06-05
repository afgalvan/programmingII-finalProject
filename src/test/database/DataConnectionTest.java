package test.database;

import app.database.DBConnection;
import lombok.SneakyThrows;
import org.junit.Test;

public class DataConnectionTest {

    public DBConnection DBConnection = new DBConnection();

    @SneakyThrows
    @Test(expected = Test.None.class/* no exception expected */)
    public void databaseLinkTest() {
        DBConnection.open();
        DBConnection.close();
    }
}
