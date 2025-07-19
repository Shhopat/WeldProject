package com.svar_proekt.weldproject.services;

import com.svar_proekt.weldproject.model.Foreman;
import com.svar_proekt.weldproject.model.Joint;
import com.svar_proekt.weldproject.repositories.JointRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Data
@Transactional(readOnly = true)
public class JointService {
    private final JointRepository jointRepository;
    private final ForemanService foremanService;

    @Transactional
    public void save(Joint joint) {
        jointRepository.save(joint);


    }


}
