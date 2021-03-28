package app.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Process {

    private RecordMetadata recordMetadata;
    private List<ProceedingsMetadata> proceedingsMetadataList;
}
