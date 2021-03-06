package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.controllers.ControllerSuite;
import test.database.DatabaseSuite;
import test.models.ModelSuite;
import test.repositories.RepositorySuite;
import test.services.ServiceSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
    {
        ModelSuite.class,
        ControllerSuite.class,
        ServiceSuite.class,
        RepositorySuite.class,
        DatabaseSuite.class,
    }
)
public class TestSuite {}
