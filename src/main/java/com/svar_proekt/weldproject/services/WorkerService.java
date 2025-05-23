package com.svar_proekt.weldproject.services;

import com.svar_proekt.weldproject.repositories.WorkerRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {
    public final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }
}
