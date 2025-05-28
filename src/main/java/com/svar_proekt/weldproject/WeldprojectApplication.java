package com.svar_proekt.weldproject;

import com.svar_proekt.weldproject.client.ItamClient;
import com.svar_proekt.weldproject.dto.ItamDTO;
import com.svar_proekt.weldproject.dto.ProductionObjectDTO;
import com.svar_proekt.weldproject.mapper.ProductionObjectMapper;
import com.svar_proekt.weldproject.services.ProductionObjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class WeldprojectApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(WeldprojectApplication.class);
    private final ItamClient itamClient;
    private final ProductionObjectService productionObjectService;
    private final ProductionObjectMapper productionObjectMapper;

    @Autowired
    public WeldprojectApplication(ItamClient itamClient, ProductionObjectService productionObjectService, ProductionObjectMapper productionObjectMapper) {
        this.itamClient = itamClient;
        this.productionObjectService = productionObjectService;
        this.productionObjectMapper = productionObjectMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(WeldprojectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("начало работы");
        ProductionObjectDTO productionObjectDTO = productionObjectMapper.toDTO(productionObjectService.findById(1));


        try {
            logger.debug("перед методом itamClient.getAllItam ");
            for (ItamDTO itamDTO : itamClient.getAllItam(productionObjectDTO)) {
                System.out.println(itamDTO.getId() + ". " + itamDTO.getName());
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }


    }
}
