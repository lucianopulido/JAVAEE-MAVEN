/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luciano
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter salida = response.getWriter();
        String metodoHttp = request.getMethod();
        
        salida.println("<html>");
        salida.println("<head>");
        salida.println("<title>Headers HTTP</title>");
        salida.println("</head>");
        salida.println("<body>");
        salida.println("<h1>Headers HTTP </h1>");
        salida.println("<br>");
        
        String url = request.getRequestURI();
        
        salida.println("url solicitada:"+url);
        salida.println("<br>");
        salida.println("Metodo Http:"+metodoHttp);
        salida.println("</body>");
        salida.println("</html>");
        salida.close();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
    }
}
