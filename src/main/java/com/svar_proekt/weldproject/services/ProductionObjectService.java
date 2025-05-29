package com.svar_proekt.weldproject.services;

import com.svar_proekt.weldproject.model.Admin;
import com.svar_proekt.weldproject.model.ProductionObject;
import com.svar_proekt.weldproject.repositories.ProductionObjectRepository;
import com.svar_proekt.weldproject.util.ProductionObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductionObjectService {
    private final ProductionObjectRepository productionObjectRepository;


    @Transactional
    public void save(ProductionObject productionObject, Admin admin) {
        admin.getObjectList().add(productionObject);//видишь тут я тоже вызываю list при этом он не иницилизирован
        productionObject.setAdmin(admin);
        productionObjectRepository.save(productionObject);
    }

    public ProductionObject findById(int id) {
        return productionObjectRepository.findById(id)
                .orElseThrow(() -> new ProductionObjectNotFoundException("production not found with id: " + id));
    }

    @Transactional
    public void update(ProductionObject productionObject, Admin admin) {
        productionObject.setAdmin(admin);
        productionObjectRepository.save(productionObject);

    }

    public boolean existsByName(String name) {
        return productionObjectRepository.existsByName(name);
    }

}
