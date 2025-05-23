package com.svar_proekt.weldproject.services;

import com.svar_proekt.weldproject.repositories.ForemanRepository;
import org.springframework.stereotype.Service;

@Service
public class ForemanService {
    private final ForemanRepository foremanRepository;

    public ForemanService(ForemanRepository foremanRepository) {
        this.foremanRepository = foremanRepository;
    }
}
