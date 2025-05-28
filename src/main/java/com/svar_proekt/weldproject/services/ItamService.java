package com.svar_proekt.weldproject.services;

import com.svar_proekt.weldproject.client.ItamClient;
import com.svar_proekt.weldproject.model.Itam;
import com.svar_proekt.weldproject.model.ProductionObject;
import com.svar_proekt.weldproject.repositories.ItamRepository;
import com.svar_proekt.weldproject.util.ProductionObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ItamService {
    private static final Logger logger = LoggerFactory.getLogger(ItamService.class);
    public final ItamRepository itamRepository;
    private final ProductionObjectService productionObjectService;

    public ItamService(ItamRepository itamRepository, ProductionObjectService productionObjectService) {
        this.itamRepository = itamRepository;
        this.productionObjectService = productionObjectService;
    }

    @Transactional
    public void save(Itam itam) {
        System.out.println(itam.getProductionObject().getName());
        if (productionObjectService.existsByName(itam.getProductionObject().getName())) {
            itamRepository.save(itam);
        } else {
            throw new ProductionObjectNotFoundException("Production not found name: " + itam.getProductionObject().getName());
        }
    }

    public List<Itam> findAll(int objectId) {
        logger.info("ItamService method findAll");

        ProductionObject productionObject = productionObjectService.findById(objectId);
        return productionObject.getItamList();


    }
}
