package co.com.practica.services.impl;

import co.com.practica.models.creacion.RequestCrearUsuario;
import co.com.practica.services.IGoRest;
import java.util.Map;

public class GoRestImpl implements IGoRest {

  @Override
  public RequestCrearUsuario crearUsuario(Map<String, String> datosUsuario){
    return new RequestCrearUsuario(datosUsuario.get("status"), datosUsuario.get("Primer nombre"),
        datosUsuario.get("Genero"), datosUsuario.get("Email"));
  }

}
