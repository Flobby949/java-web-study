package top.flobby.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : Flobby
 * @program : java-web-study
 * @description :
 * @create : 2023-02-13 20:31
 **/

@WebServlet(value = "/getJson")
public class JsonBuildServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("content-type", "application/json");
        PrintWriter out = resp.getWriter();
        out.println("{" +
                        "\"name\":\"金晨星\"," +
                        "\"age\":\"23\"," +
                        "\"gender\":\"男\"" +
                    "}");
    }

}
