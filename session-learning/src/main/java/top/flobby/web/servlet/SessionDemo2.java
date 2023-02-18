package top.flobby.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description : 获取数据
 * @create : 2023-02-18 11:00
 **/

@WebServlet("/demo2")
public class SessionDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        // 打印session，和sessionDemo1相同
        System.out.println(session);
        // 获取数据
        String username = (String) session.getAttribute("username");
        System.out.println(username);
        // 销毁session
        // session.invalidate();
        // System.out.println((String) session.getAttribute("username"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
