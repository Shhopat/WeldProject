package com.svar_proekt.weldproject.services;

import com.svar_proekt.weldproject.model.Admin;
import com.svar_proekt.weldproject.model.ProductionObject;
import com.svar_proekt.weldproject.repositories.ProductionObjectRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
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

    public ProductionObject findById(int id) {
        return productionObjectRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("admin not found with id: " + id));
    }

    @Transactional
    public void update(ProductionObject productionObject, Admin admin) {
        productionObject.setAdmin(admin);
        productionObjectRepository.save(productionObject);

    }

}
