package test.services;

import app.models.Process;
import app.models.Response;
import app.models.metadata.ProcessMetadata;
import app.services.ProcessService;
import java.util.List;
import lombok.val;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import test.Order;
import test.OrderedRunner;

@RunWith(OrderedRunner.class)
public class ProcessServiceTest {

    private static ProcessService service;
    private static Process process;
    private final Long ID = 88888222222888L;

    @BeforeClass
    public static void setUp() {
        process = new Process();
        service = new ProcessService();
    }

    @Test
    @Order(1)
    public void insertInvalidProcess() {
        Assert.assertTrue(
            "The process shouldn't be saved, it has no metadata",
            service.insert(process).isError()
        );
        process.setMetadata(new ProcessMetadata());
        Assert.assertTrue(
            "The process shouldn't be saved, it has no id",
            service.insert(process).isError()
        );
    }

    @Test
    @Order(2)
    public void insertCorrectProcess() {
        process.getMetadata().setId(ID);
        Assert.assertFalse(service.insert(process).isError());
    }

    @Test
    @Order(3)
    public void insertRepeatedProcess() {
        Assert.assertTrue(
            "The process was already saved and shouldn't save repeated id",
            service.insert(process).isError()
        );
    }

    @Test
    @Order(4)
    public void getAll() {
        Response<List<Process>> response = service.getAll();
        Assert.assertFalse(response.isError());
    }

    @Test
    @Order(5)
    public void getById() {
        Assert.assertNotNull(service.getById(ID));
    }

    @Test
    public void updateById() {}

    @Test
    @Order(8)
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
