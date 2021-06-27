package test.services;

import app.database.FileManagement;
import app.database.FileManager;
import app.models.Process;
import app.models.Response;
import app.models.metadata.ProcessMetadata;
import app.models.metadata.parties.IdType;
import app.models.metadata.parties.JuridicPerson;
import app.models.metadata.parties.NaturalPerson;
import app.models.metadata.parties.TrialParty;
import app.repositories.FunctionalMutator;
import app.repositories.ProcessRepository;
import app.repositories.SerializationProcessRepository;
import app.services.IProcessService;
import app.services.ProcessService;
import java.util.List;
import lombok.val;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import test.Order;
import test.OrderedRunner;

@RunWith(OrderedRunner.class)
public class ProcessServiceTest {

    private static IProcessService service;
    private static FileManagement fileManagement;
    private static Process process;
    private static final Long ID = 88888222222888L;

    @BeforeClass
    public static void setUp() {
        process = new Process();
        fileManagement = new FileManager("ProcessTest.obj");
        ProcessRepository repository = new SerializationProcessRepository(fileManagement);
        service = new ProcessService(repository);
    }

    @Test
    @Order(1)
    public void receiveAnError_when_tryingToGetAnyProcessFromEmptyFile() {
        Response<List<Process>> response = service.getAll();
        Assert.assertTrue(response.isError());
    }

    @Test
    @Order(2)
    public void receiveAnError_when_tryingToInsertInvalidProcess() {
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
    @Order(3)
    public void saveTheProcess_when_itHasAllNecessaryData() {
        process.setMetadata(new ProcessMetadata());
        process.setId(ID);
        Response<Process> response = service.insert(process);
        Assert.assertFalse("The process should be saved correctly", response.isError());
    }

    @Test
    @Order(4)
    public void receiveAnError_when_repeatedProcessIsTryingToBeSaved() {
        Assert.assertTrue(
            "The process was already saved and shouldn't save repeated id",
            service.insert(process).isError()
        );
    }

    @Test
    @Order(5)
    public void getAll() {
        Response<List<Process>> response = service.getAll();
        Assert.assertFalse(
            "Getting all process should not had error when has at least one saved",
            response.isError()
        );
    }

    @Test
    @Order(6)
    public void getById() {
        Assert.assertNotNull(
            "The process should be retrieved successfully",
            service.getById(ID).getData()
        );
    }

    @Test
    @Order(7)
    public void updateById() {
        process.addNoteBook("Cuaderno 1");
        service.updateById(process.getId(), process);

        Assert.assertFalse(
            "The process' notebooks should be updated correctly",
            service.getById(process.getId()).getData().getNotebooksList().isEmpty()
        );
    }

    public Process setUpdateTestWith(
        FunctionalMutator<Process, TrialParty> mutator,
        TrialParty trialParty
    ) {
        mutator.mutate(process, trialParty);
        service.updateById(process.getId(), process);

        val processWithoutJudged = new Process(new ProcessMetadata(123L));
        service.insert(processWithoutJudged);

        return processWithoutJudged;
    }

    @Test
    @Order(8)
    public void getProcessByJudged() {
        val judged = new JuridicPerson("Corp", 123, IdType.NIT);
        Process processWithoutJudged = setUpdateTestWith(Process::addJudged, judged);
        val response = service.getProcessesByJudged(judged.getName());
        Assert.assertTrue(response.getData().contains(process));
        Assert.assertFalse(response.getData().contains(processWithoutJudged));
    }

    @Test
    @Order(9)
    public void getProcessByProsecutor() {
        val prosecutor = new NaturalPerson("Javier", "War", 123, IdType.CC);
        Process processWithoutProsecutor = setUpdateTestWith(
            Process::addProsecutor,
            prosecutor
        );
        val response = service.getProcessesByProsecutor(prosecutor.getName());
        Assert.assertTrue(response.getData().contains(process));
        Assert.assertFalse(response.getData().contains(processWithoutProsecutor));
    }

    @Test
    @Order(10)
    public void deleteById() {
        val oldRecords = service.getAll().getData();
        int recordCount = 0;
        if (oldRecords != null) {
            recordCount = oldRecords.size();
        }

        if (service.contains(ID)) {
            Assert.assertFalse(service.deleteById(ID).isError());
        }

        Assert.assertFalse(service.contains(ID));
        val deletedRecords = service.getAll().getData();
        if (deletedRecords != null) {
            Assert.assertEquals(recordCount - 1, deletedRecords.size());
        }
    }

    @AfterClass
    public static void cleanUp() {
        fileManagement.deleteSelf();
    }
}
