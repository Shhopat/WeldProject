package com.svar_proekt.weldproject.mapper;

import com.svar_proekt.weldproject.dto.OrderDTO;
import com.svar_proekt.weldproject.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = {ItamMapper.class})
public interface OrderMapper {

    @Mapping(source = "objectId", target = "productionObject.id")
    @Mapping(source = "itamDTOList",target = "itamList" )
    public Order toEntity(OrderDTO orderDTO);

    @Mapping(source = "productionObject.id", target = "objectId")
    @Mapping(source = "itamList", target = "itamDTOList")
    public OrderDTO toDTO(Order order);

    public List<OrderDTO> toDTOList(List<Order> orderList);
    public List<Order> toEntityList(List<OrderDTO> orderDTOList);

}
