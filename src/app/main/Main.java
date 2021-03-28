package app.main;

import app.models.SubSeries;
import app.models.document.types.HabeasCorpusDocType;
import app.models.document.types.TutelageDocType;

public class Main {

    /**
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        subSeriesTest();
    }

    public static void subSeriesTest() {
        SubSeries habeasCorpus = new SubSeries("Acciones Hábeas Corpus", 15, new HabeasCorpusDocType());
        habeasCorpus.getDocType().getTypes().forEach(System.out::println);

        System.out.println("\n==========================================");
        SubSeries tutelage = new SubSeries("Acciones de Tutela", 25, new TutelageDocType());
        tutelage.getDocType().getTypes().forEach(System.out::println);
    }
}
