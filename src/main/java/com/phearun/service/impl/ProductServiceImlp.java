/**
 * Author : PhearunPhin
 * Date : 8/24/2023
 */

package com.phearun.service.impl;

import com.phearun.model.Product;
import com.phearun.repository.ProductRepository;
import com.phearun.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImlp implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public Product save(Product product) {

        return productRepository.save(product);
    }
}
