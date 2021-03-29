package app.views;

import app.controllers.api.LocationApi;
import app.controllers.document.types.HabeasCorpusDocType;
import app.models.*;
import app.models.Process;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class ProcessView {

    public void view() {
        Process process = new Process();
        JudicialOffice judicialOffice = new JudicialOffice(
            "Juzgado Booker T",
            32132113,
            "Cesar",
            LocationApi.getCities("Cesar").get(LocationApi.citiesLen("Cesar") - 1),
            "Municipal"
        );

        Series series = new Series("Acciones Constitucionales", 5);
        series.addSubSeries("Acciones de Hábeas Corpus", 15, new HabeasCorpusDocType().getTypes());

        NaturalPerson naturalPerson = new NaturalPerson(
            "Cristiano",
            "Javier",
            "Ronaldo",
            "Messi",
            "111111112",
            IdTypes.CC
        );
        StateEntity stateEntity = new StateEntity("Gobernación del Cesar");

        process.addNoteBook("Cuaderno Principal");

        process
            .getNoteBooksList()
            .get(0)
            .addProceedingsMetadata(
                "Accion de tutela",
                LocalDate.now(),
                LocalDate.now(),
                1,
                5,
                1,
                5,
                "PDF",
                1000,
                "Digitalizado",
                ""
            );
        process
            .getNoteBooksList()
            .get(0)
            .addProceedingsMetadata(
                "Acta de reparto",
                LocalDate.now().minusDays(4),
                LocalDate.now().minusDays(2),
                2,
                1,
                6,
                6,
                "PDF",
                302,
                "Electrónico",
                ""
            );

        process.settleRecordMetadata(
            judicialOffice.getDepartment(),
            judicialOffice.getCity(),
            judicialOffice,
            series,
            15573732732327L,
            true,
            4
        );
        process.getRecordMetadata().addProsecutor(stateEntity);
        process.getRecordMetadata().addJudgeParty(naturalPerson);

        showProcess(process);
    }

    public void showProcess(Process process) {
        System.out.println("\tÍNDICE DEL EXPEDIENTE JUDICIAL ELECTRÓNICO.");
        showRecordMetadata(process.getRecordMetadata());
        System.out.println("\t");
        process
            .getNoteBooksList()
            .forEach(
                (
                    n -> {
                        n.getProceedingsMetadataList().forEach(this::showProceedingsMetadata);
                    }
                )
            );
    }

    /**
     * Muestra la informacion del metadato del expediente con el formato requerido.
     *
     * @param recordMetadata
     */
    public void showRecordMetadata(RecordMetadata recordMetadata) {
        System.out.printf("Ciudad: %s\n", recordMetadata.getCity());
        System.out.printf(
            "Despacho judicial: %s %s\n",
            recordMetadata.getJudicialOffice().getName(),
            recordMetadata.getJudicialOffice().getCategory()
        );
        System.out.printf("Serie o Subserie documental: %s\n", recordMetadata.getSeries().getName());
        System.out.printf("No. radicación del proceso: %d\n", recordMetadata.getProcessFilingNumber());
        System.out.printf(
            "Demandado (Parte A): %s\n",
            recordMetadata.getJudgePartyList().stream().map(Person::getFullName).collect(Collectors.toList())
        );
        System.out.printf(
            "Demandante (Parte B): %s\n",
            recordMetadata.getProsecutorList().stream().map(Person::getFullName).collect(Collectors.toList())
        );
        System.out.println("\n\t\t\tEXPEDIENTE FÍSICO");
        showPhysicalFile(recordMetadata);
    }

    public void showProceedingsMetadata(ProceedingsMetadata proceedingsMetadata) {
        System.out.println("\n===================================================================");
        System.out.println("\n\t\tMETADATOS DEL DOCUMENTO");
        System.out.printf("Nombre del documento  : %s\n", proceedingsMetadata.getName());
        System.out.printf("Fecha de creacion     : %s\n", proceedingsMetadata.getCreationDate());
        System.out.printf("Fecha de incorporacion: %s\n", proceedingsMetadata.getIncorporationDate());
        System.out.printf("Orden del documento   : %d\n", proceedingsMetadata.getDocOrder());
        System.out.printf("Numero de paginas     : %d\n", proceedingsMetadata.getPagesAmount());
        System.out.printf(
            "Página inicio: %d      Página fin: %d\n",
            proceedingsMetadata.getInitPage(),
            proceedingsMetadata.getLastPage()
        );
        System.out.printf("Formato               : %s\n", proceedingsMetadata.getFileType());
        System.out.printf("Tamaño del documento  : %.2f KB\n", proceedingsMetadata.getSize());
        System.out.printf("Origen del documento  : %s\n", proceedingsMetadata.getOrigin());
    }

    /**
     * Muestra la parte fisica del expediente, si existe muestra el numero de
     * cuadernos que tiene.
     *
     * @param recordMetadata
     */
    public void showPhysicalFile(RecordMetadata recordMetadata) {
        System.out.print("El expediente judicial posee documentos físicos: ");
        if (recordMetadata.getHasPhysicalFile()) {
            System.out.println("Si X   No__");
        } else {
            System.out.println("Si__   No X");
        }
        System.out.printf(
            "No. carpetas, legajos o tomos: %s\n",
            (recordMetadata.getHasPhysicalFile()) ? recordMetadata.getFoldersAmount() : ""
        );
    }

    /**
     * Muestra la tabla de retencion teniendo en cuenta el tipo de serie.
     *
     * @param series
     */
    public void showRetentionTable(Series series) {
        System.out.print(series.getCode() + " ");
        System.out.println(series.getName());

        series.getSubSeriesList().forEach(this::showSubSeries);
    }

    /**
     * Muestra la subserie con sus tipos de documentos.
     *
     * @param subSeries
     */
    public void showSubSeries(SubSeries subSeries) {
        System.out.print(subSeries.getCode() + " ");
        System.out.println(subSeries.getName());

        System.out.println("\t\tTipos de documentos");
        subSeries.getDocType().forEach(System.out::println);
        System.out.println("---------------------------------------------------");
    }
}
