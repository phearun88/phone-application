/**
 * Author : PhearunPhin
 * Date : 8/24/2023
 */

package com.phearun.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "colors")
@Data
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

}
