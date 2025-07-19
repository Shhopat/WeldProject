package com.svar_proekt.weldproject.services;

import com.svar_proekt.weldproject.model.Admin;
import com.svar_proekt.weldproject.model.Itam;
import com.svar_proekt.weldproject.model.ProductionObject;
import com.svar_proekt.weldproject.repositories.ItamRepository;
import com.svar_proekt.weldproject.repositories.ProductionObjectRepository;
import com.svar_proekt.weldproject.util.ProductionObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional(readOnly = true)
@Slf4j
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

    @Transactional
    public void addItam(int idObject, Itam itam) {
        itam.setId(0);
        ProductionObject productionObject = productionObjectRepository.findById(idObject).orElseThrow(ProductionObjectNotFoundException::new);
        itam.setProductionObject(productionObject);
        productionObject.getItamList().add(itam);
        productionObjectRepository.save(productionObject);



    }

    public boolean existsByName(String name) {
        return productionObjectRepository.existsByName(name);
    }

}
