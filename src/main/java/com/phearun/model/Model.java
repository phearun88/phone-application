package com.phearun.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "model")
public class Model {

    @Id
    @GeneratedValue(generator = "model_seq_generator")
    @SequenceGenerator(name = "model_seq_generator", initialValue = 1, sequenceName = "model_seq")
    private Integer id;

    @Column(name = "model_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
