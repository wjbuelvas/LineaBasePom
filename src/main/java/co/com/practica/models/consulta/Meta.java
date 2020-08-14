package co.com.practica.models.consulta;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "success",
  "code",
  "message",
  "totalCount",
  "pageCount",
  "currentPage",
  "perPage",
  "rateLimit"
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Meta implements Serializable {

  @JsonProperty("success")
  public Boolean success;

  @JsonProperty("code")
  public Integer code;

  @JsonProperty("message")
  public String message;

  @JsonProperty("totalCount")
  public Integer totalCount;

  @JsonProperty("pageCount")
  public Integer pageCount;

  @JsonProperty("currentPage")
  public Integer currentPage;

  @JsonProperty("perPage")
  public Integer perPage;

  @JsonProperty("rateLimit")
  public RateLimit rateLimit;

  private static final long serialVersionUID = 4495732847983448973L;
}
