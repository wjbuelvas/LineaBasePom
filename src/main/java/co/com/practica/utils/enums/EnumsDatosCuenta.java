package co.com.practica.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumsDatosCuenta {
  WILSON("test2020automation@gmail.com","colombia*11");

  private final String usuario;
  private final String clave;

}
