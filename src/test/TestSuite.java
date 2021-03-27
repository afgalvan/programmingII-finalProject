package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.controllers.ControllerSuite;
import test.main.MainTest;
import test.models.ModelSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ MainTest.class, ModelSuite.class, ControllerSuite.class })
public class TestSuite {}
