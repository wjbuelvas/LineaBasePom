package co.com.practica.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumsUrl {
  GOREST("https://gorest.co.in/"),
  AUTENTICACION_GOOGLE("https://accounts.google.com//");

  private final String url;

}
