package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.controllers.ControllerSuite;
import test.database.DatabaseSuite;
import test.main.MainTest;
import test.models.ModelSuite;
import test.services.ServiceSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
    {
        MainTest.class,
        ModelSuite.class,
        ControllerSuite.class,
        DatabaseSuite.class,
        ServiceSuite.class,
    }
)
public class TestSuite {}
