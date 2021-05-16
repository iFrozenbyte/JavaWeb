package javaEE;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/*
HTTP - не имеет состояния.
Сессия - это объект на сервере, хранящий инфу о клиенте
Cookies (ключ- значение) - это инфа на браузере клиента, которую он посылает каждый раз при обращении к серверу.
Куки состоит из: ключ/значение, срок действия, к какому домену/сайту относится.
JSESSIONID - с таким названием клиент получает куки
При первом запросе клиента на сервере создаётся сессия и клиенту отправляется COOKIES, они устанавляиваются на браузере.
При всех последующих запросах клиент посылает cookies (пара: ключ/значение). Так идентиф-тся клиент
 */
public class Session extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        Integer count = (Integer) httpSession.getAttribute("count");
        if (count == null) {
            httpSession.setAttribute("count", 1);
            count = 1;
        } else {
            httpSession.setAttribute("count", count + 1);// добавляем к сессии новый атрибут
        }
        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<h1> TEST SESSIONS </h1>");
        pw.println("<h1>Your count is: </h1>" + count);
        pw.println("</html>");
    }
}
