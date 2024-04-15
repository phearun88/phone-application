package com.phearun.repository;

import com.phearun.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

    boolean existsByName(String name);

    List<Brand> findByIdIn(List<Integer> ids);

    //List<Brand> findByActive(boolean isActive);
    List<Brand> findByActiveTrue();


}
