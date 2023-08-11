package com.phearun.service;

import com.phearun.dto.BrandDTO;
import com.phearun.exception.ApiException;
import com.phearun.model.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {
    Brand save(Brand entity);
    Brand getById(Integer id);
    Brand update(Integer id, Brand brand) ;

    void delete(Integer id);

    List<Brand> getBrands();


}
