package com.svar_proekt.weldproject.repositories;

import com.svar_proekt.weldproject.model.ProductionObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionObjectRepository extends JpaRepository<ProductionObject,Integer> {
}
