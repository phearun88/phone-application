package com.phearun.service.impl;

import com.phearun.dto.ModelDTO;
import com.phearun.exception.ResourceNotFoundException;
import com.phearun.mapper.ModelMapper;
import com.phearun.model.Model;
import com.phearun.repository.ModelRepository;
import com.phearun.service.BrandService;
import com.phearun.service.ModelService;
import com.phearun.specification.ModelFilter;
import com.phearun.specification.ModelSpec;
import com.phearun.utils.PageUtils;
import lombok.RequiredArgsConstructor;

import org.apache.commons.collections4.MapUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final BrandService brandService;
    @Override
    public Model save(Model  entity) {
        //brandService.getById(entity.getBrand().getId());
        //Model model = ModelMapper.INSTANCE.toModel(entity);

        return modelRepository.save(entity);
    }


    @Override
    public Model getById(Integer id){

        return modelRepository.findById(id)
                //.orElseThrow(()->new ApiException(HttpStatus.NOT_FOUND, String.format("model not found for id=%d", id)));
                .orElseThrow(()-> new ResourceNotFoundException("Model", id));
    }


    @Override
    public Page<Model> getModels(Map<String, String> params) {

        Pageable pageable= PageUtils.getPageable(params);

        ModelFilter modelFilter = new ModelFilter();
        if (params.containsKey("modelId")){
            modelFilter.setModelId(MapUtils.getInteger(params,"modelId"));
        }
        if (params.containsKey("modelName")){
            modelFilter.setModelName(MapUtils.getString(params,"modelName"));
        }
        if (params.containsKey("brandId")){
            modelFilter.setBrandId(MapUtils.getInteger(params,"brandId"));
        }
        if (params.containsKey("brandName")){
            modelFilter.setBrandName(MapUtils.getString(params,"brandName"));
        }

        ModelSpec modelSpec = new ModelSpec(modelFilter);

        Page<Model> page = modelRepository.findAll(modelSpec, pageable);

       // int numberOfElements = page.getNumberOfElements();
        return page;

    }


}
