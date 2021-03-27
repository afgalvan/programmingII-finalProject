package app.models.document.types;

public class HabeasCorpusDocType extends DocType {

    public HabeasCorpusDocType() {
        this.getDocTypes().add("Solicitud hábeas corpus");
        this.getDocTypes().add("Acta de reparto");
        this.getDocTypes().add("Auto que decreta inspección");
        this.getDocTypes().add("Comunicación de hábeas corpus");
        this.getDocTypes().add("Entrevista");
        this.getDocTypes().add("Fallo de habeas corpus");
        this.getDocTypes().add("Escrito de Impugnación");
        this.getDocTypes().add("Auto que admite impugnación");
        this.getDocTypes().add("Providencia que resuelve impugnación");
        this.getDocTypes().add("Auto que ordena devolución del expediente");
        this.getDocTypes().add("Auto de obedézcase y cúmplase o estese a lo resuelto");
        this.getDocTypes().add("Notificación");
    }
}
