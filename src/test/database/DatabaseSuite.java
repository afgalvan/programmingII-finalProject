package test.database;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ UserRepositoryTest.class, ConnectionTest.class })
public class DatabaseSuite {}
