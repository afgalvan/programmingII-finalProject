package app.view;

import app.controllers.LocationController;
import app.controllers.ProcessController;
import app.models.Process;
import app.models.metadata.JudicialOffice;
import app.models.metadata.Location;
import app.models.metadata.PhysicalInformation;
import app.models.metadata.Series;
import app.models.metadata.parts.*;
import lombok.val;

public class ProcessMetadataRegister {

    private final Process process;
    private final ProcessController controller;

    public ProcessMetadataRegister(Process process) {
        this.controller = new ProcessController();
        this.process = process;
    }

    public void register() {
        View.clear();
        fillMetadata();
        controller.add(process);
    }

    public void fillMetadata() {
        System.out.println("METADATOS DEL PROCESO.\n");
        process.setMetadata(
            fillId(),
            fillLocation(),
            fillJudicialOffice(),
            fillSeries(),
            fillPhysicalInfo()
        );
        fillNotebooks(process);
        fillParties(process);
    }

    public Long fillId() {
        View.printLine(25);

        Long id;
        boolean repeated;
        do {
            id = View.input("Numero de radicación: ", View.scanner::nextLong);
            repeated = controller.contains(id);
            if (repeated) {
                System.out.println(
                    Color.RED + id.toString() + " ya ha sido registrado." + Color.NORMAL
                );
            }
        } while (repeated);
        return id;
    }

    public Location fillLocation() {
        LocationController locationController = new LocationController();

        String department = View.input(
            "Departamento: ",
            () -> locationController.throwForDepartment(View.scanner.nextLine()),
            "Departamento inválido",
            false
        );

        String city = View.input(
            "Ciudad: ",
            () -> locationController.throwForCity(department, View.scanner.nextLine()),
            "Ciudad incorrecta",
            false
        );

        return new Location(department, city);
    }

    public JudicialOffice fillJudicialOffice() {
        val judicialOffice = new JudicialOffice();

        View.printLine(25);
        System.out.println("DESPACHO JUDICIAL\n");
        System.out.print("Nombre: ");
        judicialOffice.setName(View.scanner.nextLine());
        judicialOffice.setCode(View.input("Código: ", View.scanner::nextInt));
        judicialOffice.setLocation(fillLocation());
        System.out.print("Categoria (Distrital o Circuito): ");
        judicialOffice.setCategory(View.scanner.nextLine());

        return judicialOffice;
    }

    public Series fillSeries() {
        View.printLine(25);
        Series series = new Series();

        System.out.println("SERIE\n");
        System.out.print("Nombre: ");
        series.setName(View.scanner.nextLine());
        series.setCode(View.input("Código: ", View.scanner::nextInt));

        return series;
    }

    public PhysicalInformation fillPhysicalInfo() {
        boolean hasPhysical = false;
        int foldersAmount = 0;

        View.printLine(25);
        System.out.println("\nTiene expediente fisico");
        System.out.println("1. Si   2. No");
        int answer = View.input("Escoja una opcion: ", View.scanner::nextInt);
        if (answer == 1) {
            hasPhysical = true;
            foldersAmount = View.input("Cantidad de carpetas: ", View.scanner::nextInt);
        }

        return new PhysicalInformation(hasPhysical, foldersAmount);
    }

    public int askNotebookAmount() {
        return View.input("Cantidad de cuadernos: ", View.scanner::nextInt);
    }

    public String askNotebook() {
        System.out.print("Ingrese la descripción: ");
        return View.scanner.nextLine();
    }

    public void fillNotebooks(Process process) {
        View.printLine(25);
        System.out.println("CUADERNOS\n");
        process.setNoteBooksLen(askNotebookAmount());
        for (int i = 1; i <= process.getNoteBooksLen(); i++) {
            System.out.printf("\nCuaderno %d.\n", i);
            process.addNoteBook(askNotebook());
        }
    }

    public void fillParties(Process process) {
        View.printLine(25);
        System.out.println("PARTES PROCESALES");
        System.out.println("Demandados: ");
        process.getMetadata().addJudged(getNewParty());
        System.out.println("\nDemantes: ");
        process.getMetadata().addProsecutor(getNewParty());
    }

    public Person getNewParty() {
        System.out.println("  1. Natural.");
        System.out.println("  2. Jurídica.");
        System.out.println("  3. Entidad del estado.");

        int choice;
        while (true) {
            choice = View.input("Tipo de persona: ", View.scanner::nextInt);
            switch (choice) {
                case 1:
                    return askNaturalPerson();
                case 2:
                    return askJuridicPerson();
                case 3:
                    return askStateEntity();
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    public NaturalPerson askNaturalPerson() {
        System.out.print("Nombre: ");
        String name = View.scanner.nextLine();
        System.out.print("Apellido: ");
        String lastName = View.scanner.nextLine();
        int id = View.input("Id: ", View.scanner::nextInt);
        System.out.print("Tipo de documento: ");
        IdType idType = selectIdType();

        return new NaturalPerson(name, lastName, id, idType);
    }

    public JuridicPerson askJuridicPerson() {
        System.out.print("Nombre: ");
        String name = View.scanner.nextLine();
        int id = View.input("Id: ", View.scanner::nextInt);

        return new JuridicPerson(name, id, IdType.NIT);
    }

    public StateEntity askStateEntity() {
        System.out.print("Nombre: ");
        String name = View.scanner.nextLine();

        return new StateEntity(name);
    }

    public IdType selectIdType() {
        System.out.println("\nTIPOS DE DOCUMENTOS");
        IdType.getAll().forEach(System.out::println);
        return IdType.CC;
    }
}
