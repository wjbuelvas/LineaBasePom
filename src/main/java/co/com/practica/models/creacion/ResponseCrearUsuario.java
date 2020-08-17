package co.com.practica.models.creacion;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "code",
    "meta",
    "data"
})
public class ResponseCrearUsuario implements Serializable {

  @JsonProperty("code")
  public Integer code;
  @JsonProperty("meta")
  public Object meta;
  @JsonProperty("data")
  public Data data;
  private final static long serialVersionUID = -2506884783454109511L;
}
