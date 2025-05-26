package com.svar_proekt.weldproject.mapper;

import com.svar_proekt.weldproject.dto.WorkerDTO;
import com.svar_proekt.weldproject.model.Worker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = ForemanMapper.class)
public interface WorkerMapper {
    public Worker toEntity(WorkerDTO workerDTO);

    @Mapping(source = "foreman", target = "foremanDTO")
    public WorkerDTO toDTO(Worker worker);

    public List<Worker> toEntityList(List<WorkerDTO> workerDTOList);

    public List<WorkerDTO> toDTOList(List<Worker> workerList);
}
