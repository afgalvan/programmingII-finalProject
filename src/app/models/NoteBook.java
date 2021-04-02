package app.models;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteBook {

    private String name;
    private final List<ProceedingsMetadata> proceedingsMetadataList = new ArrayList<>();

    public void addProceedingsMetadata(
        String name,
        int docOrder,
        Date dates,
        PageData pageData,
        ExtraData extraData
    ) {
        this.proceedingsMetadataList.add(
                new ProceedingsMetadata(name, docOrder, dates, pageData, extraData)
            );
    }
}
