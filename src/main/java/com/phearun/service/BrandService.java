package com.phearun.service;

import com.phearun.model.Brand;
import java.util.List;


public interface BrandService {
    Brand save(Brand entity);
    Brand getById(Integer id);
    Brand update(Integer id, Brand brand) ;

    void delete(Integer id);

    List<Brand> getBrands();


}
