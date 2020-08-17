package co.com.practica.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumVariablesSesion {
  REQUEST_CREAR_USUARIO("Request creacion usuario"),
  RESPONSE_CONSULTA_USUARIO("Response consultaUsuarios"),
  EMAIL("Email"),
  TOKEN_GO_REST("Token de acceso");
  private final String variableSesion;
}
