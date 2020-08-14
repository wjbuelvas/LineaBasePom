package co.com.practica.models;

import static co.com.practica.utils.Aleatorios.generarCorreoAleatorio;
import static co.com.practica.utils.enums.EnumVariablesSesion.EMAIL;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import co.com.practica.models.creacion.RequestCrearUsuario;
import java.util.Map;

public class RequestCrearUsuarioBuilder {


  public static RequestCrearUsuario conLosDatos(Map<String, String> mapDatosUsuario) {
    return RequestCrearUsuario.builder()
        .firstName(mapDatosUsuario.get("Primer nombre"))
        .lastName(mapDatosUsuario.get("Apellido"))
        .gender(mapDatosUsuario.get("Genero"))
        .phone(mapDatosUsuario.get("Telefono"))
        .email(agregarCorreo(mapDatosUsuario))
        .address(mapDatosUsuario.get("Dirección"))
        .build();
  }

  public static String agregarCorreo(Map<String, String> mapDatosUsuario){
    String email= "Random".equalsIgnoreCase(mapDatosUsuario.get("Email")) ? generarCorreoAleatorio(6, "gmail")
        : mapDatosUsuario.get("Email");
    theActorInTheSpotlight().remember(EMAIL.getVariableSesion(),email);
    return email;
  }
}
