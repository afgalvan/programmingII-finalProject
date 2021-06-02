package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.main.MainTest;
import test.models.ModelSuite;
import test.controllers.ControllerSuite;
import test.services.ServiceSuite;
import test.repository.RepositorySuite;
import test.database.DatabaseSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
    {
        MainTest.class,
        ModelSuite.class,
        ControllerSuite.class,
        ServiceSuite.class,
        RepositorySuite.class,
        DatabaseSuite.class,
    }
)
public class TestSuite {}
