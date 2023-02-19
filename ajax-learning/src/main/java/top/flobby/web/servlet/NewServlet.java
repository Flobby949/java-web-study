package top.flobby.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.flobby.web.entity.News;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description :
 * @create : 2023-02-18 18:26
 **/

@WebServlet("/news")
public class NewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String type = req.getParameter("type");
        List<News> newsList = new ArrayList<>();
        if ("TIOBE".equals(type)) {
            newsList.add(new News(1, "TIOBE:2023编程语言排行", "2023-01-01", "TIOBE", "..."));
            newsList.add(new News(2, "TIOBE:2023编程语言排行", "2023-01-01", "TIOBE", "..."));
            newsList.add(new News(3, "TIOBE:2023编程语言排行", "2023-01-01", "TIOBE", "..."));
            newsList.add(new News(4, "TIOBE:2023编程语言排行", "2023-01-01", "TIOBE", "..."));
            newsList.add(new News(5, "TIOBE:2023编程语言排行", "2023-01-01", "TIOBE", "..."));
        } else if ("PYPL".equals(type)) {
            newsList.add(new News(1, "PYPL:2023编程语言排行", "2023-01-01", "PYPL", "..."));
            newsList.add(new News(2, "PYPL:2023编程语言排行", "2023-01-01", "PYPL", "..."));
            newsList.add(new News(3, "PYPL:2023编程语言排行", "2023-01-01", "PYPL", "..."));
            newsList.add(new News(4, "PYPL:2023编程语言排行", "2023-01-01", "PYPL", "..."));
            newsList.add(new News(5, "PYPL:2023编程语言排行", "2023-01-01", "PYPL", "..."));
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(newsList);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println(json);
        writer.flush();
        writer.close();
    }
}
