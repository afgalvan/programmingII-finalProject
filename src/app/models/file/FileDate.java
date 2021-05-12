package app.models.file;

import app.models.annotations.ValueObject;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Describe the creation and incorporation date of a file.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ValueObject
public class FileDate implements Serializable {

    private LocalDate creationDate;
    private LocalDate incorporationDate;
}
