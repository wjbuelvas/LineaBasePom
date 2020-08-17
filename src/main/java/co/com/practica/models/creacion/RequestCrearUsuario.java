package co.com.practica.models.creacion;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
@JsonPropertyOrder({"status", "name", "gender", "email"})
public class RequestCrearUsuario implements Serializable {

  public String status;
  public String name;
  public String gender;
  public String email;

  private static final long serialVersionUID = -5567334945278757519L;

 /* public RequestCrearUsuario(String primer_nombre, String apellido, String genero, String telefono,
      String email, String dirección) {
    this.firstName = primer_nombre;
    this.lastName = apellido;
    this.gender = genero;
    this.phone = telefono;
    this.email = email;
    this.address = dirección;
  }*/
}
