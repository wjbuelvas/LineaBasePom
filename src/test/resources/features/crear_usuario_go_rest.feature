#language: es
Característica: Yo como Tester
  Quiero iniciar sesión en GoRest y tener acceso al token
  Para probar los servicios POST y GET


  Esquema del escenario: Automatizar el Front y los servicios POST y GET de GoRest
    Dado que René abre la pagina 'GoRest'
    Y 'Wilson' se loguea para obtener el token de acceso
    Cuando registre un usuario con los siguientes datos
      | status        | <status> |
      | Primer nombre | <Nombre> |
      | Genero        | <Genero> |
      | Email         | <Email>  |
    Entonces el usuario debe estar registrado en la pagina
    Ejemplos:
      | Nombre  | Apellido | Genero | Telefono | Email         | Dirección | status |
      | Liliana | Montes   | female | 4536543  | ddd@gmail.com | calle 45B | Active |
