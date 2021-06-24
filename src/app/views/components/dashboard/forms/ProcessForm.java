package app.views.components.dashboard.forms;

import app.views.components.factory.LabelFactory;
import java.awt.*;
import javax.swing.*;

public class ProcessForm extends RegistrationForm {

    private final JPanel fieldsContainer;

    public ProcessForm(JFrame frame, boolean isModal) {
        super(frame, isModal, "Nuevo proceso");
        this.fieldsContainer = new JPanel();
        this.build();
        this.initComponents();
        this.pack();
    }

    public void initComponents() {
        this.fieldsContainer.setLayout(new GridLayout(4, 3));
        this.fieldsContainer.add(LabelFactory.option("Bro"));
        this.fieldsContainer.add(LabelFactory.option("Bro"));
        this.fieldsContainer.add(LabelFactory.option("Bro"));
        this.fieldsContainer.add(LabelFactory.option("Bro"));

        this.addToForm(fieldsContainer, BorderLayout.CENTER);
    }
}
