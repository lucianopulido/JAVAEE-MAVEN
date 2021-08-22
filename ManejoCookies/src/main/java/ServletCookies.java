
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luciano
 */
@WebServlet(urlPatterns = {"/ServletCookies"})
public class ServletCookies extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        // suponemos que el usuario visita por primera vez nuestro sitio web
        boolean nuevoUsuario = true;
        
        // obtenemos el arreglo de cookies
        
        Cookie[] cookies = request.getCookies();
        
        //buscamos si ya existe una cookie
        
        if(cookies != null){
            for(Cookie c : cookies){
                if(c.getName().equals("visitanteRecurrente") && c.getValue().equals("si")){
                    nuevoUsuario = false;
                    break;
                }
            }
        }
        
        String mensaje = null;
        if(nuevoUsuario){
            Cookie visitanteCookie = new Cookie("visitanteRecurrente","si");
            response.addCookie(visitanteCookie);
            mensaje = "Gracias por visitar nuestro sitio por primera vez";
        }
        else{
            mensaje = "Gracias por visitar nuestro sitio nuevamente";
        }
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter salida = response.getWriter();
        salida.println("Mensaje: "+ mensaje);
        salida.close();
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
    }

}
