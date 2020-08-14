package co.com.practica.utils;

import co.com.practica.utils.enums.EnumSeparadores;
import java.util.Arrays;
import java.util.List;

public final class Cadenas {

  private Cadenas() {}

  public static String concatenarCadenas(String... cadenas) {
    StringBuilder cadenaConcatenada = new StringBuilder();
    for (Object cadena : cadenas) {
      cadenaConcatenada.append(cadena);
    }
    return cadenaConcatenada.toString().trim();
  }

  public static String concatenarCadenas(EnumSeparadores separador, String... cadenas) {
    StringBuilder cadenaConcatenada = new StringBuilder();
    int indexCadenas = 1;
    int cantidadCadenas = cadenas.length;
    for (Object cadena : cadenas) {
      cadenaConcatenada.append(cadena);
      if (indexCadenas < cantidadCadenas) {
        cadenaConcatenada.append(separador.getSeparador());
        indexCadenas++;
      }
    }
    return cadenaConcatenada.toString().trim();
  }

  public static String concatenarCadenas(EnumSeparadores separador, List<String> lstCadenas) {
    StringBuilder cadenaConcatenada = new StringBuilder();
    for (int indexLista = 0; indexLista < lstCadenas.size(); indexLista++) {
      cadenaConcatenada.append(lstCadenas.get(indexLista));
      if (indexLista < lstCadenas.size() - 1) {
        cadenaConcatenada.append(separador.getSeparador());
      }
    }
    return cadenaConcatenada.toString().trim();
  }

  public static String[] separarCadenas(String cadena, EnumSeparadores enumSeparadores) {
    return Arrays.stream(cadena.split(enumSeparadores.getSeparador()))
        .map(String::trim)
        .toArray(String[]::new);
  }
}
