package co.com.practica.models.consulta;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"_meta", "result"})
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ResponseConsultaUsuarios implements Serializable {

  @JsonProperty("_meta")
  public Meta meta;

  @JsonProperty("result")
  public List<Result> result = null;

  private static final long serialVersionUID = -3720659953219682972L;
}
