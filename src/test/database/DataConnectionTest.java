package test.database;

import app.database.SQLiteConnection;
import lombok.SneakyThrows;
import org.junit.Test;

public class DataConnectionTest {

    public SQLiteConnection SQLiteConnection = new SQLiteConnection();

    @SneakyThrows
    @Test(expected = Test.None.class/* no exception expected */)
    public void databaseLinkTest() {
        SQLiteConnection.open();
        SQLiteConnection.close();
    }
}
