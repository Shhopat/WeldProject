package com.svar_proekt.weldproject.repositories;

import com.svar_proekt.weldproject.model.Joint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JointRepository extends JpaRepository<Joint, Integer> {
}
