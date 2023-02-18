package top.flobby.book.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.flobby.book.model.dto.LoginDTO;
import top.flobby.book.model.entity.User;
import top.flobby.book.service.UserService;
import top.flobby.book.service.impl.UserServiceImpl;

import java.io.IOException;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description : 登錄
 * @create : 2023-02-18 12:35
 **/

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setAccount(account);
        loginDTO.setPassword(password);
        UserService userService = new UserServiceImpl();
        User user = userService.userLogin(loginDTO);
        if (user != null) {
            user.setPassword(null);
            request.setAttribute("user", user);
            response.sendRedirect("index.html");
        } else {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().write("""
                        <script>
                            alert("登录失败！");
                            location.href = "/"
                        </script>
                    """);
            response.sendRedirect("login.html");
            response.getWriter().close();
        }
    }
}
