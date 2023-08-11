package com.phearun.controller;

import com.phearun.dto.BrandDTO;
import com.phearun.exception.ApiException;
import com.phearun.mapper.BrandMapper;
import com.phearun.model.Brand;
import com.phearun.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    public ResponseEntity<Brand> create(@RequestBody BrandDTO brandDTO){
        Brand brand =  BrandMapper.INSTANCE.toEntity(brandDTO);
        brand = brandService.save(brand);
        return ResponseEntity.ok(brand);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) throws ApiException {
        return ResponseEntity.ok(brandService.getById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Brand> update(@PathVariable("id") int id, @RequestBody BrandDTO brandDTO) throws ApiException {
        Brand brand =  BrandMapper.INSTANCE.toEntity(brandDTO);
        return ResponseEntity.ok(brandService.update(id, brand));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id) throws ApiException {
        brandService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<?> list(){
        List<BrandDTO> listBrand =  brandService.getBrands()
                .stream()
                .map(b -> BrandMapper.INSTANCE.toDTO(b))
                .toList();
        return ResponseEntity.ok(listBrand);
    }



}
