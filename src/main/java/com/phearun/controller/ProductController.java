/**
 * Author : PhearunPhin
 * Date : 8/24/2023
 */

package com.phearun.controller;

import com.phearun.dto.ModelDTO;
import com.phearun.dto.ProductDTO;
import com.phearun.exception.ApiException;
import com.phearun.mapper.ModelMapper;
import com.phearun.mapper.ProductMapper;
import com.phearun.model.Model;
import com.phearun.model.Product;
import com.phearun.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductMapper productMapper;
    private final ProductService productService;
    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO dto) {
        Product product = productMapper.toProduct(dto);
        return ResponseEntity.ok(productService.save(product));
    }
}
