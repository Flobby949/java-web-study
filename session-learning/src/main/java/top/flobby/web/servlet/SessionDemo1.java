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
 * @description : 获取session对象，存储数据
 * @create : 2023-02-18 10:56
 **/

@WebServlet("/demo1")
public class SessionDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String info = "flobby";
        // 获取session对象
        HttpSession session = req.getSession();
        // 打印session
        System.out.println(session);
        // 存储数据
        session.setAttribute("username", info);
        resp.getWriter().write(info);
        resp.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
