package co.com.practica.definitions;

import co.com.practica.steps.AbrirPaginaEspecificaStep;
import io.cucumber.java.es.Dado;
import net.thucydides.core.annotations.Steps;

public class GeneralesDefinitions {

  @Steps
  AbrirPaginaEspecificaStep abrirPaginaEspecificaStep;

  @Dado("que René abre la pagina {string}")
  public void queRenéAbreLaPagina(String nombrePagina) {
    abrirPaginaEspecificaStep.abrirPagina(nombrePagina.toUpperCase());
  }

}
