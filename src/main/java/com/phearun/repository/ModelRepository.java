package com.phearun.repository;

import com.phearun.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ModelRepository extends JpaRepository<Model, Integer>, JpaSpecificationExecutor<Model> {

}
