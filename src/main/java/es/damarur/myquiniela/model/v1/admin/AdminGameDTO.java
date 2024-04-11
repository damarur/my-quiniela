package es.damarur.myquiniela.model.v1.admin;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import es.damarur.myquiniela.model.v1.admin.AdminTeamDTO;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * AdminGameDTO
 */

@JsonTypeName("Game")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.4.0")
public class AdminGameDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer order;

  private java.time.LocalDateTime dateTime;

  private AdminTeamDTO localTeam;

  private Integer localGoals;

  private AdminTeamDTO visitorTeam;

  private Integer visitorGoals;

  private String result;

  public AdminGameDTO order(Integer order) {
    this.order = order;
    return this;
  }

  /**
   * Get order
   * @return order
  */
  @NotNull 
  @Schema(name = "order", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("order")
  public Integer getOrder() {
    return order;
  }

  public void setOrder(Integer order) {
    this.order = order;
  }

  public AdminGameDTO dateTime(java.time.LocalDateTime dateTime) {
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

  public AdminGameDTO localTeam(AdminTeamDTO localTeam) {
    this.localTeam = localTeam;
    return this;
  }

  /**
   * Get localTeam
   * @return localTeam
  */
  @NotNull @Valid 
  @Schema(name = "local_team", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("local_team")
  public AdminTeamDTO getLocalTeam() {
    return localTeam;
  }

  public void setLocalTeam(AdminTeamDTO localTeam) {
    this.localTeam = localTeam;
  }

  public AdminGameDTO localGoals(Integer localGoals) {
    this.localGoals = localGoals;
    return this;
  }

  /**
   * Get localGoals
   * @return localGoals
  */
  
  @Schema(name = "local_goals", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("local_goals")
  public Integer getLocalGoals() {
    return localGoals;
  }

  public void setLocalGoals(Integer localGoals) {
    this.localGoals = localGoals;
  }

  public AdminGameDTO visitorTeam(AdminTeamDTO visitorTeam) {
    this.visitorTeam = visitorTeam;
    return this;
  }

  /**
   * Get visitorTeam
   * @return visitorTeam
  */
  @NotNull @Valid 
  @Schema(name = "visitor_team", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("visitor_team")
  public AdminTeamDTO getVisitorTeam() {
    return visitorTeam;
  }

  public void setVisitorTeam(AdminTeamDTO visitorTeam) {
    this.visitorTeam = visitorTeam;
  }

  public AdminGameDTO visitorGoals(Integer visitorGoals) {
    this.visitorGoals = visitorGoals;
    return this;
  }

  /**
   * Get visitorGoals
   * @return visitorGoals
  */
  
  @Schema(name = "visitor_goals", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("visitor_goals")
  public Integer getVisitorGoals() {
    return visitorGoals;
  }

  public void setVisitorGoals(Integer visitorGoals) {
    this.visitorGoals = visitorGoals;
  }

  public AdminGameDTO result(String result) {
    this.result = result;
    return this;
  }

  /**
   * Get result
   * @return result
  */
  
  @Schema(name = "result", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("result")
  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdminGameDTO game = (AdminGameDTO) o;
    return Objects.equals(this.order, game.order) &&
        Objects.equals(this.dateTime, game.dateTime) &&
        Objects.equals(this.localTeam, game.localTeam) &&
        Objects.equals(this.localGoals, game.localGoals) &&
        Objects.equals(this.visitorTeam, game.visitorTeam) &&
        Objects.equals(this.visitorGoals, game.visitorGoals) &&
        Objects.equals(this.result, game.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(order, dateTime, localTeam, localGoals, visitorTeam, visitorGoals, result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdminGameDTO {\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
    sb.append("    localTeam: ").append(toIndentedString(localTeam)).append("\n");
    sb.append("    localGoals: ").append(toIndentedString(localGoals)).append("\n");
    sb.append("    visitorTeam: ").append(toIndentedString(visitorTeam)).append("\n");
    sb.append("    visitorGoals: ").append(toIndentedString(visitorGoals)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
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

