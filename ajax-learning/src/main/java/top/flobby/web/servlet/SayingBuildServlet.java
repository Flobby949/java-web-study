package top.flobby.web.servlet;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description :
 * @create : 2023-02-19 12:23
 **/

@WebServlet("/saying")
public class SayingBuildServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = getResource("https://api.thecatapi.com/v1/images/search?size=full", "url", true);
        String content = getResource("https://api.chucknorris.io/jokes/random", "value", false);
        Map<String, String> resultMap = new HashMap<>(3);
        resultMap.put("url", url);
        resultMap.put("content", content);
        if (url != null && content != null) {
            // 成功
            resultMap.put("code", "0");
        } else {
            // 失败
            resultMap.put("code", "404");
        }
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(JSON.toJSONString(resultMap));
        resp.getWriter().close();
    }

    public static String getResource(String url, String key, boolean isList) {
        HttpURLConnection con = null;
        try {
            URL httpUrl = new URL(url);
            con = (HttpURLConnection) httpUrl.openConnection();
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36");
            int code = con.getResponseCode();
            if (HttpURLConnection.HTTP_OK == code) {
                InputStream inputStream = con.getInputStream();
                BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                StringBuilder resultBuffer = new StringBuilder();
                String line;
                while ((line = buffer.readLine()) != null) {
                    resultBuffer.append(line);
                }
                if (isList) {
                    return (String) JSON.parseArray(resultBuffer.toString()).getJSONObject(0).get(key);
                } else {
                    return (String) JSON.parseObject(resultBuffer.toString()).get(key);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
