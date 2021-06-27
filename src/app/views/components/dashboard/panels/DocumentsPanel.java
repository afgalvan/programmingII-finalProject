package app.views.components.dashboard.panels;

import app.views.components.atomic.RectangleButton;
import app.views.components.dashboard.MainWindow;
import app.views.components.dashboard.forms.ProcessForm;
import app.views.components.factory.ButtonFactory;
import javax.swing.*;
import lombok.val;

public class DocumentsPanel extends CenterPanel {

    private RectangleButton addProcessButton;

    private static final DocumentsPanel instance = new DocumentsPanel();

    private DocumentsPanel() {
        this.initComponents();
    }

    public static DocumentsPanel getInstance() {
        return instance;
    }

    @Override
    public void initComponents() {
        renderContent(null);
    }

    private void renderContent(Process process) {
        this.removeAll();
        if (process == null) {
            renderVoidPane();
        }
    }

    private void renderVoidPane() {
        this.addProcessButton = ButtonFactory.createMainButton("Registrar proceso");
        this.addProcessButton.onClick(this::displayProcessForm);

        val buttonContainer = new JPanel();
        buttonContainer.setBackground(this.getBackground());
        buttonContainer.setBorder(BorderFactory.createEmptyBorder(90, 0, 0, 0));
        buttonContainer.add(addProcessButton);

        this.add(buttonContainer);
    }

    private void displayProcessForm() {
        new ProcessForm(MainWindow.state, true);
    }
}
