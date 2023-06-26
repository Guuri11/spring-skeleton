package com.dev.skeleton;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Example Backend service", version = "1.0", description = "Documentation Example Management APIs v1.0"))
public class SkeletonApplication {

  public static void main(final String[] args) {

    SpringApplication.run(SkeletonApplication.class, args);
  }

  @Bean
  public ModelMapper modelMapper() {

    return new ModelMapper();
  }
}
