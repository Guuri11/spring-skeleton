package com.dev.skeleton.infrastructure.web;

import com.dev.skeleton.application.product.ProductDto;
import com.dev.skeleton.application.product.ProductRequest;
import com.dev.skeleton.application.product.ProductService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.Collection;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController extends BaseController {

  private final ProductService productService;

  @GetMapping
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public Collection<ProductDto> all() {

    this.logger.info("Request: GET /products");
    return productService.all();
  }

  @GetMapping("/{id}")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "404", description = "Item not found"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public ProductDto one(@PathVariable("id") final UUID id) {

    this.logger.info("Request: GET /products/{}", id);
    return productService.one(id);
  }

  @PostMapping
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "401", description = "BAD REQUEST"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  ProductDto create(@RequestBody final ProductRequest product) {

    this.logger.info("Request: POST /products : {}", product);
    return productService.create(product);
  }

  @PutMapping("/{id}")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "401", description = "BAD REQUEST"),
      @ApiResponse(responseCode = "404", description = "NOT FOUND"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  ProductDto replace(@RequestBody final ProductRequest product, @PathVariable("id") final UUID id) {

    this.logger.info("Request: PUT /products/{} with body {}", id,
        product);
    return productService.update(product, id);
  }

  @DeleteMapping("/{id}")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "404", description = "NOT FOUND"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  ResponseEntity<?> delete(@PathVariable("id") final UUID id) {

    this.logger.info("Request: DELETE /products/{}", id);
    productService.delete(id);
    return ResponseEntity.noContent()
        .build();
  }
}