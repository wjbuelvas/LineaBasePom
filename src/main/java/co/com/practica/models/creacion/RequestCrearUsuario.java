package co.com.practica.models.creacion;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import lombok.Builder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"email", "first_name", "last_name", "gender", "phone", "address"})
@Builder
public class RequestCrearUsuario implements Serializable {

  @JsonProperty("email")
  public String email;

  @JsonProperty("first_name")
  public String firstName;

  @JsonProperty("last_name")
  public String lastName;

  @JsonProperty("gender")
  public String gender;

  @JsonProperty("phone")
  public String phone;

  @JsonProperty("address")
  public String address;

  private static final long serialVersionUID = -5567334945278757519L;
}
