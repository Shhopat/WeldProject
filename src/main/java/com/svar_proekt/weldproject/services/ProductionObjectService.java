package com.svar_proekt.weldproject.services;

import com.svar_proekt.weldproject.model.Admin;
import com.svar_proekt.weldproject.model.ProductionObject;
import com.svar_proekt.weldproject.repositories.ProductionObjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductionObjectService {
    private final ProductionObjectRepository productionObjectRepository;

    public ProductionObjectService(ProductionObjectRepository productionObjectRepository) {
        this.productionObjectRepository = productionObjectRepository;
    }

    @Transactional
    public void save(ProductionObject productionObject, Admin admin) {
        admin.getObjectList().add(productionObject);
        productionObject.setAdmin(admin);
        productionObjectRepository.save(productionObject);
    }
}
