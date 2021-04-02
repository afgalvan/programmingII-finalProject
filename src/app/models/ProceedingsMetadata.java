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
    private int docOrder;
    private Date dates;
    private PageData pageData;
    private ExtraData extraData;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Date {

    private LocalDate creationDate;
    private LocalDate incorporationDate;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class PageData {

    private int pagesAmount;
    private int initPage;
    private int lastPage;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class ExtraData {

    private String fileType;
    private double size;
    private String origin;
    private String observations;
}
