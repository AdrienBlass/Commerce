package com.example.commerce.article.dto;

import com.example.commerce.enums.Tva;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {

    private UUID idArticle;

    private String nomFournisseur;
    private String codeArticle;
    private String nomArticle;
    private Date dateAchat;
    private Double prixAchatHt;
    private Double prixAchatTtc;
    private Integer quantite;
    private Tva tva;
    private Tva tvaVente;

    private Double montantTva;
    private Double coefficiantMagore;
    private Double prixVenteTtc;
    private Double prixVenteReel;

    private Double prixAchatHtUnitaire;
    private Double prixAchatTtcUnitaire;
    private Double prixVenteTtcUnitaire;
}
