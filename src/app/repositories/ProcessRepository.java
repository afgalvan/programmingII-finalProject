package app.repositories;

import app.exceptions.DataAccessException;
import app.models.Process;
import java.sql.SQLException;
import java.util.List;

public interface ProcessRepository extends Repository<Process, Long> {
    boolean contains(Long id);

    List<Process> getProcessesByJudged(String name)
        throws SQLException, DataAccessException;

    List<Process> getProcessByProsecutor(String name)
        throws SQLException, DataAccessException;
}
