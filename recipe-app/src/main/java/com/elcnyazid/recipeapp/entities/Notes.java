package com.elcnyazid.recipeapp.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Notes {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String notes;
    @OneToOne
    private Recipe recipe;
}
