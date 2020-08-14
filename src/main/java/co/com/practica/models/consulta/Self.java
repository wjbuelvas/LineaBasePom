package co.com.practica.models.consulta;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"href"})
@Getter
public class Self implements Serializable {

  @JsonProperty("href")
  public String href;

  private static final long serialVersionUID = -6075596902055016441L;
}
