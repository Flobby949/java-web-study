package top.flobby.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author : Flobby
 * @program : java-web-study
 * @description :
 * @create : 2023-02-14 16:49
 **/

@WebServlet(value = "/login")
public class ValidServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("aaa") && password.equals("111")) {
            request.getRequestDispatcher("/success.html").forward(request,resp);
        } else {
            resp.sendRedirect("/fail.html");
        }
    }
}
