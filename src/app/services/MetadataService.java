package app.services;

import app.models.proceedings.ProceedingsMetadata;
import java.util.List;

public class MetadataService implements Service<Integer, ProceedingsMetadata> {

    @Override
    public ServiceResponse<ProceedingsMetadata> create(ProceedingsMetadata data) {
        return null;
    }

    @Override
    public ServiceResponse<List<ProceedingsMetadata>> readAll() {
        return null;
    }

    @Override
    public ServiceResponse<ProceedingsMetadata> readById(Integer id) {
        return null;
    }

    @Override
    public ServiceResponse<ProceedingsMetadata> updateById(
        Integer id,
        ProceedingsMetadata newData
    ) {
        return null;
    }

    @Override
    public ServiceResponse<ProceedingsMetadata> deleteById(Integer id) {
        return null;
    }
}
