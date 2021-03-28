package app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Process {

    private RecordMetadata recordMetadata;
    private ProceedingsMetadata proceedingsMetadata;
}
