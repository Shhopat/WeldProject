package com.svar_proekt.weldproject.repositories;

import com.svar_proekt.weldproject.model.Foreman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForemanRepository extends JpaRepository<Foreman,Integer> {
}
