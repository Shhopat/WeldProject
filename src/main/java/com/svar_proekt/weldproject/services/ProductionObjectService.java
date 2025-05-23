package com.svar_proekt.weldproject.services;

import com.svar_proekt.weldproject.repositories.ProductionObjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductionObjectService {
    private final ProductionObjectRepository productionObjectRepository;

    public ProductionObjectService(ProductionObjectRepository productionObjectRepository) {
        this.productionObjectRepository = productionObjectRepository;
    }
}
