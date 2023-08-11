package com.phearun.service;

import com.phearun.dto.ModelDTO;
import com.phearun.exception.ApiException;
import com.phearun.model.Model;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface ModelService {

    Model save(Model  entity) ;
    Model getById(Integer id) ;
    //List<Model> getModels(Map<String,String> params);
    Page<Model>getModels(Map<String,String> params);




}
