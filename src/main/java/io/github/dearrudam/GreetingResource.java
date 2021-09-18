package io.github.dearrudam;

import java.io.IOException;
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

@Path("/hello")
public class GreetingResource {
    @GET
    @Produces(MediaType.TEXT_HTML)
    public void hello(
        @Context HttpServletRequest request,
        @Context HttpServletResponse response
        ) throws IOException {

        response.getWriter().write( ""
        + "<html>"
        + "    <body>"
        + "        <h1> Olá " + request.getParameter("nome") + "!</h1>"
        + "    </body>"
        + "</html>");
    }
}