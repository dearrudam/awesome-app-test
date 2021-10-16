package io.github.dearrudam;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.plugins.server.servlet.HttpServletResponseWrapper;
import org.jboss.resteasy.spi.HttpRequest;

@WebServlet(urlPatterns = {"/hello"})
public class GreetingResource extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.getWriter().write(""
                + "<html>"
                + "    <body>"
                + "        <h1> Olá " + request.getParameter("nome") + "!</h1>"
                + "    </body>"
                + "</html>");

        response.setHeader("Set-Cookie","TOKEN=12312312321312");

        // to test in Chrome:
        // http://localhost:8080/hello?nome=<ANY NAME><script>setTimeout(()=window.cookieStore.getAll().then(k=>k.forEach(y=>alert(y.value))),2000)</script>

        // to test in Mozila Firefox
        // http://localhost:8080/hello?nome=<ANY NAME><script>setTimeout(()=>alert(document.cookie),2000)</script>
    }
}