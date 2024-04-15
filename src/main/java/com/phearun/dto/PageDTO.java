/**
 * Author : PhearunPhin
 * Date : 7/26/2023
 */

package com.phearun.dto;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PageDTO {

    private List<?> list;
    private PaginationDTO pagination;
   // public PageDTO(Page<?> page){



       // this.list = page.getContent();
        /*
        this.pagination = PaginationDTO.builder()
                .last(page.isLast())
                .first(page.isLast())
               // ...
                .build();
        */
        /*
        this.pagination = new PaginationDTO();
        this.pagination.setEmpty(page.isEmpty());
        this.pagination.setFirst(page.isFirst());
        this.pagination.setLast(page.isLast());
        this.pagination.setNumber(page.getNumber());
        this.pagination.setNumberOfElements(page.getNumberOfElements());
        this.pagination.setTotalPages(page.getTotalPages());
        this.pagination.setSize(page.getSize());
        this.pagination.setTotalElements(page.getTotalElements());
        this.pagination.setTotalPages(page.getTotalPages());
        */

   // }

}
