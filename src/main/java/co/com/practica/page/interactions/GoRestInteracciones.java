package co.com.practica.page.interactions;

import static co.com.practica.utils.enums.EnumVariablesSesion.TOKEN_GO_REST;

import co.com.practica.page.mapeos.GoRestPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.fluentlenium.core.annotation.Page;

public class GoRestInteracciones extends PageObject {

  @Page
  GoRestPage goRestPage;

  public void seleccionarBotonIniciarSesion() {
    goRestPage.btnLoguin.waitUntilClickable().click();
  }

  public void seleccionarBotonGmail() {
    goRestPage.btnGmail.click();
  }

  public void actualizarToken() {
    goRestPage.btnActualizarToken.click();
  }

  public void obtenerToken() {
    Serenity.setSessionVariable(TOKEN_GO_REST.getVariableSesion())
        .to(goRestPage.lblToken.waitUntilPresent().getText());
  }
}
