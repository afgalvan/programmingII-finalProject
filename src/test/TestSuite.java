package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.main.MainTest;
import test.models.EntityTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ MainTest.class, EntityTest.class })
public class TestSuite {}
