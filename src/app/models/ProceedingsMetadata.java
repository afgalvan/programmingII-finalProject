package app.models;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProceedingsMetadata {

    private String name;
    private LocalDate creationDate;
    private LocalDate incorporationDate;
    private int docOrder;
    private int pagesAmount;
    private int initPage;
    private int lastPage;
    private String fileType;
    private int size;
    private String origin;
    private String observations;
}
