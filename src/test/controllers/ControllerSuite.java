package test.controllers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.controllers.api.JsonTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ LocationTest.class, JsonTest.class })
public class ControllerSuite {
}
