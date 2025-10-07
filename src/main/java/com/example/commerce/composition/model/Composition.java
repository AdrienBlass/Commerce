package com.example.commerce.composition.model;


import com.example.commerce.article.model.Article;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name ="composition")
public class Composition {


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id_composition", updatable = false, nullable = false)
    private UUID idComposition;

    @Column
    private String nom;

    @Column
    private Double prixHtUnitaire;

    @Column
    private Double prixTtcUnitaire;

    @Column
    @ElementCollection
    private List<Article> ingredients;
}
