package test.controllers.security;

import app.controllers.security.PasswordHandler;
import org.junit.Assert;
import org.junit.Test;

public class PasswordHandlerTest {

    @Test
    public void encrypt() {
        Assert.assertNotEquals(
            PasswordHandler.encrypt("J stands for retard"),
            "J stands for retard"
        );
    }
}