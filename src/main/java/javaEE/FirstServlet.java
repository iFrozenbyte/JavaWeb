package javaEE;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
ЗАПРОСЫ:
     GET - получить инфу с сервера
     POST - поменять что-то на сервере
Обычно с сервера приходят данные в формате HTML, XML, JSON
Статусы ответа сервера:
    200 (ок)
    3хх (редирект)
    4хх (ошибка клиента)
    5хх (ошибка сервера)
Схема запросов: Клиент -> Сервер -> JAVAcode -> БД
Tomcat (tc) - контейнер сервлетов,позволяющий клиентам обращаться к нашему джава коду
apache tomcat - it's a web server + servlet's container
servlet - это java-программа, работающая на сервере, взаим.с клиентами посредством запрос-ответ
ЖЦ сервлета:
    ЗАПУСК - tc загружает класс сервлета, создает объект класса сервлета, вызывает метод init()
    ОБСЛУЖИВАНИЕ ЗАПРОСОВ - tc получает запрос, определяет какому сервлету запрос предназначен,
передаёт запрос в метод service(). Для каждого запроса создаётся свой поток
    ПРЕКРАЩЕНИЕ РАБОТЫ СЕРВЛЕТА - tc вызывает метод destroy()

JSP ( Java Server Pages ) — это технология Java, которая позволяет создавать
динамические веб-страницы для Java приложений. В HTML-коде можно писать вкрапления джава кода
Способы перенаправления запросов:
    REDIRECT (медленнее) - клиент отправляет серверу запрос, сервер в ответе (статус 301 / 302) указывает заголовок Location (куда перенаправить),
браузер хавает и перенаправляет (совершает новый запрос)
    FORWARD (быстрее) - происходит целиком на сервере, клиент не знает, что его перенаправили.
Сервер берет запрос юзера и сам перенаправляет на другой внутренний адрес (на внеш (гугл, например, нельзя)
 */

@WebServlet(name = "javaEE.FirstServlet")
public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<h1> Hello knowledge </h1>");
        pw.println("<h1> Hello,  </h1>" + name + " " + surname);
        pw.println("</html>");

        // REDIRECT
        //response.sendRedirect("/myFirstJSP.jsp");

        //FORWARD
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/myFirstJSP.jsp");
//        requestDispatcher.forward(request, response);
    }
}
