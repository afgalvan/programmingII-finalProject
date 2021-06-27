package test.controllers;

import app.controllers.ProcessController;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import test.Order;
import test.OrderedRunner;

@RunWith(OrderedRunner.class)
public class ProcessControllerTest {

    static ProcessController controller;

    @BeforeClass
    public static void setUp() {
        controller = ProcessController.getInstance();
    }

    @Order(1)
    @Test
    public void shouldReturnTheListOfProcessesThatMatches() {}
}
