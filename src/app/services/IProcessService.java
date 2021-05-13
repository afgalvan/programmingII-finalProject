package app.services;

import app.models.Process;

import java.util.List;

public interface IProcessService extends Service<Long, Process> {
    ServiceResponse<List<Process>> getProcessByJudged(String name);
    ServiceResponse<Process> getProcessByProsecutor(String name);
}
