package io.github.dearrudam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String hello(
        @QueryParam("nome") final String nome
    ) {
        StringBuilder out = new StringBuilder();
        out.append("<html>");
        out.append("    <body>");
        out.append("        <h1> Olá " + nome + "!</h1>");
//        out.append("        <h1> Olá " + StringEscapeUtils.escapeHtml4(nome) + "!</h1>");
        out.append("    </body>");
        out.append("</html>");
        return out.toString();
    }
}