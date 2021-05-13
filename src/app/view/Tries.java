package app.view;

import app.exceptions.DataAccessException;
import app.models.Process;
import app.models.metadata.ProcessMetadata;
import app.services.ProcessService;
import lombok.val;

public class Tries {

    public static void main(String[] args) throws DataAccessException {
        val process = new Process();
        val metadata = new ProcessMetadata();
        metadata.setId(123L);
        process.setMetadata(metadata);
        System.out.println(new ProcessService().getById(123L));
    }
}
