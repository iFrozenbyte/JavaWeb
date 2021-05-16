package javaEE.cookies;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DelCookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("id", "");
        cookie.setMaxAge(0); // (-1) куки удаляются с закрытием браузера
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
