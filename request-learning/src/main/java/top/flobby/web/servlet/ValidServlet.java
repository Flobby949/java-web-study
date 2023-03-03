package top.flobby.web.servlet;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.flobby.web.entity.User;

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
        User user = new User(username, password);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(JSON.toJSONString(user));
        resp.getWriter().close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
