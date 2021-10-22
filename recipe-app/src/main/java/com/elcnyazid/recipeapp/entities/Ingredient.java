package com.elcnyazid.recipeapp.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Data
public class Ingredient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String description;
    private BigDecimal amount;
    @ManyToOne
    private Recipe recipe;
    @OneToOne
    private UnitOfMesure uom;
}
