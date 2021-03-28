package app.views;

import app.controllers.LocationApi;
import app.models.*;
import app.models.document.types.HabeasCorpusDocType;
import app.models.document.types.PenalDocType;
import app.models.document.types.TutelageDocType;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class ProcessView {

    public void view() {
        Series constitutionalActions = new Series("Acciones constitucionales", 5);
        constitutionalActions.addSubSeries("Acciones Hábeas Corpus", 15, new HabeasCorpusDocType());
        constitutionalActions.addSubSeries("Acciones de Tutela", 25, new TutelageDocType());

        Series judicialProcess = new Series("Expedientes de procesos judiciales", 270);
        judicialProcess.addSubSeries("Acciones penales", 245, new PenalDocType());

        JudicialOffice judicialOffice = new JudicialOffice(
            "juzgado 45",
            2342,
            "Cesar",
            LocationApi.getCities("Cesar").get(0),
            "Municipal"
        );

        NaturalPerson prosecutor = new NaturalPerson("Juan", "Piña", "Pacheco", "Pacheco", "21424234", IdTypes.CC);
        NaturalPerson judgeParty = new NaturalPerson(
            "Cristiano",
            "Javier",
            "Ronaldo",
            "Messi",
            "213233532",
            IdTypes.CC
        );

        RecordMetadata recordMetadata = new RecordMetadata(
            judicialOffice.getDepartment(),
            judicialOffice.getCity(),
            237485968574853529L,
            3,
            true,
            judicialOffice,
            constitutionalActions
        );
        recordMetadata.addProsecutor(prosecutor);
        recordMetadata.addJudgeParty(judgeParty);

        ProceedingsMetadata proceedingsMetadata = new ProceedingsMetadata(
            constitutionalActions.getSubSeriesList().get(0).getDocType().getTypes().get(4),
            LocalDate.now(),
            LocalDate.now(),
            1,
            286,
            1,
            285,
            "PDF",
            5.8,
            "Electrónico",
            ""
        );

        showRecordMetadata(recordMetadata);
        showProceedingsMetadata(proceedingsMetadata);
    }

    /**
     * Muestra la informacion del metadato del expediente con el formato requerido.
     * @param recordMetadata
     */
    public void showRecordMetadata(RecordMetadata recordMetadata) {
        System.out.println("\n\tÍndice del expediente judicial electrónico");
        System.out.printf("Ciudad: %s\n", recordMetadata.getCity());
        System.out.printf(
            "Despacho judicial: %s %s\n",
            recordMetadata.getJudicialOffice().getName(),
            recordMetadata.getJudicialOffice().getCategory()
        );
        System.out.printf("Serie o Subserie documental: %s\n", recordMetadata.getSerie().getName());
        System.out.printf("No. radicación del proceso: %d\n", recordMetadata.getProcessFilingNumber());
        System.out.printf(
            "Demandado (Parte A): %s\n",
            recordMetadata.getJudgePartyList().stream().map(Person::getFullName).collect(Collectors.toList())
        );
        System.out.printf(
            "Demandante (Parte B): %s\n",
            recordMetadata.getProsecutorList().stream().map(Person::getFullName).collect(Collectors.toList())
        );
        System.out.printf("\n\t\t\tEXPEDIENTE FÍSICO\n");
        showPhysicalFile(recordMetadata);
    }

    public void showProceedingsMetadata(ProceedingsMetadata proceedingsMetadata) {
        System.out.println("\n\t\tMETADATOS DEL DOCUMENTO");
        System.out.printf("Nombre del documento: %s\n", proceedingsMetadata.getName());
        System.out.printf("Fecha de creacion: %s\n", proceedingsMetadata.getCreationDate());
        System.out.printf("Fecha de incorporacion: %s\n", proceedingsMetadata.getIncorporationDate());
        System.out.printf("Orden del documento: %d\n", proceedingsMetadata.getDocOrder());
        System.out.printf("Numero de paginas: %d\n", proceedingsMetadata.getPagesAmount());
        System.out.printf(
            "Página inicio: %d       Página fin: %d\n",
            proceedingsMetadata.getInitPage(),
            proceedingsMetadata.getLastPage()
        );
        System.out.printf("Formato: %s\n", proceedingsMetadata.getFileType());
        System.out.printf("Tamaño del documento: %.2f KB\n", proceedingsMetadata.getSize());
        System.out.printf("Origen del documento: %s\n", proceedingsMetadata.getOrigin());
    }

    /**
     * Muestra la parte fisica del expediente, si existe muestra el numero de
     * cuadernos que tiene.
     * @param recordMetadata
     */
    public void showPhysicalFile(RecordMetadata recordMetadata) {
        System.out.print("El expediente judicial posee documentos físicos: ");
        if (recordMetadata.getHasPhysicalFile()) {
            System.out.println("Si X   No__");
        } else {
            System.out.println("Si__   No X");
        }

        System.out.printf("No. carpetas, legajos o tomos: %d\n", recordMetadata.getNotebookAmount());
    }

    /**
     * Muestra la tabla de retencion teniendo en cuenta el tipo de serie.
     * @param series
     */
    public void showRetentionTable(Series series) {
        System.out.print(series.getCode() + " ");
        System.out.println(series.getName());

        series.getSubSeriesList().forEach(this::showSubSeries);
    }

    /**
     * Muestra la subserie con sus tipos de documentos.
     * @param subSeries
     */
    public void showSubSeries(SubSeries subSeries) {
        System.out.print(subSeries.getCode() + " ");
        System.out.println(subSeries.getName());

        System.out.println("\t\tTipos de documentos");
        subSeries.getDocType().getTypes().forEach(System.out::println);
        System.out.println("---------------------------------------------------");
    }
}
