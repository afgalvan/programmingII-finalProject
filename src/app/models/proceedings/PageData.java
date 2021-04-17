package app.models.proceedings;

import app.models.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ValueObject
public class PageData {

    private int pagesAmount;
    private int initPage;
    private int lastPage;
}
