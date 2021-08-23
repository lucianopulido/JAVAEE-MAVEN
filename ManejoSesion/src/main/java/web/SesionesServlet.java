package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Luciano
 */
@WebServlet(name = "SesionesServlet", urlPatterns = {"/SesionesServlet"})
public class SesionesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sesion = request.getSession();
        String titulo = null;

        //Pedir el atributo contador visitas al a sesion//
        Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas");

        // si es nulo, es la primera vez que accedo al sitio web
        if (contadorVisitas == null) {
            contadorVisitas = 1;
            titulo = "Bienvenido por primera vez";
        } else {
            contadorVisitas++;
            titulo = "Bienvenido nuevamente";
        }

        //agregamos  el nuevo valor a la sesion
        sesion.setAttribute("contadorVisitas", contadorVisitas);

        //mandamos la respuesta al cliente
        PrintWriter salida = response.getWriter();
        salida.println(titulo);
        salida.println("<br/>");
        salida.println("Numero de accesos al recurso: " + contadorVisitas);
        salida.println("<br/>");
        salida.println("Id de la sesion: " + sesion.getId());
        salida.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
