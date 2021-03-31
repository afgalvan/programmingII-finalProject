package app.controllers.document.types;

public class HabeasCorpusDocType extends DocType {

    public HabeasCorpusDocType() {
        this.getTypes().add("Solicitud hábeas corpus");
        this.getTypes().add("Acta de reparto");
        this.getTypes().add("Auto que decreta inspección");
        this.getTypes().add("Comunicación de hábeas corpus");
        this.getTypes().add("Entrevista");
        this.getTypes().add("Fallo de habeas corpus");
        this.getTypes().add("Escrito de Impugnación");
        this.getTypes().add("Auto que admite impugnación");
        this.getTypes().add("Providencia que resuelve impugnación");
        this.getTypes().add("Auto que ordena devolución del expediente");
        this.getTypes()
            .add("Auto de obedézcase y cúmplase o estese a lo resuelto");
        this.getTypes().add("Notificación");
    }
}
