package top.flobby.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.flobby.web.entity.Channel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description :
 * @create : 2023-02-18 18:47
 **/

@WebServlet("/channel")
public class ChannelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String level = req.getParameter("level");
        String parent = req.getParameter("parent");
        List<Channel> channels = new ArrayList<>();
        if ("1".equals(level)) {
            channels.add(new Channel("ai", "人工智能"));
            channels.add(new Channel("web", "前端开发"));
        } else if ("2".equals(level)) {
            if ("web".equals(parent)) {
                channels.add(new Channel("html", "超文本标记语言"));
                channels.add(new Channel("css", "级联样式表"));
                channels.add(new Channel("js", "JavaScript语言"));
            } else if ("ai".equals(parent)) {
                channels.add(new Channel("dl", "深度学习"));
                channels.add(new Channel("cv", "计算机视觉"));
                channels.add(new Channel("nlp", "自然语言处理"));
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(channels);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println(json);
        writer.flush();
        writer.close();
    }
}
