package app.services;

import app.models.proceedings.ProceedingsMetadata;
import java.util.List;

public class MetadataService implements Service<ProceedingsMetadata, Integer> {

    @Override
    public ServiceResponse<ProceedingsMetadata> create(ProceedingsMetadata data) {
        return null;
    }

    @Override
    public ServiceResponse<List<ProceedingsMetadata>> readAll() {
        return null;
    }

    @Override
    public ServiceResponse<ProceedingsMetadata> read(Integer id) {
        return null;
    }

    @Override
    public ServiceResponse<ProceedingsMetadata> update(
        Integer id,
        ProceedingsMetadata newData
    ) {
        return null;
    }

    @Override
    public ServiceResponse<ProceedingsMetadata> delete(Integer id) {
        return null;
    }
}
