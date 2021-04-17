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

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notebook {

    private String name;
    private final List<ProceedingsMetadata> proceedingsMetadataList = new ArrayList<>();

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
