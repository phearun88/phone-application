package com.phearun.utils;

import org.apache.commons.collections4.MapUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface PageUtils {
    int PAGE_SIZE_DEFAULT= 10;
    int PAGE_NUMBER_DEFAULT= 1;
    String PAGE_SIZE= "_limit";
    String PAGE_NUMBER= "_page";
    static Pageable getPageable(Map<String, String> params){
        int pageSize= MapUtils.getInteger(params,PAGE_SIZE, PAGE_SIZE_DEFAULT);
        int pageNumber= MapUtils.getInteger(params,PAGE_NUMBER, PAGE_NUMBER_DEFAULT);
        if(pageNumber <0){
            pageNumber= PAGE_NUMBER_DEFAULT;
        }
        if (pageSize <0){
            pageSize = PAGE_SIZE_DEFAULT;
        }
        Pageable pageable = PageRequest.of(pageNumber-1,pageSize);
        return pageable;
    }
}
