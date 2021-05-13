package app.services;

import app.models.Process;

public interface IProcessService extends Service<Long, Process> {
    ServiceResponse<Process> getProcessByJudged(String name);
    ServiceResponse<Process> getProcessByProsecutor(String name);
}
