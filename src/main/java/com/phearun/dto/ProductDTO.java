/**
 * Author : PhearunPhin
 * Date : 8/24/2023
 */
package com.phearun.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private Integer modelId;
    private Short yearMade;
    //private Integer colorId;
    private BigDecimal importPrice;
    private Double salePrice;
    private LocalDateTime dateImport;
    private String imagePath;
}
