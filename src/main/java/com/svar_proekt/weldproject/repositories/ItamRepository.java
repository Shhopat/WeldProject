package com.svar_proekt.weldproject.repositories;

import com.svar_proekt.weldproject.model.Itam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItamRepository extends JpaRepository<Itam, Integer> {
}
