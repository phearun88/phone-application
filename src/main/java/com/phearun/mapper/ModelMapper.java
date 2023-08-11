package com.phearun.mapper;


import com.phearun.dto.ModelDTO;

import com.phearun.model.Brand;
import com.phearun.model.Model;
import com.phearun.service.BrandService;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {BrandService.class})
public interface ModelMapper {
    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

    @Mapping(target = "brand", source = "dto.brandId")
    Model toModel(ModelDTO dto);

    @Mapping(target = "brandId", source = "brand.id")
    ModelDTO toDTO(Model entity);

    //Brand toBrand(Integer id);


}
