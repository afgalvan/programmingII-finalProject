package app.views.components.dashboard.forms;

import app.views.components.factory.FieldFactory;
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
        this.fieldsContainer.setBackground(this.getBackground());
        this.fieldsContainer.setLayout(new GridLayout(4, 3, 10, 10));
        this.fieldsContainer.add(FieldFactory.createLabeledField("Bro", "Bro"));
        this.fieldsContainer.add(FieldFactory.createLabeledField("Bro", "Bro"));
        this.fieldsContainer.add(FieldFactory.createLabeledField("Bro", "Bro"));
        this.fieldsContainer.add(FieldFactory.createLabeledField("Bro", "Bro"));
        this.fieldsContainer.add(FieldFactory.createLabeledField("Bro", "Bro"));
        this.fieldsContainer.add(FieldFactory.createLabeledField("Bro", "Bro"));
        this.fieldsContainer.add(FieldFactory.createLabeledField("Bro", "Bro"));
        this.fieldsContainer.add(FieldFactory.createLabeledField("Bro", "Bro"));
        this.fieldsContainer.add(FieldFactory.createLabeledField("Bro", "Bro"));
        this.fieldsContainer.add(FieldFactory.createLabeledField("Bro", "Bro"));

        this.addToForm(fieldsContainer, BorderLayout.CENTER);
    }
}
