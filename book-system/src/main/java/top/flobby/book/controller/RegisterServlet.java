package top.flobby.book.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import top.flobby.book.service.UserService;
import top.flobby.book.service.impl.UserServiceImpl;

import java.io.IOException;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description :
 * @create : 2023-02-19 10:38
 **/

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String verifyCode = req.getParameter("verifyCode");
        HttpSession session = req.getSession();
        String code = (String) session.getAttribute("code");
        resp.setContentType("text/html;charset=utf-8");
        if (!code.equals(verifyCode)) {
            resp.getWriter().write("""
                        <script>
                            location.href = "/register"
                            alert("验证码错误！");
                        </script>
                    """);
        } else {
            int row = userService.register(account, password);
            if (row == 0) {
                resp.getWriter().write("""
                            <script>
                                location.href = "/register"
                                alert("注册失败！");
                            </script>
                        """);
            } else {
                resp.getWriter().write("""
                            <script>
                                alert("注册成功！");
                                location.href = "/"
                            </script>
                        """);
            }

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.html").forward(req, resp);
    }
}
