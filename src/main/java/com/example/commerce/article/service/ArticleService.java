package com.example.commerce.article.service;

import com.example.commerce.article.dto.ArticleDto;
import com.example.commerce.article.mapper.ArticleMapper;
import com.example.commerce.article.model.Article;
import com.example.commerce.article.repository.ArticleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

import static com.example.commerce.utils.MathUtils.*;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleDto createArticle(ArticleDto dto) {
        // Vérification de la TVA
        if (dto.getTva() == null) {
            throw new IllegalArgumentException("TVA obligatoire");
        }
        if (dto.getPrixAchatHt() == null) {
            throw new IllegalArgumentException("Prix HT obligatoire");
        }

        // Calcul du prix TTC
        double taux = switch (dto.getTva()) {
            case TVA_5_5 -> 5.5;
            case TVA_10 -> 10.0;
            case TVA_20 -> 20.0;
        };

        double tauxVente = switch (dto.getTvaVente()) {
            case TVA_5_5 -> 5.5;
            case TVA_10 -> 10.0;
            case TVA_20 -> 20.0;
        };

        dto.setPrixAchatHtUnitaire(arrondir2Decimales(dto.getPrixAchatHt() / dto.getQuantite()));

        dto.setMontantTva(calculerTva(dto.getPrixAchatHt(), taux));
        dto.setPrixAchatTtc(calculerPrixTtc(dto.getPrixAchatHt(), taux));
        dto.setPrixAchatTtcUnitaire(arrondir2Decimales(dto.getPrixAchatTtc() / dto.getQuantite()));

        double coefficiantMagore = dto.getPrixAchatHtUnitaire() * 3;
        dto.setCoefficiantMagore(arrondir2Decimales(coefficiantMagore));

        dto.setPrixVenteTtc(calculerPrixTtc(coefficiantMagore, tauxVente));
        dto.setPrixVenteTtcUnitaire(calculerPrixTtc(coefficiantMagore, tauxVente));

        Article article = ArticleMapper.toEntity(dto);
        article = articleRepository.save(article);    // Hibernate fera un insert
        return ArticleMapper.toDTO(article);          // DTO avec ID généré
    }


    public List<ArticleDto> getAllArticles() {
        return articleRepository.findAll()
                .stream()
                .map(ArticleMapper::toDTO) // conversion Entity -> DTO
                .toList();
    }

    public void deleteArticleById(UUID id) {
        if (!articleRepository.existsById(id)) {
            throw new EntityNotFoundException("Article avec id " + id + " non trouvé");
        }
        articleRepository.deleteById(id);
    }


    public ArticleDto updateArticle(ArticleDto dto) {
        Article entity = articleRepository.findById(dto.getIdArticle())
                .orElseThrow(() -> new IllegalArgumentException("Article introuvable"));

        entity.setNomFournisseur(dto.getNomFournisseur());
        entity.setNomArticle(dto.getNomArticle());
        entity.setDateAchat(dto.getDateAchat());
        entity.setPrixAchatHt(dto.getPrixAchatHt());
        entity.setPrixVenteTtc(dto.getPrixVenteTtc());
        entity.setQuantite(dto.getQuantite());
        entity.setTva(dto.getTva().getLabel());
        entity.setTvaVente(dto.getTvaVente().getLabel());
        entity.setPrixVenteReel(dto.getPrixVenteReel());
        entity.setCodeArticle(dto.getCodeArticle());
        Article saved = articleRepository.save(entity);

        return ArticleMapper.toDTO(saved);
    }


    public boolean existsById(UUID idArticle) {
        return articleRepository.existsById(idArticle);
    }
}
