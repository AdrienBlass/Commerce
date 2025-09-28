package com.example.commerce.article.controller;


import com.example.commerce.article.dto.ArticleDto;
import com.example.commerce.article.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/article")
public class ArticleController {


    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @PostMapping
    public ResponseEntity<ArticleDto> createArticle(@RequestBody ArticleDto dto) {


        // Si dateAchat est vide, laisser null
        if (dto.getDateAchat() == null) {
            dto.setDateAchat(null);
        }

        ArticleDto savedDto = articleService.createArticle(dto);
        return ResponseEntity.ok(savedDto);

    }


    @GetMapping
    public ResponseEntity<List<ArticleDto>> getAllArticles() {
        List<ArticleDto> articles = articleService.getAllArticles();
        return ResponseEntity.ok(articles);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticleById(@PathVariable UUID id) {
        articleService.deleteArticleById(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleDto> updateArticle(
            @PathVariable UUID id,
            @RequestBody ArticleDto dto) {
        try {
            // Vérifier que l'article existe
            if (!articleService.existsById(id)) {
                return ResponseEntity.notFound().build(); // 404 si l'article n'existe pas
            }

            // On force l'id du DTO avec celui de l'URL pour éviter une incohérence
            dto.setIdArticle(id);

            ArticleDto updatedDto = articleService.updateArticle(dto);

            return ResponseEntity.ok(updatedDto); // 200 avec l'article modifié
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build(); // 400 si problème dans les données
        }
    }

}
