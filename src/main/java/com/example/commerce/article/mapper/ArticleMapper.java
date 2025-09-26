package com.example.commerce.article.mapper;

import com.example.commerce.article.dto.ArticleDto;
import com.example.commerce.article.model.Article;
import com.example.commerce.enums.Tva;

public class ArticleMapper {

    public static ArticleDto toDTO(Article article) {
        ArticleDto dto = new ArticleDto();
        dto.setCodeArticle(article.getCodeArticle());
        dto.setNomArticle(article.getNomArticle());
        dto.setMontantTva(article.getMontantTva());
        dto.setCoefficiantMagore(article.getCoefficiantMagore());
        dto.setPrixVenteReel(article.getPrixVenteReel());
        if (article.getTva() != null) {
            dto.setTva(Tva.fromLabel(article.getTva()));
        }
        if (article.getTvaVente() != null) {
            dto.setTvaVente(Tva.fromLabel(article.getTvaVente()));
        }

        dto.setPrixVenteTtc(article.getPrixVenteTtc());
        dto.setNomFournisseur(article.getNomFournisseur());
        dto.setPrixAchatHt(article.getPrixAchatHt());
        dto.setPrixAchatTtc(article.getPrixAchatTtc());

        if (article.getDateAchat() != null) {
            dto.setDateAchat(article.getDateAchat());
        }

        dto.setQuantite(article.getQuantite());
        return dto;
    }

    public static Article toEntity(ArticleDto dto) {
        Article article = new Article();
        article.setCodeArticle(dto.getCodeArticle());
        article.setNomArticle(dto.getNomArticle());
        article.setMontantTva(dto.getMontantTva());
        article.setCoefficiantMagore(dto.getCoefficiantMagore());
        article.setPrixVenteReel(dto.getPrixVenteReel());
        if (dto.getTva() != null) {
            article.setTva(dto.getTva().getLabel());
        }
        if (dto.getTvaVente() != null) {
            article.setTvaVente(dto.getTvaVente().getLabel());
        }

        article.setPrixVenteTtc(dto.getPrixVenteTtc());
        article.setNomFournisseur(dto.getNomFournisseur());
        article.setPrixAchatTtc(dto.getPrixAchatTtc());
        article.setPrixAchatHt(dto.getPrixAchatHt());

        if (dto.getDateAchat() != null) {
            article.setDateAchat(dto.getDateAchat());
        }

        article.setQuantite(dto.getQuantite());
        return article;
    }


}
