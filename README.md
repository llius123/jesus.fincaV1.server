FincaV1 ![alt text](https://raw.githubusercontent.com/llius123/Jesus.FincaV1.Server/master/src/main/resources/icons8-edificio-100.png)
=============
<br />
Servidor de la aplicacion web FincaV1 para la gestión de las facturas de una comunidad de vecinos.
<br />
Creado y mantenido:

[llius123](https://github.com/llius123)

Esquema general de la aplicación.
=============

![](https://raw.githubusercontent.com/llius123/Jesus.FincaV1.Server/master/src/main/resources/Diagrama.png)


CRUD basico
=============
.../fincaV1.server/...

| URL  | Metodo | Respuesta |
| ------------- | ------------- | ------------- |
| cualquiertabla | GET  | List<Bean>  |
| cualquiertabla/id  | GET  | Bean  |
| cualquiertabla  | POST  | ResponseBean  |
| cualquiertabla  | DELETE  | ResponseBean  |
| cualquiertabla  | PUT  | ResponseBean  |

| Tablas  |
| ------------- | 
| incidencias | 
|recibos|
|vecinos|
|facturaproveedores|
|tipovecinos|
|comunidades|
|proveedores|
|tipofacturas|
|poblaciones|
|provincias|


Validaciones
=============
+ Validaciones globales simple(Todo esta con anotaciones de @NotNull)
+ Validaciones de claves externas(No puedes crear registros si las claves externas no existen)
+ Validaciones de fechas. Aceptado el formato string yyyy-MM-dd
+ Nota: Cambiar las validaciones globales a validaciones de Jackson o anotaciones customizadas

Permisos
=============
+ Dependiendo del tipovecino tendras acceso a una parte de la api o a otra
+ 1 = Administrador
+ 2 = Vecino 

Enlaces de ayuda
=============
[Doc Session Hibernate](http://docs.jboss.org/hibernate/orm/5.4/javadocs/org/hibernate/Session.html#saveOrUpdate-java.lang.Object-)
<br />
[CRUD generico StackOverflow](https://stackoverflow.com/questions/9721383/hibernate-crud-generic-dao)

Como ejecutar el servidor
=============
Necesario: Tomcat 
<br />
Cojer el war del proyecto y añadirlo en tomcat/webapps
<br />
Ahora ir a bin y ejecutar catalina.sh y tomcat solo se encarcagara de ejecutar el war
<br />

Postman JSON file
=============
+ En resources hay un archivo con la colecion exportada de POSTMAN.