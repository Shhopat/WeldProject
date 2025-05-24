package com.svar_proekt.weldproject.mapper;

import com.svar_proekt.weldproject.dto.ProductionObjectDTO;
import com.svar_proekt.weldproject.model.ProductionObject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = AdminMapper.class)
public interface ProductionObjectMapper {
    @Mapping(source = "admin", target = "adminDTO")
    public ProductionObjectDTO toDTO(ProductionObject productionObject);

    public ProductionObject toEntity(ProductionObjectDTO productionObjectDTO);

    public List<ProductionObjectDTO> toDTOList(List<ProductionObject> productionObjectlist);

    public List<ProductionObject> toEntityList(List<ProductionObjectDTO> productionObjectDTOlist);

}
