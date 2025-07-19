package com.svar_proekt.weldproject.services;

import com.svar_proekt.weldproject.client.ItamClient;
import com.svar_proekt.weldproject.model.Itam;
import com.svar_proekt.weldproject.model.ProductionObject;
import com.svar_proekt.weldproject.repositories.ItamRepository;
import com.svar_proekt.weldproject.util.ProductionObjectNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@Slf4j
public class ItamService {
    public final ItamRepository itamRepository;
    private final ProductionObjectService productionObjectService;

    @Autowired
    public ItamService(ItamRepository itamRepository, ProductionObjectService productionObjectService) {
        this.itamRepository = itamRepository;
        this.productionObjectService = productionObjectService;
    }

    @Transactional
    public void save(Itam itam) {
        if (productionObjectService.existsByName(itam.getProductionObject().getName())) {
            itamRepository.save(itam);
        } else {
            throw new ProductionObjectNotFoundException("Production not found name: " + itam.getProductionObject().getName());
        }
    }

    public List<Itam> findAll(int objectId) {
        log.info("ItamService method findAll");

        ProductionObject productionObject = productionObjectService.findById(objectId);
        return productionObject.getItamList();


    }
}
