/**
 * Author : PhearunPhin
 * Date : 7/26/2023
 */

package com.phearun.specification;

import com.phearun.model.Brand;
import com.phearun.model.Brand_;
import com.phearun.model.Model;
import com.phearun.model.Model_;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@RequiredArgsConstructor
public class ModelSpec implements Specification<Model> {

    private final ModelFilter modelFilter;
    @Override
    public Predicate toPredicate(Root<Model> model, CriteriaQuery<?> query, CriteriaBuilder cb) {

        List<Predicate> list = new ArrayList<>();

        Join<Model, Brand> brand = model.join("brand");
        
        if(modelFilter.getModelId() != null){
            Predicate modelId = model.get(Model_.ID).in(modelFilter.getModelId());
            list.add(modelId);
        }

        if(modelFilter.getModelName() != null){
            //Predicate modelName = cb.like(model.get("name"), "%" + modelFilter.getModelName() + "%");
            Predicate modelName = cb.like(model.get(Model_.NAME), "%" + modelFilter.getModelName() + "%");
            list.add(modelName);
        }

        if(modelFilter.getBrandId() != null){
            Predicate branId = brand.get(Brand_.ID).in(modelFilter.getBrandId());
            list.add(branId);
        }

        if(modelFilter.getBrandName() != null){
            Predicate brandName = cb.like(brand.get(Brand_.NAME), "%" + modelFilter.getBrandName() + "%");
            list.add(brandName);
        }
        Predicate[] predicates = list.toArray(Predicate[]::new);

        return cb.and(predicates);
    }
}
