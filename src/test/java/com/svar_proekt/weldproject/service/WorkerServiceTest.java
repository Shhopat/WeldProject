package com.svar_proekt.weldproject.service;


import com.svar_proekt.weldproject.enums.Position;
import com.svar_proekt.weldproject.model.Foreman;
import com.svar_proekt.weldproject.model.Worker;
import com.svar_proekt.weldproject.repositories.WorkerRepository;
import com.svar_proekt.weldproject.services.ForemanService;
import com.svar_proekt.weldproject.services.WorkerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class WorkerServiceTest {

    @Mock
    private WorkerRepository workerRepository;
    @Mock
    private ForemanService foremanService;

    @InjectMocks
    private WorkerService workerService;

    private Worker worker;
    private Foreman foreman;

    @BeforeEach
    public void init() {
        foreman = new Foreman(1, "Вати");
        foreman.setWorkerList(new ArrayList<>());
        worker = new Worker(1, "Тати");
        worker.setPosition(Position.WELDER);
    }

    @Test
    public void shouldSave() {
        Mockito.when(foremanService.findById(foreman.getId())).thenReturn(foreman);
        workerService.save(worker, foreman.getId());
        Mockito.verify(workerRepository).save(worker);
    }

    @Test
    public void shouldUpdate() {
        Worker thatNewWorker = new Worker(1, "Ибрагим");
        thatNewWorker.setPosition(Position.FITTER);

        Mockito.when(workerRepository.findById(worker.getId())).thenReturn(Optional.of(worker));
        workerService.update(thatNewWorker);

        Assertions.assertEquals(thatNewWorker.getId(), worker.getId());
        Assertions.assertEquals(thatNewWorker.getName(), worker.getName());
        Assertions.assertEquals(thatNewWorker.getPosition(), worker.getPosition());

        Mockito.verify(workerRepository).save(worker);
        Mockito.verify(workerRepository).findById(worker.getId());


    }


}
