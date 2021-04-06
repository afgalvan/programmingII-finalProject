package app.models.proceedings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageData {

    private int pagesAmount;
    private int initPage;
    private int lastPage;
}
