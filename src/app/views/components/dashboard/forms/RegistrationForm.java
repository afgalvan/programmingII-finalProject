package app.views.components.dashboard.forms;

import app.views.ColorPalette;
import app.views.components.dashboard.TopBar;
import app.views.components.factory.LabelFactory;
import java.awt.*;
import javax.swing.*;
import lombok.Getter;
import lombok.Setter;

public class RegistrationForm extends JDialog {

    private final TopBar topBar;
    private final JLabel title;
    private JPanel titleContainer;

    @Getter
    @Setter
    private JPanel formContainer;

    public RegistrationForm(JFrame frame, boolean isModal, String title) {
        super(frame, isModal);
        this.topBar = new TopBar(false);
        this.title = LabelFactory.createLabel(title, ColorPalette.GRAY);
        this.build();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public void build() {
        this.setBackground(ColorPalette.PINK);
        this.setLayout(new BorderLayout());
        this.add(topBar, BorderLayout.PAGE_START);
        this.add(formContainer, BorderLayout.CENTER);
    }
}
