package app.main;

import app.controllers.LocationApi;
import app.models.document.types.HabeasCorpusDocType;
import app.models.document.types.PenalDocType;

public class Main {

    /**
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        PenalDocType penalDocType = new PenalDocType();
        HabeasCorpusDocType habeasCorpusDocType = new HabeasCorpusDocType();
        System.out.println(LocationApi.getCities("Antioquia"));
    }
}
