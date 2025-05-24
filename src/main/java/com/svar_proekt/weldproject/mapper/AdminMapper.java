package com.svar_proekt.weldproject.mapper;

import com.svar_proekt.weldproject.dto.AdminDTO;
import com.svar_proekt.weldproject.model.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    public Admin toEntity(AdminDTO adminDTO);

    public AdminDTO toDTO(Admin admin);
}
