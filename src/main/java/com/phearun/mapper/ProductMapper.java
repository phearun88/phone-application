package com.phearun.mapper;

import com.phearun.dto.ProductDTO;
import com.phearun.model.Product;
import com.phearun.service.ModelService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ModelService.class})
public interface ProductMapper {
    @Mapping(target = "model", source = "dto.modelId")
    Product toProduct(ProductDTO dto);

    @Mapping(target = "modelId", source = "model.id")
    ProductDTO toDTO(Product entity);

}
