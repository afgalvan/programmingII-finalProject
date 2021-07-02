package app.repositories;

import app.database.FileManagement;
import app.database.FileManager;
import app.exceptions.DataAccessException;
import app.models.metadata.Series;
import app.models.records.SeriesRecord;
import java.util.List;

public class SerializationSeriesRepository implements SeriesRepository {

    private final FileManagement fileManagement;

    public SerializationSeriesRepository(FileManagement fileManagement) {
        this.fileManagement = fileManagement;
    }

    public SerializationSeriesRepository() {
        this.fileManagement = new FileManager("Series.obj");
    }

    private SeriesRecord defaultReadRecord() {
        SeriesRecord record = (SeriesRecord) fileManagement.read();
        return record == null ? new SeriesRecord() : record;
    }

    private SeriesRecord safeReadRecords() throws DataAccessException {
        SeriesRecord record = (SeriesRecord) fileManagement.read();
        if (record == null || record.isEmpty()) {
            throw new DataAccessException("No existen series registradas");
        }
        return record;
    }

    @Override
    public void insert(Series data) throws DataAccessException {}

    @Override
    public List<Series> getAll() throws DataAccessException {
        return null;
    }

    @Override
    public Series getById(Integer id) throws DataAccessException {
        return null;
    }

    @Override
    public boolean updateById(Integer id, Series newData) throws DataAccessException {
        return false;
    }

    @Override
    public boolean deleteById(Integer id) throws DataAccessException {
        return false;
    }
}
