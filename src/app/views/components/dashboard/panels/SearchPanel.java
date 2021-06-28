package app.views.components.dashboard.panels;

import app.controllers.DialogResponse;
import app.controllers.ProcessController;
import app.models.Process;
import app.utils.ImageUtils;
import app.views.ColorPalette;
import app.views.components.atomic.Clickable;
import app.views.components.atomic.Dialog;
import app.views.components.atomic.RoundButtonIcon;
import app.views.components.atomic.Table;
import app.views.components.dashboard.MainWindow;
import app.views.components.factory.ButtonFactory;
import app.views.components.factory.FieldFactory;
import app.views.components.factory.LabelFactory;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import lombok.val;
import rojerusan.RSMetroTextPlaceHolder;

public class SearchPanel extends CenterPanel {

    private enum Criteria {
        FILTER,
        ID,
        PROSECUTOR,
        JUDGED,
    }

    private FilterProcesses filterProcesses;
    private JPanel criteriaPanel;
    private JPanel searchPanel;
    private RSMetroTextPlaceHolder searchField;
    private RoundButtonIcon searchButton;
    private Criteria criteria = Criteria.FILTER;
    private JLabel searchResult;
    private JLabel countResult;
    private Table resultsTable;
    private JScrollPane tableContainer;
    private DefaultTableModel tableModel;
    private final String[] tableTitle = {
        "Radicado",
        "Demandante",
        "Demandado",
        "Juzgado",
    };

    private static final SearchPanel instance = new SearchPanel();

    public static SearchPanel getInstance() {
        return instance;
    }

