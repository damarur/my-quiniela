package es.damarur.myquiniela.model.v1.admin;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import es.damarur.myquiniela.model.v1.admin.AdminGameDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * AdminQuinielaDTO
 */

@JsonTypeName("Quiniela")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.4.0")
public class AdminQuinielaDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  private java.time.LocalDateTime dateTime;

  private String title;

  private String description;

  @Valid
  private List<@Valid AdminGameDTO> games = new ArrayList<>();

  public AdminQuinielaDTO id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public AdminQuinielaDTO dateTime(java.time.LocalDateTime dateTime) {
    this.dateTime = dateTime;
    return this;
  }

  /**
   * Get dateTime
   * @return dateTime
  */
  @NotNull @Valid 
  @Schema(name = "date_time", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("date_time")
  public java.time.LocalDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(java.time.LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public AdminQuinielaDTO title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
  */
  @NotNull 
  @Schema(name = "title", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public AdminQuinielaDTO description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  
  @Schema(name = "description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AdminQuinielaDTO games(List<@Valid AdminGameDTO> games) {
    this.games = games;
    return this;
  }

  public AdminQuinielaDTO addGamesItem(AdminGameDTO gamesItem) {
    if (this.games == null) {
      this.games = new ArrayList<>();
    }
    this.games.add(gamesItem);
    return this;
  }

  /**
   * Get games
   * @return games
  */
  @NotNull @Valid 
  @Schema(name = "games", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("games")
  public List<@Valid AdminGameDTO> getGames() {
    return games;
  }

  public void setGames(List<@Valid AdminGameDTO> games) {
    this.games = games;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdminQuinielaDTO quiniela = (AdminQuinielaDTO) o;
    return Objects.equals(this.id, quiniela.id) &&
        Objects.equals(this.dateTime, quiniela.dateTime) &&
        Objects.equals(this.title, quiniela.title) &&
        Objects.equals(this.description, quiniela.description) &&
        Objects.equals(this.games, quiniela.games);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, dateTime, title, description, games);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdminQuinielaDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    games: ").append(toIndentedString(games)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

