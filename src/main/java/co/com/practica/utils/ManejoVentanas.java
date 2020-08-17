package co.com.practica.utils;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

import java.util.ArrayList;

public class ManejoVentanas {

  private static ArrayList<String> obtenerPestaniasActivas() {
    ArrayList<String> nombresUrl = new ArrayList<>();
    ArrayList<String> pestana = new ArrayList<>(getDriver().getWindowHandles());
    for (String s : pestana) {
      nombresUrl.add(getDriver().switchTo().window(s).getCurrentUrl());
    }
    return nombresUrl;
  }

  public static void cambiarPestaniasActivas(String pagina) {
    ArrayList<String> pestaniasActivas = obtenerPestaniasActivas();
    for (String url : pestaniasActivas) {
      if (url.contains(pagina)) {
        getDriver().navigate().to(url);
      } else {
        Logger.info("CambiarPestañasDinamicas", "La pestaña no se encuentra visible");
      }
    }
  }
}
