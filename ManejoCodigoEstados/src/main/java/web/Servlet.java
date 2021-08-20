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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String usuarioOk ="Juan";
       String passwordOk = "123";
       
       String usuario = request.getParameter("usuario");
       String password = request.getParameter("password");
       
       PrintWriter salida = response.getWriter();
       
       if(usuarioOk.equals(usuario) && passwordOk.equals(password)){
           salida.println("<h1>");
           salida.println("Datos Correctos");
           salida.println("<br/>Usuario: "+ usuario);
           salida.println("<br/>Password: "+password);
       }
       else{
           response.sendError(response.SC_UNAUTHORIZED,"Las credenciales son incorrectas");
       }
       salida.close();
    }

}
