package com.example.commerce.composition.dto;

import com.example.commerce.article.model.Article;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompositionDto {


    private UUID idComposition;
    private String nom;

    private Double prixHtUnitaire;

    private Double prixTtcUnitaire;

    private List<Article> ingredients;
}
