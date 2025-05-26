package com.svar_proekt.weldproject.mapper;

import com.svar_proekt.weldproject.dto.ForemanDTO;
import com.svar_proekt.weldproject.model.Foreman;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = ProductionObjectMapper.class)
public interface ForemanMapper {
    @Mapping(source = "productionObject", target = "productionObjectDTO")
    public ForemanDTO toDTO(Foreman foreman);

    public Foreman toEntity(ForemanDTO foremanDTO);

    public List<Foreman> toEntityList(List<ForemanDTO> foremanDTOList);

    public List<ForemanDTO> toDTOLIst(List<Foreman> foremanList);
}
