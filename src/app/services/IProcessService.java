package app.services;

import app.models.Process;
import app.models.Response;
import java.util.List;

public interface IProcessService extends Service<Process, Long> {
    boolean contains(Long id);

    Response<List<Process>> getProcessesByJudged(String name);

    Response<List<Process>> getProcessesByProsecutor(String name);

    Response<List<Process>> filterProcessByAnyMatch(String name);
}
