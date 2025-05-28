package com.svar_proekt.weldproject.mapper;

import com.svar_proekt.weldproject.client.ItamClient;
import com.svar_proekt.weldproject.dto.ItamDTO;
import com.svar_proekt.weldproject.model.Itam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItamMapper {

    @Mapping(source = "productionObject", target = "productionObjectDTO")
    public ItamDTO toDTO(Itam itam);

    @Mapping(source = "productionObjectDTO", target = "productionObject")
    public Itam toEntity(ItamDTO itamDTO);

    public List<Itam> toEntityList(List<ItamDTO> itamDTOList);

    public List<ItamDTO> itamDTOList(List<Itam> entityList);
}
