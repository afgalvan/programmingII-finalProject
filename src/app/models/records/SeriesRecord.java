package app.models.records;

import app.models.metadata.Series;
import java.util.List;

public class SeriesRecord implements Record<Series, Integer> {

    @Override
    public Record<Series, Integer> add(Series data) {
        return null;
    }

    @Override
    public boolean update(Integer id, Series data) {
        return false;
    }

    @Override
    public Series getById(Integer id) {
        return null;
    }

    @Override
    public List<Series> asList() {
        return null;
    }

    @Override
    public boolean remove(Integer id) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
