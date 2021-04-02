package test.database;

import app.database.ConnectionManager;
import lombok.SneakyThrows;
import org.junit.Test;

public class ConnectionTest {

    public ConnectionManager connectionManager = new ConnectionManager();

    @SneakyThrows
    @Test(expected = Test.None.class/* no exception expected */)
    public void databaseLinkTest() {
        connectionManager.open();
        connectionManager.close();
    }
}
