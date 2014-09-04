package es.insa.curso.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, 
			IOException {
		// 1ºEXTRAER LOS DATOS DE ENTRADA DE REQUEST.
		String op1 = request.getParameter("op1");
		String op2 = request.getParameter("op2");
		String ope = request.getParameter("ope");
		//2ªCONVERTIR LOS DATOS
		double x = Double.valueOf(op1);
		double y = Double.valueOf(op2);
		//3ºDELEGAR LA EJECUCIÓN CONCRETA QUE TOQUE
		double resultado =  calcular(x,y,ope);
		//4ºDEVOLVER LOS RESULTADOS AL USUARIO
			//a) A LO BRUTO : COMO SYSO PERO WEB
		response.getWriter().print("El resultado es " + resultado);
			//b) MEDIANTE UNA PAGINA WEB
		request.setAttribute("r", resultado);
		request.getRequestDispatcher("pagina.jsp")
						.forward(request, response);
			//EL CODIGO QUE PONGAMOS DESPUES DE UN FORWARD
			//NO SIRVE PARA NADA porque yá se ha ido
	}

	private double calcular(double x, double y, String ope) {
		if ("sumar".equals(ope)) {
			return x+y;
		}else if("restar".equals(ope)){
			return x-y;
		}else if ("multiplicar".equals(ope)){
			return x*y;
		}else if ("dividir".equals(ope)){
			return x/y;
		}else {
			return Double.NaN;
		}
	}
}