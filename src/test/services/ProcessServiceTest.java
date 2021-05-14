package test.services;

import app.models.Process;
import app.models.metadata.ProcessMetadata;
import app.services.ProcessService;
import app.services.ServiceResponse;
import java.util.List;
import lombok.val;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import test.Order;
import test.OrderedRunner;

@RunWith(OrderedRunner.class)
public class ProcessServiceTest {

    private ProcessService service;
    private Process process;
    private final Long ID = 88888222222888L;

    @Before
    public void setUp() {
        this.process = new Process();
        this.service = new ProcessService();
    }

    @Test
    @Order(order = 1)
    public void insertInvalidProcess() {
        val otherProcess = new Process();
        Assert.assertTrue(service.insert(otherProcess).isError());
        otherProcess.setMetadata(new ProcessMetadata());
        Assert.assertTrue(service.insert(otherProcess).isError());
    }

    @Test
    @Order(order = 2)
    public void insertCorrectProcess() {
        process.setMetadata(new ProcessMetadata());
        process.getMetadata().setId(ID);
        Assert.assertFalse(service.insert(process).isError());
    }

    @Test
    @Order(order = 3)
    public void insertRepeatedProcess() {
        process.setMetadata(new ProcessMetadata());
        process.getMetadata().setId(ID);
        Assert.assertTrue(service.insert(process).isError());
    }

    @Test
    @Order(order = 4)
    public void getAll() {
        ServiceResponse<List<Process>> response = service.getAll();
        Assert.assertFalse(response.isError());
    }

    @Test
    public void getById() {}

    @Test
    public void updateById() {}

    @Test
    @Order(order = 8)
    public void deleteById() {
        if (service.contains(ID)) {
            Assert.assertFalse(service.deleteById(ID).isError());
        }
        Assert.assertFalse(service.contains(ID));
    }

    @Test
    public void getProcessByJudged() {}

    @Test
    public void getProcessByProsecutor() {}
}
