package com.svar_proekt.weldproject.services;

import com.svar_proekt.weldproject.model.Foreman;
import com.svar_proekt.weldproject.model.Worker;
import com.svar_proekt.weldproject.repositories.WorkerRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class WorkerService {
    public final WorkerRepository workerRepository;
    public final ForemanService foremanService;

    public WorkerService(WorkerRepository workerRepository, ForemanService foremanService) {
        this.workerRepository = workerRepository;
        this.foremanService = foremanService;
    }

    @Transactional
    public void save(Worker worker, int idForeman) {
        Foreman foreman = foremanService.findById(idForeman);
        foreman.getWorkerList().add(worker);
        worker.setForeman(foreman);
        workerRepository.save(worker);

    }

    public Worker findById(int id) {
        return workerRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("worker not found with id:" + id));
    }

    @Transactional
    public void update(Worker worker) {
        Worker worker1 = findById(worker.getId());
        worker1.setName(worker.getName());
        worker1.setPosition(worker.getPosition());
        workerRepository.save(worker1);
    }
}
