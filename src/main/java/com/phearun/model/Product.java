/**
 * Author : PhearunPhin
 * Date : 8/24/2023
 */

package com.phearun.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{cannot.be.blank}")
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @NotNull(message = "{required.field}")
    @Column(name = "year_made")
    private Short yearMade;

	/*
	@ManyToOne
	@JoinColumn(name = "color_id")
	private Color color;
*/

    @DecimalMin(value = "0.000001")
    @Column(name = "import_price")
    private BigDecimal importPrice;

    @Column(name = "sale_price")
    private Double salePrice;

    @Column(name = "date_import")
    private LocalDateTime dateImport;

    // private Integer numberOfUnit; // @TODO should move to Stock table? reason?

    @Column(name = "image_path")
    private String imagePath;

}
