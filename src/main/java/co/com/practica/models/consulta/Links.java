package co.com.practica.models.consulta;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"self", "edit", "avatar"})
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Links implements Serializable {

  @JsonProperty("self")
  public Self self;

  @JsonProperty("edit")
  public Edit edit;

  @JsonProperty("avatar")
  public Avatar avatar;

  private static final long serialVersionUID = 7184621781871142239L;
}
