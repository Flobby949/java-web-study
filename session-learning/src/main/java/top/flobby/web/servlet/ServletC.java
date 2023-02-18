package top.flobby.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description : URL编码
 * @create : 2023-02-18 10:32
 **/

@WebServlet("/servletC")
public class ServletC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = "你好！";
        value = URLEncoder.encode(value, "utf-8");
        System.out.println(value);
        req.setAttribute("msg", value);
        req.getRequestDispatcher("servletD").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
