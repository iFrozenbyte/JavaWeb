package javaEE.cookies;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class GetCookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookie = request.getCookies();
        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        for (Cookie cookies : cookie){
            pw.println("<h1>" + "cookies.getName() " + cookies.getName() +"</h1>");
            pw.println("<h1>" + "cookies.getValue() " + cookies.getValue() +"</h1>");
        }
        pw.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
