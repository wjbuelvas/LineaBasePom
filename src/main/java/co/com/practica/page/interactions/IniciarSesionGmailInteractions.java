package co.com.practica.page.interactions;

import co.com.practica.page.mapeos.IniciarSesionGmailPage;
import co.com.practica.utils.enums.EnumsDatosCuenta;
import net.serenitybdd.core.pages.PageObject;
import org.fluentlenium.core.annotation.Page;

public class IniciarSesionGmailInteractions extends PageObject {

  @Page
  IniciarSesionGmailPage iniciarSesionGmailPage;

  public void ingresarUsuario(String usuario){
    iniciarSesionGmailPage.lblCorreo.typeAndEnter(EnumsDatosCuenta.valueOf(usuario).getUsuario());
    iniciarSesionGmailPage.lblContrasenia.typeAndEnter(EnumsDatosCuenta.valueOf(usuario).getClave());

  }



}
