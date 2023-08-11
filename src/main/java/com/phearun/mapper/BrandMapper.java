
package com.phearun.mapper;

import com.phearun.dto.BrandDTO;
import com.phearun.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BrandMapper {
    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

    Brand toEntity(BrandDTO dto);

    BrandDTO toDTO(Brand entity);


    void update(@MappingTarget Brand target, Brand source);


}
