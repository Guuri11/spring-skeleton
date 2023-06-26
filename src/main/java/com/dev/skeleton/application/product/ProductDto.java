package com.dev.skeleton.application.product;

import java.time.LocalDateTime;
import java.util.UUID;

public record ProductDto(UUID id, String name, LocalDateTime createdAt, LocalDateTime updateAt) {

}