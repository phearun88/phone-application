package com.phearun.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="brand")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
    @Id
   // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GeneratedValue(generator = "brand_seq_generator")
    @SequenceGenerator(name = "brand_seq_generator", initialValue = 1, sequenceName = "brand_seq")
    private Integer id;
    private String name;

}
