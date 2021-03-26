package test.main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.models.EntityTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    MainTest.class,
    EntityTest.class,
})

public class SuiteTest {}
