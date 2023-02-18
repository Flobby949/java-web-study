package top.flobby.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description : URL解码
 * @create : 2023-02-18 10:34
 **/

@WebServlet("/servletD")
public class ServletD extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String msg = (String) req.getAttribute("msg");
        msg = URLDecoder.decode(msg, "utf-8");
        System.out.println(msg);
        resp.setContentType("text/plain;charset=utf-8");
        resp.getWriter().write(msg);
        resp.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
