package com.example.commerce.composition.repository;

import com.example.commerce.composition.model.Composition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompositionRepository extends JpaRepository<Composition, UUID> {
}
