package app.services;

import app.models.Process;
import app.models.Response;

import java.util.List;

public interface IProcessService extends Service<Long, Process> {
    boolean contains(Long id);

    Response<List<Process>> getProcessesByJudged(String name);

    Response<List<Process>> getProcessesByProsecutor(String name);
}
