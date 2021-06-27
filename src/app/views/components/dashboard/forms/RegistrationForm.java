package app.views.components.dashboard.forms;

import app.views.ColorPalette;
import app.views.components.atomic.RectangleButton;
import app.views.components.dashboard.TopBar;
import app.views.components.factory.ButtonFactory;
import app.views.components.factory.LabelFactory;
import java.awt.*;
import javax.swing.*;
import lombok.Getter;
import lombok.Setter;
import lombok.val;

@Getter
@Setter
public class RegistrationForm extends JDialog {

    private final TopBar topBar;
    private final JLabel titleLabel;
    private final RectangleButton cancelButton;
    private final RectangleButton submitButton;
    private final JPanel formContainer;

    public RegistrationForm(JFrame frame, boolean isModal, String titleLabel) {
        super(frame, "Registrar " + titleLabel, isModal);
        this.topBar = new TopBar(false);
        this.titleLabel = LabelFactory.createLabel(titleLabel, ColorPalette.BLUE);
        this.cancelButton = ButtonFactory.createMainButton("Cancelar");
        this.submitButton = ButtonFactory.createMainButton("Aceptar");
        this.formContainer = new JPanel();
    }

    @Override
    public void pack() {
        super.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    protected void build() {
        this.setBackground(ColorPalette.PINK);
        this.setLayout(new BorderLayout());
        this.initBaseFormContainer();
        this.add(topBar, BorderLayout.PAGE_START);
        this.add(formContainer, BorderLayout.CENTER);
    }

    private void initBaseFormContainer() {
        val titleContainer = new JPanel();
        titleContainer.setBackground(this.getBackground());
        titleContainer.add(titleLabel);

        val buttonsDimensions = new Dimension(120, 50);
        this.cancelButton.setPreferredSize(buttonsDimensions);
        this.submitButton.setPreferredSize(buttonsDimensions);

        val buttonsContainer = new JPanel();
        buttonsContainer.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        buttonsContainer.setBackground(this.getBackground());
        buttonsContainer.add(cancelButton);
        buttonsContainer.add(submitButton);

        this.formContainer.setBackground(this.getBackground());
        this.formContainer.setLayout(new BorderLayout());
        this.formContainer.add(titleContainer, BorderLayout.PAGE_START);
        this.formContainer.add(buttonsContainer, BorderLayout.PAGE_END);
    }

    public void addToForm(JComponent component, String layout) {
        this.formContainer.add(component, layout);
    }
}
