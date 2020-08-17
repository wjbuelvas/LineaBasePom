package co.com.practica.services;

import co.com.practica.models.creacion.RequestCrearUsuario;
import java.util.Map;

public interface IGoRest {

  public RequestCrearUsuario crearUsuario(Map<String, String> datosUsuario);

}
