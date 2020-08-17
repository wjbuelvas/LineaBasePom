package co.com.practica.models.creacion;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "email",
    "gender",
    "status",
    "created_at",
    "updated_at"
})
public class Data implements Serializable {

  @JsonProperty("id")
  public Integer id;
  @JsonProperty("name")
  public String name;
  @JsonProperty("email")
  public String email;
  @JsonProperty("gender")
  public String gender;
  @JsonProperty("status")
  public String status;
  @JsonProperty("created_at")
  public String createdAt;
  @JsonProperty("updated_at")
  public String updatedAt;
  private final static long serialVersionUID = 4485156302499279979L;
}
