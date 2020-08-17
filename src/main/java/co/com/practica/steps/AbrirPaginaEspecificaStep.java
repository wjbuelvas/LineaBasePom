package co.com.practica.steps;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

import co.com.practica.utils.enums.EnumsUrl;

public class AbrirPaginaEspecificaStep {

  public void abrirPagina(String urlPagina) {
    getDriver().navigate().to(EnumsUrl.valueOf(urlPagina).getUrl());
  }

}
