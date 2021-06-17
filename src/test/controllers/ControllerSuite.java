package test.controllers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.controllers.api.JsonUtilsTest;
import test.controllers.api.LocationsTest;
import test.controllers.security.PasswordHandlerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
    {
        LocationsTest.class,
        JsonUtilsTest.class,
        UserControllerTest.class,
        AuthControllerTest.class,
        PasswordHandlerTest.class,
    }
)
public class ControllerSuite {}
