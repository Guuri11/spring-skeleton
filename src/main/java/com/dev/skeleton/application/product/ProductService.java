package com.dev.skeleton.application.product;

import com.dev.skeleton.application.exception.NotFoundException;
import com.dev.skeleton.domain.Product;
import com.dev.skeleton.domain.mapper.ProductMapper;
import com.dev.skeleton.infrastructure.persistence.ProductRepository;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;
  private final ProductMapper productMapper;

  public Collection<ProductDto> all() {

    return productRepository.findAll()
        .stream()
        .map(productMapper::toDto)
        .toList();
  }

  public ProductDto one(final UUID id) {

    return productRepository.findById(id)
        .map(productMapper::toDto)
        .orElseThrow(() -> new NotFoundException(id));
  }

  public ProductDto create(final ProductRequest request) {

    final Product product = productMapper.toEntity(request);
    product.setCreatedAt(LocalDateTime.now());
    product.setUpdatedAt(LocalDateTime.now());
    productRepository.save(product);
    return productMapper.toDto(product);
  }

  public ProductDto update(final ProductRequest request, final UUID id) {

    final Product existing = productRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(id));

    existing.setUpdatedAt(LocalDateTime.now());
    existing.setName(request.name());
    productRepository.save(existing);

    return productMapper.toDto(productRepository.save(existing));
  }

  public void delete(final UUID id) {

    final Product product = productRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(id));

    productRepository.delete(product);
  }
}
