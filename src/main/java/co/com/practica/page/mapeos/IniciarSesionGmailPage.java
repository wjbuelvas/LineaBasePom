package co.com.practica.page.mapeos;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class IniciarSesionGmailPage extends PageObject {

  @FindBy(xpath = "//*[@id=\"identifierId\"]")
  public  WebElementFacade lblCorreo;

  @FindBy(xpath = "//*[@id=\"login_field\"]")
  public  WebElementFacade lblUsuario;

  @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
  public  WebElementFacade lblContrasenia;

  @FindBy(xpath = "//*[@id=\"password\"]")
  public  WebElementFacade lblClave;

  @FindBy(xpath = "//*[@id=\"js-oauth-authorize-btn\"]")
  public  WebElementFacade btnAutorizar;

}
