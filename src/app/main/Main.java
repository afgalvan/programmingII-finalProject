package app.main;

import static java.awt.EventQueue.invokeLater;

import app.controllers.ProcessController;
import app.models.Process;
import app.models.metadata.*;
import app.models.metadata.parties.IdType;
import app.models.metadata.parties.NaturalPerson;
import app.models.metadata.parties.StateEntity;
import app.views.View;
import java.security.Security;

public class Main {

    /**
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        /*ProcessMetadata metadata = new ProcessMetadata(
            123456789L,
            new Location("Cesar", "Valledupar"),
            new JudicialOffice(
                "El despacho",
                123,
                new Location("Cesar", "Valledupar"),
                "Categoria"
            ),
            new Series("Series name", 123),
            new PhysicalInformation(true, 4)
        );
        Process process = new Process(metadata);
        process.addJudged(new NaturalPerson("Xavier", "War", 123, IdType.CC));
        process.addNoteBook("Bro");
        process.addProsecutor(new StateEntity("El gobierno del cesar"));
        System.out.println(ProcessController.getInstance().add(process));*/
        Security.setProperty("crypto.policy", "unlimited");
        invokeLater(View::new);
    }
}
