package test.controllers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.controllers.api.JsonUtilsTest;
import test.controllers.api.LocationApiTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ LocationApiTest.class, JsonUtilsTest.class })
public class ControllerSuite {}
