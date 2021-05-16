package javaEE.cookies;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SetCookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie1 = new Cookie("id", "123");
        Cookie cookie2 = new Cookie("another_id", "777");
        cookie1.setMaxAge(300);
        cookie2.setMaxAge(300);
        response.addCookie(cookie1);
        response.addCookie(cookie2);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
