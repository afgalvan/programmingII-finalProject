package app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    private double size;
    private String origin;
    private String observations;
}
