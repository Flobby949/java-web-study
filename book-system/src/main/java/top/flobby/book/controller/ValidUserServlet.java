package top.flobby.book.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.flobby.book.model.entity.User;
import top.flobby.book.service.UserService;
import top.flobby.book.service.impl.UserServiceImpl;

import java.io.IOException;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description :
 * @create : 2023-02-19 11:22
 **/

@WebServlet("/validAccount/*")
public class ValidUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI().trim();
        String account = uri.substring(uri.lastIndexOf("/") + 1);
        UserService userService = new UserServiceImpl();
        User user = userService.validAccount(account);
        if (user != null) {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("false");
        }
    }
}
