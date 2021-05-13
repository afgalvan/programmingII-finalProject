package app.repositories;

import app.exceptions.DataAccessException;
import app.models.Process;

public interface IProcessRepository extends Repository<Long, Process> {
    Process getProcessByJudged(String name) throws DataAccessException;
    Process getProcessByProsecutor(String name) throws DataAccessException;
}
