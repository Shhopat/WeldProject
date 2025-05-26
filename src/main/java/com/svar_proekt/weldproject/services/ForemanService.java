package com.svar_proekt.weldproject.services;

import com.svar_proekt.weldproject.model.Foreman;
import com.svar_proekt.weldproject.model.ProductionObject;
import com.svar_proekt.weldproject.repositories.ForemanRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ForemanService {
    private final ForemanRepository foremanRepository;
    private final ProductionObjectService productionObjectService;

    public ForemanService(ForemanRepository foremanRepository, ProductionObjectService productionObjectService) {
        this.foremanRepository = foremanRepository;
        this.productionObjectService = productionObjectService;
    }

    @Transactional
    public void save(Foreman foreman, int idObject) {
        foreman.setProductionObject(productionObjectService.findById(idObject));
        foremanRepository.save(foreman);
    }

    public Foreman findById(int id) {
        return foremanRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("not found foreman with id: " + id));
    }

    @Transactional
    public void update(Foreman foreman) {
        ProductionObject productionObject = foremanRepository.findById(foreman.getId()).orElseThrow().getProductionObject();
        foreman.setProductionObject(productionObject);
        foremanRepository.save(foreman);
    }
}
