package co.com.practica.steps;

import static co.com.practica.utils.enums.EnumVariablesSesion.TOKEN_GO_REST;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

import co.com.practica.models.creacion.RequestCrearUsuario;
import co.com.practica.models.creacion.ResponseCrearUsuario;
import co.com.practica.page.interactions.GoRestInteracciones;
import co.com.practica.page.interactions.IniciarSesionGmailInteractions;
import co.com.practica.services.ClienteConsumoServicio;
import co.com.practica.services.impl.GoRestImpl;
import io.restassured.http.Method;
import io.restassured.response.ValidatableResponse;
import java.util.Map;
import lombok.Getter;
import net.serenitybdd.core.Serenity;
import org.fluentlenium.core.annotation.Page;

public class GoRestSteps {

  @Page
  GoRestInteracciones goRestInteracciones;

  @Page
  IniciarSesionGmailInteractions iniciarSesionGmailInteractions;

  @Getter
  private ResponseCrearUsuario responseCrearUsuario;
  private ValidatableResponse response;
  private ClienteConsumoServicio clienteConsumoServicio = new ClienteConsumoServicio();
  private GoRestImpl goRest = new GoRestImpl();


  public void iniciarSesionGoRest(String usuario) {
    goRestInteracciones.seleccionarBotonIniciarSesion();
    goRestInteracciones.seleccionarBotonGmail();
    iniciarSesionGmailInteractions.ingresarUsuario(usuario);
  }

  public void obtenerToken() {
    goRestInteracciones.actualizarToken();
    getDriver().switchTo().alert().accept();
    goRestInteracciones.obtenerToken();

  }

  public void crearUsuario(Map<String, String> datosUsuario) {
    response = clienteConsumoServicio
        .ejecutarConsumoCuerpo(Method.POST, "http://gorest.co.in/public-api/users",
            goRest.crearUsuario(datosUsuario),
            Serenity.sessionVariableCalled(TOKEN_GO_REST.getVariableSesion()));
    responseCrearUsuario = response.extract().as(ResponseCrearUsuario.class);

  }

  public void consultarUsuario(int codigoUsuario) {
    response = clienteConsumoServicio
        .ejecutarConsumoSimple(Method.GET, "http://gorest.co.in/public-api/users", codigoUsuario,
            Serenity.sessionVariableCalled(TOKEN_GO_REST.getVariableSesion()));
    responseCrearUsuario = response.extract().as(ResponseCrearUsuario.class);
  }
}
