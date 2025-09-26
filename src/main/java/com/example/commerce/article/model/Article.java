package com.example.commerce.article.model;


import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "Article")
public class Article {

    @Column(name = "nom_fournisseur")
    private String nomFournisseur;

    @Column(name = "montant_tva")
    private Double montantTva;

    @Column(name = "coefficient_marge")
    private Double coefficiantMagore;

    @Id
    @Column(name = "code_article" , unique = true, nullable = false)
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
}
