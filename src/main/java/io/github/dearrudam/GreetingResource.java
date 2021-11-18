package io.github.dearrudam;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class GreetingResource extends HttpServlet{
    
    @Override
    protected void service(
            HttpServletRequest request,
            HttpServletResponse response) 
        throws ServletException, IOException {
        
        response.addCookie(new Cookie("SESSIONID", UUID.randomUUID().toString()));
        response.getWriter().write( ""
        + "<html>"
        + "    <body>"
        + "        <h1> Hi, " + request.getParameter("user") + "!</h1>"
        + "    </body>"
        + "</html>");
    }
}