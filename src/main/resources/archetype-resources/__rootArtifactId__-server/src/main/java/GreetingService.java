#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GreetingService extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");

        resp.getWriter().write("{${symbol_escape}"id${symbol_escape}":${symbol_escape}""+req.getParameter("id")+"${symbol_escape}",${symbol_escape}"name${symbol_escape}":${symbol_escape}""+req.getParameter("name")+"${symbol_escape}"}");
    }
}
