package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "CarritoServlet", urlPatterns = {"/CarritoServlet"})
public class CarritoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //procesamos el nuevo articulo
        String articuloNuevo = request.getParameter("articulo");

        //creamos el objeto http sesion
        HttpSession sesion = request.getSession();

        //recuperamos la lista de articulos existentes, si existen
        List<String> articulos = (List<String>) sesion.getAttribute("articulos");

        if (articulos == null) {
            articulos = new ArrayList<>();
            sesion.setAttribute("articulos", articulos);
        }
        if (articuloNuevo != null && !articuloNuevo.trim().equals("")) {
            articulos.add(articuloNuevo);
        }

        //imprimimos lista de articulos
        PrintWriter salida = response.getWriter();
        salida.println("<h1>Lista de articulos</h1>");
        salida.println("<br/>");

        for (String articulo : articulos) {
            salida.println("<li>" + articulo + "</li>");
        }

        salida.println("<br/>");
        salida.println("<a href='/CarritoCompras'>Regresar al inicio</a>");
        salida.close();

    }

}