    private SearchPanel() {
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.criteriaPanel = new JPanel();
        this.searchPanel = new JPanel();
        this.searchField = FieldFactory.createDefaultField("Buscar...");
        this.searchButton =
            ButtonFactory.createRoundButtonOfImage(ImageUtils.getIcon24x24("search.png"));
        this.searchButton.setToolTipText("Buscar");
        this.searchResult =
            LabelFactory.createLabel(" ", ColorPalette.GRAY, Font.BOLD, 18);
        this.countResult =
            LabelFactory.createLabel(" ", ColorPalette.GRAY, Font.PLAIN, 12);
        this.resultsTable = new Table();
        this.tableContainer = new JScrollPane();
        this.tableModel = new DefaultTableModel(null, this.tableTitle);

        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(20, 60, 20, 60));
        this.initSearchPanel();
        this.initCriteriaPanel();
        this.add(criteriaPanel, BorderLayout.WEST);
        this.add(searchPanel, BorderLayout.CENTER);
        this.filterProcesses = new FilterProcesses();
        this.showAllProcesses();
        this.addInteraction();
    }

    public void initCriteriaPanel() {
        this.criteriaPanel.setBackground(this.getBackground());
        this.criteriaPanel.setLayout(
                new BoxLayout(this.criteriaPanel, BoxLayout.PAGE_AXIS)
            );
        this.criteriaPanel.setBorder(BorderFactory.createEmptyBorder(75, 0, 0, 0));
        this.criteriaPanel.setPreferredSize(new Dimension(300, 0));
        this.criteriaPanel.add(searchResult);
        this.criteriaPanel.add(countResult);

        addCriteriaPanelOption("Filtrar", Criteria.FILTER, Color.BLACK);
        addCriteriaPanelOption("No. de radicado", Criteria.ID);
        addCriteriaPanelOption("Demandante", Criteria.PROSECUTOR);
        addCriteriaPanelOption("Demandado", Criteria.JUDGED);
    }

    public void addCriteriaPanelOption(String text, Criteria searchBy) {
        addCriteriaPanelOption(text, searchBy, ColorPalette.GRAY);
    }

    public void addCriteriaPanelOption(String text, Criteria searchBy, Color color) {
        Clickable option = new Clickable(text);
        option.onClick(
            () -> {
                criteria = searchBy;
                toggleFilter();
                Arrays
                    .asList(this.criteriaPanel.getComponents())
                    .forEach(o -> o.setForeground(ColorPalette.GRAY));
                option.setForeground(Color.BLACK);
            }
        );
        option.setFont(new Font("Segeo UI", Font.BOLD, 18));
        option.setForeground(color);
        option.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        this.criteriaPanel.add(option);
    }

    public void initSearchPanel() {
        this.searchPanel.setBackground(this.getBackground());
        this.searchPanel.setLayout(new BorderLayout());

        this.resultsTable.setModel(tableModel);
        this.tableContainer.setViewportView(resultsTable);
        this.searchPanel.add(tableContainer, BorderLayout.CENTER);

        val searchingSide = new JPanel(new BorderLayout());
        searchingSide.setBackground(this.getBackground());
        searchingSide.add(searchButton, BorderLayout.EAST);
        searchingSide.add(searchField, BorderLayout.CENTER);
        searchingSide.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        this.searchPanel.add(searchingSide, BorderLayout.PAGE_START);
    }

    private void showAllProcesses() {
        this.showMatchesOnTable(ProcessController.getInstance().getAllProcesses());
    }

    private <T> T getInput(Function<String, T> parser) {
        String input = this.searchField.getText();
        updateResultLabel(input);

        T parsedInput;

        if (input == null || input.isEmpty()) {
            showError("Ingrese algo que buscar.");
            return null;
        }

        try {
            parsedInput = parser.apply(input);
        } catch (NumberFormatException error) {
            showError("No. de radicado ingresado inválido.");
            return null;
        }

        return parsedInput;
    }

    private <T, R> R searchByCriteria(
        Function<String, T> parser,
        Function<T, DialogResponse<R>> searchMethod
    ) {
        T parsedInput = getInput(parser);

        if (parsedInput == null) {
            return null;
        }

        DialogResponse<R> response = searchMethod.apply(parsedInput);
        if (response.isError()) {
            showError(response.getMessage());
            return null;
        }

        return response.getData();
    }

    public List<Process> finById() {
        ProcessController controller = ProcessController.getInstance();
        Process process = searchByCriteria(Long::parseLong, controller::getProcessById);
        return Collections.singletonList(process);
    }

    public List<Process> findByTrial(
        Function<String, DialogResponse<List<Process>>> trialSearch
    ) {
        return searchByCriteria(String::toString, trialSearch);
    }

    public void showMatchesOnTable(java.util.List<Process> processList) {
        this.tableModel.setRowCount(0);
        if (
            processList != null && !processList.contains(null) && !processList.isEmpty()
        ) {
            processList.forEach(
                process -> this.tableModel.addRow(process.getAsRow().toArray())
            );
        }
        updateCountLabel(this.tableModel.getRowCount());
    }

    private void cleanResults() {
        updateResultLabel(null);
        this.tableModel.setRowCount(0);
        updateCountLabel(0);
    }

    private void updateResultLabel(String text) {
        this.searchResult.setText((text == null || text.isEmpty()) ? " " : text);
    }

    private void updateCountLabel(int results) {
        char s = (results > 1 || results == 0) ? 's' : '\0';
        this.countResult.setText(results + " Resultado" + s);
    }

    private void searchProcess() {
        Map<Criteria, Supplier<List<Process>>> searchMap = new HashMap<>();
        ProcessController controller = ProcessController.getInstance();

        searchMap.put(Criteria.FILTER, ArrayList::new);
        searchMap.put(Criteria.ID, this::finById);
        searchMap.put(
            Criteria.PROSECUTOR,
            () -> findByTrial(controller::getProcessesByProsecutor)
        );
        searchMap.put(
            Criteria.JUDGED,
            () -> findByTrial(controller::getProcessesByJudged)
        );

        List<Process> processesFound = searchMap.get(criteria).get();
        showMatchesOnTable(processesFound);
    }

    public void showError(String message) {
        new Dialog(MainWindow.state, "Buscar proceso", message, Dialog.ERROR_MESSAGE);
    }

    public void addInteraction() {
        this.searchButton.onClick(this::searchProcess);
        this.searchField.addKeyListener(this.filterProcesses);
    }

    private void toggleFilter() {
        cleanResults();
        if (this.criteria != Criteria.FILTER) {
            this.searchField.removeKeyListener(this.filterProcesses);
        } else {
            this.showAllProcesses();
            if (this.searchField.getKeyListeners().length == 0) {
                this.searchField.addKeyListener(this.filterProcesses);
            }
        }
    }

    public void filterProcesses() {
        ProcessController controller = ProcessController.getInstance();
        String input = this.searchField.getText();
        updateResultLabel(input);

        List<Process> filteredList = controller.filterProcessByAnyMatch(input);
        showMatchesOnTable(filteredList);
    }

    private class FilterProcesses extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent keyEvent) {
            filterProcesses();
        }
    }
}
