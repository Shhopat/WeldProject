package com.svar_proekt.weldproject;

import com.svar_proekt.weldproject.client.ItamClient;
import com.svar_proekt.weldproject.dto.ItamDTO;
import com.svar_proekt.weldproject.dto.ProductionObjectDTO;
import com.svar_proekt.weldproject.mapper.ProductionObjectMapper;
import com.svar_proekt.weldproject.services.ProductionObjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
public class WeldprojectApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeldprojectApplication.class, args);
    }


    }

