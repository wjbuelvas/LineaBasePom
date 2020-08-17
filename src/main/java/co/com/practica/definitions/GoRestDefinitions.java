package co.com.practica.definitions;


import co.com.practica.steps.GoRestSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import java.util.Map;
import net.thucydides.core.annotations.Steps;


public class GoRestDefinitions {

  @Steps
  GoRestSteps goRestSteps;

  @Dado("{string} se loguea para obtener el token de acceso")
  public void obtenerTokenGoRest(String usuario) {
    goRestSteps.iniciarSesionGoRest(usuario.toUpperCase());
    goRestSteps.obtenerToken();
  }

  @Cuando("registre un usuario con los siguientes datos")
  public void registreUnUsuarioConLosSiguientesDatos(Map<String, String> datosUsuario) {
    goRestSteps.crearUsuario(datosUsuario);
  }

  @Entonces("el usuario debe estar registrado en la pagina")
  public void elUsuarioDebeEstarRegistradoEnLaPagina() {
    int codigoUsuario = goRestSteps.getResponseCrearUsuario().getData().getId();
    goRestSteps.consultarUsuario(codigoUsuario);
   // goRestSteps.validarUsuarioCreado();


  }
}
