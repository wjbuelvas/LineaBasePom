package co.com.practica.utils;

import java.util.Random;

public class Aleatorios {
  private static final Random RANDOM = new Random();

  public static String generarCorreoAleatorio(int cantidadLetras, String tipoCorreo) {
    return generarCaracteresAleatorios(cantidadLetras)
        .concat("@")
        .concat(tipoCorreo)
        .concat(".com");
  }

  public static String generarCaracteresAleatorios(int cantidadLetras) {
    StringBuilder serieLetras = new StringBuilder();
    RANDOM.ints(cantidadLetras, 97, 122).forEach(numero -> serieLetras.append((char) numero));
    return serieLetras.toString();
  }
}
