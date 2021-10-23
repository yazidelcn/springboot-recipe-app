package com.elcnyazid.recipeapp.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Data
@EqualsAndHashCode(exclude = {"recipes"})
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes = new HashSet<>();
}
