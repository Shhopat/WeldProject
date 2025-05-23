package com.svar_proekt.weldproject.repositories;

import com.svar_proekt.weldproject.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {
}
