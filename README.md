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
Las tablas siempre en plural

| URL  | Metodo | Respuesta |
| ------------- | ------------- | ------------- |
| cualquiertabla | GET  | List<Bean>  |
| cualquiertabla/id  | GET  | Bean  |
| cualquiertabla  | POST  | ResponseBean  |
| cualquiertabla  | DELETE  | ResponseBean  |
| cualquiertabla  | PUT  | ResponseBean  |


Enlaces de ayuda
=============
[Doc Session Hibernate](http://docs.jboss.org/hibernate/orm/5.4/javadocs/org/hibernate/Session.html#saveOrUpdate-java.lang.Object-)
[CRUD generico StackOverflow](https://stackoverflow.com/questions/9721383/hibernate-crud-generic-dao)


Postman JSON file
=============
"Pronto"