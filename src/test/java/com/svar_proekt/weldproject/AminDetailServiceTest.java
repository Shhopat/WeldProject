package com.svar_proekt.weldproject;


import com.svar_proekt.weldproject.model.Admin;
import com.svar_proekt.weldproject.model.ProductionObject;
import com.svar_proekt.weldproject.repositories.AdminRepository;
import com.svar_proekt.weldproject.services.AdminDetailService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AminDetailServiceTest {

    @Mock
    private AdminRepository adminRepository;

    private Admin admin;
    String username;

    private List<ProductionObject> list;

    @InjectMocks
    private AdminDetailService adminDetailService;

    @BeforeEach
    void init() {
        admin = new Admin(1, "ibragim");
        list = new ArrayList<>();
        list.add(new ProductionObject(2, "Грозный"));
        admin.setObjectList(list);
        username = "ibragim";
    }

    @Test
    public void shouldBeGetAdminByUsername() {

        Mockito.when(adminRepository.findByUsername(username)).thenReturn(Optional.of(admin));

        Admin admin1 = adminDetailService.findByUsername(username);

        Assertions.assertEquals(admin.getId(), admin1.getId());
        Assertions.assertEquals(admin.getUsername(), admin1.getUsername());

        Mockito.verify(adminRepository).findByUsername(username);
    }

    @Test
    public void shouldGetListObjectByUsername() {
        Mockito.when(adminRepository.findByUsername(username)).thenReturn(Optional.of(admin));

        List<ProductionObject> list1 = adminDetailService.getObjectsByUsername(username);

        Assertions.assertEquals(list.get(0).getName(), list1.get(0).getName());
        Assertions.assertEquals(list.get(0).getId(), list1.get(0).getId());

        Mockito.verify(adminRepository).findByUsername(username);

    }

    @Test
    public void shouldGetAdminById() {
        Mockito.when(adminRepository.findById(admin.getId())).thenReturn(Optional.of(admin));

        Admin admin1 = adminDetailService.findById(admin.getId());

        Assertions.assertEquals(admin.getId(), admin1.getId());
        Assertions.assertEquals(admin.getUsername(), admin1.getUsername());

        Mockito.verify(adminRepository).findById(admin.getId());
    }
}
