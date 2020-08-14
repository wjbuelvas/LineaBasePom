package co.com.practica.models.consulta;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "id",
  "first_name",
  "last_name",
  "gender",
  "dob",
  "email",
  "phone",
  "website",
  "address",
  "status",
  "_links"
})
@Getter
public class Result implements Serializable {

  @JsonProperty("id")
  public String id;

  @JsonProperty("first_name")
  public String firstName;

  @JsonProperty("last_name")
  public String lastName;

  @JsonProperty("gender")
  public String gender;

  @JsonProperty("dob")
  public String dob;

  @JsonProperty("email")
  public String email;

  @JsonProperty("phone")
  public String phone;

  @JsonProperty("website")
  public String website;

  @JsonProperty("address")
  public String address;

  @JsonProperty("status")
  public String status;

  @JsonProperty("_links")
  public Links links;

  private static final long serialVersionUID = -8546892076737215263L;
}
