package app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteBook {

    private String name;
    private final List<ProceedingsMetadata> proceedingsMetadataList = new ArrayList<>();

    public void addProceedingsMetadata(
        String name,
        LocalDate creationDate,
        LocalDate incorporationDate,
        int docOrder,
        int pagesAmount,
        int initPage,
        int lastPage,
        String fileType,
        double size,
        String origin,
        String observations
    ) {
        this.proceedingsMetadataList.add(
                new ProceedingsMetadata(
                    name,
                    creationDate,
                    incorporationDate,
                    docOrder,
                    pagesAmount,
                    initPage,
                    lastPage,
                    fileType,
                    size,
                    origin,
                    observations
                )
            );
    }
}
