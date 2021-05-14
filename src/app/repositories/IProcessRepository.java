package app.repositories;

import app.exceptions.DataAccessException;
import app.models.Process;
import java.sql.SQLException;
import java.util.List;

public interface IProcessRepository extends Repository<Long, Process> {
    boolean contains(Long id);

    List<Process> getProcessByJudged(String name)
        throws SQLException, DataAccessException;

    Process getProcessByProsecutor(String name) throws SQLException, DataAccessException;
}
