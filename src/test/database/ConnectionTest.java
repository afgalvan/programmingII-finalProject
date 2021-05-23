package test.database;

import app.database.DBConnectionManager;
import lombok.SneakyThrows;
import org.junit.Test;

public class ConnectionTest {

    public DBConnectionManager DBConnectionManager = new DBConnectionManager();

    @SneakyThrows
    @Test(expected = Test.None.class/* no exception expected */)
    public void databaseLinkTest() {
        DBConnectionManager.open();
        DBConnectionManager.close();
    }
}
