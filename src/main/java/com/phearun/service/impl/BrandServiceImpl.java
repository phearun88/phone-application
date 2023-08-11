package com.phearun.service.impl;

import com.phearun.dto.BrandDTO;
import com.phearun.exception.ApiException;
import com.phearun.exception.ResourceNotFoundException;
import com.phearun.mapper.BrandMapper;
import com.phearun.model.Brand;
import com.phearun.repository.BrandRepository;
import com.phearun.service.BrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    @Autowired
    private final BrandRepository brandRepository;

    @Override
    public Brand save(Brand entity) {
        Brand brand = brandRepository.save(entity);
        return brand;
    }

    @Override
    public Brand getById(Integer id)  {
        return brandRepository.findById(id)
                .orElseThrow(()->new ApiException(HttpStatus.NOT_FOUND, String.format("brand not found for id=%d", id)));
               // .orElseThrow(()-> new ResourceNotFoundException("Brand", id));

    }

    @Override
    public Brand update(Integer id, Brand source)  {

        Brand target = getById(id);
       // source.setId(id);
       // BrandMapper.INSTANCE.update(target, source);

        BeanUtils.copyProperties(source,target,"id");
        return brandRepository.save(target);

    }

    @Override
    public void delete(Integer id){
        Brand brand = getById(id);
        brandRepository.delete(brand);
        //log.info("brand with id = %id is deleted".formatted(id));
        log.info("brand with id = %d is deleted".formatted(id));
    }

    @Override
    public List<Brand> getBrands() {

        return brandRepository.findAll();
    }
}
