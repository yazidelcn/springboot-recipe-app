package com.elcnyazid.recipeapp.entities;

import lombok.Data;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.Set;
@Entity
@Data
public class Recipe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Description;
    private int prepTime;
    private int cookTime;
    private int serving;
    private String source;
    private String url;
    private String directions;
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
    @Lob
    private byte[] image;
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private Set<Ingredient> ingredientsSet;
    @ManyToMany()
    @JoinTable(name = "recipe_category",
               joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categorySet;

}
