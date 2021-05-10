package app.repositories;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @param <K> Data Key.
 * @param <T> Data Type.
 */
public interface Repository<K, T> {
    void create(T data) throws Exception;

    List<T> readAll() throws Exception;

    T readById(K id) throws Exception;

    void updateById(K id, T newData) throws Exception;

    void deleteById(K id) throws Exception;
}
