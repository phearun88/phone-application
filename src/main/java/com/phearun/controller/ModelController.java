package com.phearun.controller;

import com.phearun.dto.ModelDTO;
import com.phearun.dto.PageDTO;
import com.phearun.exception.ApiException;
import com.phearun.mapper.ModelMapper;
import com.phearun.mapper.PageMapper;
import com.phearun.model.Model;
import com.phearun.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/models")
public class ModelController {


    private final ModelService modelService;

    @Autowired
    private ModelMapper modelMapper;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ModelDTO dto) throws ApiException {
        Model model = modelMapper.toModel(dto);
        model = modelService.save(model);
        ModelDTO modelDTO = ModelMapper.INSTANCE.toDTO(model);
        return ResponseEntity.ok(modelDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) throws ApiException {
        Model model = modelService.getById(id);
        return ResponseEntity.ok(ModelMapper.INSTANCE.toDTO(model));
    }

    @GetMapping
    public ResponseEntity<?> getModelList(@RequestParam Map<String, String> params){

//        List<ModelDTO> list = modelService.getModels(params)
//                .stream()
//                .map(m -> ModelMapper.INSTANCE.toDTO(m))
//                .toList();
//        return ResponseEntity.ok(list);

        Page<Model> page = modelService.getModels(params);

        PageDTO dto = PageMapper.INSTANCE.toDTO(page);
       // dto.setList(page.get().map(m -> ModelMapper.INSTANCE.toDTO(m)).toList());
        dto.setList(page.get().map(ModelMapper.INSTANCE::toDTO).toList());

        return ResponseEntity.ok(dto);
    }
}
