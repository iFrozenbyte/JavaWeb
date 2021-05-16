package javaEE;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class BooksServlet extends HttpServlet {
    /*
    Для каждого юзера создавать новое подключение к БД и с помощью этого подключения будем забирать из БД весь список книг, который там содержится
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();

        try {
            //перед коннектом к БД загружаем драйвер для postgres
            Class.forName("org.postgresql.Driver");// подключили дроайвер к нашему Java app
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            // Открываем подключение к БД
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "postgres", "");

            // создадим объект statement для создания SQL-запросов к нашей ЬД
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select title from books"); // в переменной resultSet хранится результат селекта
            while (resultSet.next()) {
                pw.println(resultSet.getString("title"));
            }
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
