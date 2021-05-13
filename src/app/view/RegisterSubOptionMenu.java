package app.view;

import app.models.metadata.DocumentType;
import app.models.metadata.JudicialOffice;
import app.models.metadata.Series;
import app.models.metadata.SubSeries;
import lombok.val;

import java.util.LinkedHashMap;

public class RegisterSubOptionMenu implements Menu {

    private MenuBuilder registerMenu;
    private final Displayable last;

    public RegisterSubOptionMenu(AdminMenu last) {
        this.last = last;
        initMenu();
    }

    @Override
    public void initMenu() {
        val subOptions = new LinkedHashMap<String, Runnable>();

        subOptions.put("Juzgado", this::addJudicialOffice);
        subOptions.put("Serie", this::addSeries);
        subOptions.put("Subserie", this::addSubSeries);
        subOptions.put("Tipos documentales", this::addDocumentType);
        subOptions.put("", View::pass);
        subOptions.put("Volver", last::display);

        registerMenu = new MenuBuilder("REGISTRO", subOptions);
    }

    @Override
    public void display() {
        View.clear();
        registerMenu.display();
    }

    public void addJudicialOffice() {
        JudicialOffice judicialOffice = new JudicialOffice();

        System.out.println("REGISTRO: JUZGADO");
        System.out.print("Nombre: ");
        judicialOffice.setName(View.scanner.nextLine());

        System.out.print("Codigo: ");
        judicialOffice.setCode(View.scanner.nextInt());

        System.out.print("Departamento: ");

        System.out.print("Ciudad: ");

        System.out.print("Categoria: ");
        judicialOffice.setCategory(View.scanner.nextLine());
    }

    public void addSeries() {
        Series series = new Series();

        System.out.println("REGISTRO: SERIE");
        System.out.print("Nombre: ");
        series.setName(View.scanner.nextLine());

        System.out.print("Codigo: ");
        series.setCode(View.scanner.nextInt());
    }

    public void addSubSeries() {
        SubSeries subSeries = new SubSeries();

        System.out.println("REGISTRO: SERIE");
        System.out.print("Nombre: ");
        System.out.print("Codigo: ");
        System.out.print("");
        System.out.print("");
    }

    public void addDocumentType() {
        DocumentType documentType = new DocumentType();

        System.out.println("REGISTRO: TIPO DE DOCUMENTO");
        System.out.print("Nombre: ");
        documentType.setName(View.scanner.nextLine());

        System.out.print("Codigo: ");
        documentType.setCode(View.scanner.nextInt());
    }
}
