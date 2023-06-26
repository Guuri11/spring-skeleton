package com.dev.skeleton.domain.mapper;

import com.dev.skeleton.application.product.ProductDto;
import com.dev.skeleton.application.product.ProductRequest;
import com.dev.skeleton.domain.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

  @Autowired
  private ModelMapper modelMapper;

  public ProductDto toDto(final Product entity) {

    if (entity == null) {
      return null;
    }
    return new ProductDto(entity.getId(), entity.getName(), entity.getCreatedAt(), entity.getUpdatedAt());
  }

  public Product toEntity(final ProductDto dto) {

    if (dto == null) {
      return null;
    }
    return new Product(dto.id(), dto.name(), dto.createdAt(), dto.updateAt());
  }

  public Product toEntity(final ProductRequest request) {

    if (request == null) {
      return null;
    }
    final Product product = new Product();
    product.setName(request.name());
    return product;
  }
}