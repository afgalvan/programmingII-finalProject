package app.view;

import app.models.Notebook;
import app.models.Process;
import app.models.documents.DocumentDate;
import app.models.documents.DocumentExtraData;
import app.models.documents.DocumentPage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.val;

public class DocumentRegister {

    private final Process process;
    private final AddProcessMenu last;

    public DocumentRegister(AddProcessMenu last, Process process) {
        this.process = process;
        this.last = last;
    }

    public void registration() {
        View.clear();
        System.out.println("DATOS DEL DOCUMENTO\n");

        System.out.print("Nombre del cuaderno: ");
        String notebookName = View.scanner.nextLine();
        Notebook notebook = process.getNotebookByName(notebookName);
        if (notebook == null) {
            System.out.println(
                Color.RED + "\nNombre del cuaderno no encontrado." + Color.NORMAL
            );
            View.waitForEnter();
        } else {
            notebook.addDocument(
                askFileName(),
                notebook.getDocumentList().size() + 1,
                fillDates(),
                fillPageData(),
                fillExtraData()
            );
        }
        System.out.println(process.getNotebookByName(notebookName));
        View.waitForEnter();
        last.display();
    }

    public String askFileName() {
        View.printLine(25);
        System.out.print("Nombre del documento: ");
        return View.scanner.nextLine();
    }

    public DocumentExtraData fillExtraData() {
        val extraData = new DocumentExtraData();
        System.out.print("Formato: ");
        extraData.setFileType(View.scanner.nextLine());

        double weight = View.input("Peso: ", View.scanner::nextDouble);
        extraData.setSize(weight);

        System.out.print("Origen: ");
        extraData.setOrigin(View.scanner.nextLine());

        System.out.print("Observaciones: ");
        extraData.setObservations(View.scanner.nextLine());

        return extraData;
    }

    public DocumentDate fillDates() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        val dates = new DocumentDate();

        // prettier-ignore-start
        dates.setCreationDate(View.input(
            "Fecha de creación (día/mes/año): ",
            () -> LocalDate.parse(View.scanner.nextLine(), formatter),
            "Fecha inválida",
            false
            )
        );
        // prettier-ignore-end
        dates.setIncorporationDate(LocalDate.now());

        return dates;
    }

    public DocumentPage fillPageData() {
        val pages = new DocumentPage();

        int pageAmount = View.input("Numero de páginas: ", View.scanner::nextInt);
        pages.setPagesAmount(pageAmount);
        int initPage = View.input("Página inicio: ", View.scanner::nextInt);
        pages.setInitPage(initPage);
        pages.setLastPage(initPage + pageAmount);

        return pages;
    }
}
