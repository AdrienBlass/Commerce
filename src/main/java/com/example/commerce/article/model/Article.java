package com.example.commerce.article.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "Article")
public class Article {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id_article", updatable = false, nullable = false)
    private UUID idArticle;

    @Column(name = "nom_fournisseur")
    private String nomFournisseur;

    @Column(name = "montant_tva")
    private Double montantTva;

    @Column(name = "coefficient_marge")
    private Double coefficiantMagore;

    @Column(name = "code_article" )
    private String codeArticle;

    @Column(name = "nom_article")
    private String nomArticle;

    @Column(name = "date_achat" ,  nullable = true)
    private Date dateAchat;

    @Column(name = "quantite")
    private Integer quantite;

    @Column(name = "prix_achat_ht")
    private Double prixAchatHt;

    @Column(name = "prix_achat_ttc")
    private Double prixAchatTtc;

    @Column(name = "tva")
    private String tva;

    @Column(name = "tva_vente")
    private String tvaVente;

    @Column
    private Double prixVenteTtc;

    @Column
    private Double prixVenteReel;

    @Column
    private Double prixAchatHtUnitaire;

    @Column
    private Double prixAchatTtcUnitaire;

    @Column
    private Double prixVenteTtcUnitaire;
}
