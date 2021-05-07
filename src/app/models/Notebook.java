package app.models;

import app.models.proceedings.ExtraData;
import app.models.proceedings.PageData;
import app.models.proceedings.ProceedingsDate;
import app.models.proceedings.ProceedingsMetadata;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representacion de los cuadernos que almacenan los
 * metadatos de las actuaciones.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notebook {

    private String name;
    private final List<ProceedingsMetadata> proceedingsMetadataList = new ArrayList<>();

    /**
     * Permite añadir un metadato del documento a una lista de metadatos
     * del documento.
     * @param name
     * @param docOrder
     * @param dates
     * @param pageData
     * @param extraData
     */
    public void addProceedingsMetadata(
        String name,
        int docOrder,
        ProceedingsDate dates,
        PageData pageData,
        ExtraData extraData
    ) {
        this.proceedingsMetadataList.add(
                new ProceedingsMetadata(name, docOrder, dates, pageData, extraData)
            );
    }
}
