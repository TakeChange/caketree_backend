package com.caketree_backend.caketree_backend.repository;

import com.caketree_backend.caketree_backend.model.AddCakeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CakeRepository extends JpaRepository<AddCakeEntity, Long> {
}