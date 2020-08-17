package co.com.practica.services;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import java.security.InvalidParameterException;
import java.util.Map;
import net.serenitybdd.rest.SerenityRest;

/**
 * Clase que sirve para crear un cliente REST y consumir servicios de este tipo usando Serenity -
 * RestAssured.
 */
public class ClienteConsumoServicio {

  private final RequestSpecification requestSpecification;

  /**
   * Constructor que sirve para instanciar un cliente REST y posteriormente consumir servicios web
   * de este tipo. Esta instanciación solo se debe usar cuando se utiliza un Hook before donde se
   * configuran las precondiciones básicas en RestAssured (URI Base, Ruta Base y Credenciales)
   * <p>
   * // * @see com.sura.pruebascorevida.definitions.hooks.HookService
   */
  public ClienteConsumoServicio() {
    requestSpecification = SerenityRest.given();
  }


  /**
   * Utilice este método para hacer consumos de tipo POST o PUT con Headers específicos.
   *
   * @param metodoHttp     Tipo de método HTTP para realizar el consumo.
   * @param recurso        corresponde a la ruta donde está alojado el servicio (no se debe incluir
   *                       la ruta base, ni el host, ni el puerto, pues estos datos se envían en la
   *                       instanciación del cliente). Los parámetros de recurso se deben construir
   *                       previamente usando la utilidad construirRecursoServicio().
   * @param encabezados    mapa que contiene los headers específicos que requiere la petición.
   * @param cuerpoPeticion objeto que contiene el request body requerido para realizar la petición.
   * @return objeto con respuesta validable que devolvió el servicio. //  * @see
   * com.sura.pruebascorevida.utils.Utilidad#construirRecursoServicio(Map)
   */
  public ValidatableResponse ejecutarConsumoCuerpo(Method metodoHttp, String recurso,
      Map<String, ?> encabezados, Object cuerpoPeticion) {
    RequestSpecification peticionEspecifica = requestSpecification
        .log().headers()
        .and()
        .log().body()
        .headers(encabezados)
        .body(cuerpoPeticion);
    return realizarPeticion(metodoHttp, recurso, peticionEspecifica).then().log().body();
  }

  /**
   * Utilice este método para hacer consumos de tipo POST o PUT con uri completa.
   *
   * @param metodoHttp     Tipo de método HTTP para realizar el consumo.
   * @param uri            corresponde a la ruta completa del servicio incluyendo la ruta base, el
   *                       host, el puerto (Si aplica) y recurso
   * @param cuerpoPeticion objeto que contiene el request body requerido para realizar la petición.
   * @return objeto con respuesta validable que devolvió el servicio.
   */
  public ValidatableResponse ejecutarConsumoCuerpo(
      Method metodoHttp, String uri, Object cuerpoPeticion, String token) {
    RequestSpecification peticionEspecifica = requestSpecification
        .log().body()
        .contentType(ContentType.JSON)
        .auth().oauth2(token)
        .body(cuerpoPeticion);
    return realizarPeticion(metodoHttp, uri, peticionEspecifica).then().log().body();

  }

  /**
   * Utilice este método para hacer consumos de tipo GET o DELETE.
   *
   * @param metodoHttp Tipo de método HTTP para realizar el consumo.
   * @param recurso    corresponde a la ruta donde está alojado el servicio (no se debe incluir la
   *                   ruta base, ni el host, ni el puerto, pues estos datos se envían en la
   *                   instanciación del cliente). Los parámetros de recurso se deben construir
   *                   previamente usando la utilidad construirRecursoServicio().
   * @return objeto con respuesta validable que devolvió el servicio.
   //* @see com.sura.pruebascorevida.utils.Utilidad#construirRecursoServicio(Map)
   */
  public ValidatableResponse ejecutarConsumoSimple(Method metodoHttp, String recurso) {
    return realizarPeticion(metodoHttp, recurso, requestSpecification).then().log().body();
  }

  /**
   * Utilice este método para hacer consumos de tipo GET o DELETE con parámetros de consulta.
   * <p> Ejemplo: <code>.../recurso?tipoVehiculo=moto&modelo=2010</code> </p>
   *
   * @param metodoHttp         Tipo de método HTTP para realizar el consumo.
   * @param recurso            corresponde a la ruta donde está alojado el servicio (no se debe
   *                           incluir la ruta base, ni el host, ni el puerto, pues estos datos se
   *                           envían en la instanciación del cliente). Los parámetros de recurso se
   *                           deben construir previamente usando la utilidad construirRecursoServicio().
   * @param parametrosConsulta mapa clave/valor que contiene los parametros de consulta para filtrar
   *                           la petición sobre el recurso.
   * @return objeto con respuesta validable que devolvió el servicio.
  // * @see com.sura.pruebascorevida.utils.Utilidad#construirRecursoServicio(Map)
   */
  public ValidatableResponse ejecutarConsumoSimple(Method metodoHttp, String recurso,
      Map<String, ?> parametrosConsulta) {
    RequestSpecification peticion = requestSpecification.queryParams(parametrosConsulta).log()
        .parameters();
    return realizarPeticion(metodoHttp, recurso, peticion).then().log().body();
  }

  public ValidatableResponse ejecutarConsumoSimple(Method metodoHttp, String recurso,
     int parametro, String Token) {
    String recursoCompleto = recurso + parametro;
    RequestSpecification peticion = requestSpecification.log().all();
    return realizarPeticion(metodoHttp, recursoCompleto, peticion).then().log().body();
  }

  private Response realizarPeticion(Method metodoHttp, String recurso,
      RequestSpecification precondicion) {
    Response consumo;
    switch (metodoHttp) {
      case POST:
        consumo = precondicion.when().post(recurso);
        break;
      case PUT:
        consumo = precondicion.when().put(recurso);
        break;
      case GET:
        consumo = precondicion.when().get(recurso);
        break;
      case DELETE:
        consumo = precondicion.when().delete(recurso);
        break;
      default:
        throw new InvalidParameterException("Método HTTP no soportado: " + metodoHttp);
    }
    return consumo;
  }

  /**
   * Utilice este método para hacer consumos de un servicio SOAP.
   *
   * @param urlBase        Es el host o dominio donde se encuentra alojado el servicio (EndPoint)
   * @param recurso        Corresponde a la ruta donde está alojado el servicio (no se debe incluir
   *                       la ruta base, ni el host, ni el puerto, pues estos datos se envían en la
   *                       instanciación del cliente). Los parámetros de recurso se deben construir
   *                       previamente usando la utilidad construirRecursoServicio().
   * @param cuerpoPeticion Objeto que contiene el request body requerido para realizar la petición.
   * @param encabezados    Mapa que contiene los headers específicos que requiere la petición.
   * @return objeto con respuesta validable que devolvió el servicio.
   */
  public ValidatableResponse ejecutarConsumoCuerpoSoap(
      String urlBase, String recurso, Map<String, ?> encabezados, Object cuerpoPeticion) {
    RequestSpecification peticionEspecifica = requestSpecification
        .headers(encabezados)
        .baseUri(urlBase)
        .body(cuerpoPeticion);
    return realizarPeticion(Method.POST, recurso, peticionEspecifica).then().log().body();
  }
}
