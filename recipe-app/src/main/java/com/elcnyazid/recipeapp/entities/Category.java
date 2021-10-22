package com.elcnyazid.recipeapp.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
@Entity
@Data
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    @ManyToMany(mappedBy = "categorySet")
    private Set<Recipe> recipes;
}
