package com.kailera.isolated.mappers;

import com.kailera.isolated.DTOs.requests.IsolatedDTO;
import com.kailera.isolated.entities.Isolated;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


// mapeia a entidade para o dto
@Mapper(componentModel = "spring")
public interface IsolatedMapper {

    @Mapping(target = "initialIsolationDate", source = "initialIsolationDate", dateFormat = "dd-MM-yyyy")
    @Mapping(target = "finalIsolationDate", source = "finalIsolationDate", dateFormat = "dd-MM-yyyy")

    Isolated toModel(IsolatedDTO isolatedDTO);

    IsolatedDTO toDTO(Isolated isolated);
}
