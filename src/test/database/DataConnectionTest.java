package test.database;

import app.database.DBConnector;
import lombok.SneakyThrows;
import org.junit.Test;

public class DataConnectionTest {

    public DBConnector DBConnector = new DBConnector();

    @SneakyThrows
    @Test(expected = Test.None.class/* no exception expected */)
    public void databaseLinkTest() {
        DBConnector.open();
        DBConnector.close();
    }
}
