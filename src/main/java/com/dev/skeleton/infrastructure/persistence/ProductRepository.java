package com.dev.skeleton.infrastructure.persistence;

import com.dev.skeleton.domain.Product;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}