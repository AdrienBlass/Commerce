package com.example.commerce.article.repository;

import com.example.commerce.article.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ArticleRepository extends JpaRepository<Article, String> {

    boolean existsById(String id);

}


