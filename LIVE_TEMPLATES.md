# 📝 Live Templates

Here you have a list of the available list templates that I've made in order to speed up
development.
Just import settings.zip in your Intellij editor. Then just type one of the following templates in
the editor

## List

### domain ➡ Create a domain entity

```
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@jakarta.persistence.Entity
public class $Entity$ {

  @jakarta.persistence.Id
  @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.UUID)
  private java.util.UUID id;
}
```

### domdate ➡ domain createdAt & updatedAt

```
private java.time.LocalDateTime createdAt;
private java.time.LocalDateTime updatedAt;
```

### mapper➡ generate a model mapper

```
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class $DOMAIN$Mapper {

  public $DOMAIN$Dto toDto(final $DOMAIN$ entity) {

    if (entity == null) {
      return null;
    }
    return new $DOMAIN$Dto(entity.getId(), entity.getName(), entity.getCreatedAt(), entity.getUpdatedAt());
  }

  public $DOMAIN$ toEntity(final $DOMAIN$Dto dto) {

    if (dto == null) {
      return null;
    }
    return new $DOMAIN$(dto.id(), dto.name(), dto.createdAt(), dto.updateAt());
  }

  public $DOMAIN$ toEntity(final $DOMAIN$Request request) {

    if (request == null) {
      return null;
    }
    final $DOMAIN$ $DOMAIN_OBJECT$ = new $DOMAIN$();
    // TODO: map here the object values
    return $DOMAIN_OBJECT$;
  }
}
```

### prb ➡ private Boolean

```
private Boolean $VAR$;
```

### prs ➡ private String

```
private String $VAR$;
```

### pri ➡ private Integer

```
private Integer $VAR$;
```

### prf ➡ private float

```
private float $VAR$;
```

### repo ➡ generate a domain repository with jpa

```
import com.dev.skeleton.domain.$DOMAIN$;
import org.springframework.data.jpa.repository.JpaRepository;

public interface $DOMAIN$Repository extends JpaRepository<$DOMAIN$, java.util.UUID> {

}
```

### controller ➡ Generate a controller template

```
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v$VERSION_NUMBER$/$PATH$")
@RequiredArgsConstructor
public class $DOMAIN_NAME$Controller extends BaseController {
  private final $DOMAIN_NAME$Service $SERVICE_NAME$Service;
}
```

### controller-crud-mvc ➡ generate controller crud for mvc

```
@org.springframework.web.bind.annotation.GetMapping
@io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK"),
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal server error")
})
  public java.util.Collection<$DOMAIN$Dto> all() {

    this.logger.info("Request: GET /$DOMAIN_LOWERCASE$s");
    return $DOMAIN_LOWERCASE$Service.all();
  }

  @org.springframework.web.bind.annotation.GetMapping("/{id}")
  @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
      @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK"),
      @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Item not found"),
      @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public $DOMAIN$Dto one(@org.springframework.web.bind.annotation.PathVariable("id") final java.util.UUID id) {

    this.logger.info("Request: GET /$DOMAIN_LOWERCASE$s/{}", id);
    return $DOMAIN_LOWERCASE$Service.one(id);
  }

  @org.springframework.web.bind.annotation.PostMapping
  @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
      @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK"),
      @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "BAD REQUEST"),
      @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal server error")
  })
  $DOMAIN$Dto create(@org.springframework.web.bind.annotation.RequestBody final $DOMAIN$Request $DOMAIN_LOWERCASE$) {

    this.logger.info("Request: POST /$DOMAIN_LOWERCASE$s : {}", $DOMAIN_LOWERCASE$);
    return $DOMAIN_LOWERCASE$Service.create($DOMAIN_LOWERCASE$);
  }

  @org.springframework.web.bind.annotation.PutMapping("/{id}")
  @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
      @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK"),
      @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "BAD REQUEST"),
      @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "NOT FOUND"),
      @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal server error")
  })
  $DOMAIN$Dto replace(@RequestBody final $DOMAIN$Request $DOMAIN_LOWERCASE$, @org.springframework.web.bind.annotation.PathVariable("id") final java.util.UUID id) {

    this.logger.info("Request: PUT /$DOMAIN_LOWERCASE$s/{} with body {}", id,
        $DOMAIN_LOWERCASE$);
    return $DOMAIN_LOWERCASE$Service.update($DOMAIN_LOWERCASE$, id);
  }

  @org.springframework.web.bind.annotation.DeleteMapping("/{id}")
  @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
      @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK"),
      @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "NOT FOUND"),
      @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal server error")
  })
  org.springframework.http.ResponseEntity<?> delete(@org.springframework.web.bind.annotation.PathVariable("id") final java.util.UUID id) {

    this.logger.info("Request: DELETE /$DOMAIN_LOWERCASE$s/{}", id);
    $DOMAIN_LOWERCASE$Service.delete(id);
    return ResponseEntity.noContent()
        .build();
  }
```