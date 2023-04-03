package top.flobby.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description :
 * @create : 2023-03-04 15:22
 **/

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("""
                    <!DOCTYPE html>
                    <html lang="en">
                    <head>
                        <meta charset="UTF-8">
                        <title>登录成功</title>
                    </head>
                    <body>
                    <h1>登录成功</h1>
                    </body>
                    </html>
                """);
        resp.getWriter().close();
    }
}
