package co.com.practica.models.consulta;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"limit", "remaining", "reset"})
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RateLimit implements Serializable {

  @JsonProperty("limit")
  public Integer limit;

  @JsonProperty("remaining")
  public Integer remaining;

  @JsonProperty("reset")
  public Integer reset;

  private static final long serialVersionUID = -2231054837213055541L;
}
