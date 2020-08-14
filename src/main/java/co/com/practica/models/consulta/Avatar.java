package co.com.practica.models.consulta;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"href"})
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Avatar implements Serializable {

  @JsonProperty("href")
  public String href;

  private static final long serialVersionUID = 8157471343354395423L;
}
