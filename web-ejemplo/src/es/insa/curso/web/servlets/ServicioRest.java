package es.insa.curso.web.servlets;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

// ESTO VA A SER UN SERVICIO REST CREADO CON JAX-RS
// PERO JAX-RS DE POR SÍ ES SÓLO UNA INTERFAZ
// JERSEY ES UNA VERSIÓN DE JAX-RS
// PERO   SE CONFIGURA CON ANOTACIONES.
// cambiado
@Path("/")
public class ServicioRest {

	public ServicioRest(){
	}
	/**
	 * http://localhost:8080/web-ejemplo/saludar
	 */
	@GET
	@Path("/saludar")
	public String saludar(@QueryParam("nombre") String nombre){
		return "hola " + nombre;
	}
	
	/**
	 * para escribir en post necesitaríamos un formulario o hacerlo
	 * con ajax en donde le diremos la url donde ir:
	 * http://localhost:8080/web-ejemplo/rest/saludar
	 */
	@POST
	@Path("/adios/{nombre}")
	public String despedirse(@PathParam("nombre") String nombre){
		return "Adios" + nombre;
	}
}
