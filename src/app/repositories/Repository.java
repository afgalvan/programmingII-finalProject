package app.repositories;

import app.exceptions.DataAccessException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @param <K> Data Key.
 * @param <T> Data Type.
 */
public interface Repository<K, T> {
    void insert(T data) throws DataAccessException, SQLException;

    List<T> getAll() throws DataAccessException, SQLException;

    T getById(K id) throws DataAccessException, SQLException;

    void updateById(K id, T newData) throws DataAccessException, SQLException;

    void deleteById(K id) throws DataAccessException, SQLException;
}
