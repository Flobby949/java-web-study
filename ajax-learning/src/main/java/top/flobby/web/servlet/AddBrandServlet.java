package top.flobby.web.servlet;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.flobby.web.entity.Brand;
import top.flobby.web.service.BrandService;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description :
 * @create : 2023-02-25 11:57
 **/

@WebServlet("/newBrand")
public class AddBrandServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 用缓冲流获取请求体数据
        StringBuilder json = new StringBuilder();
        String line;
        BufferedReader br = req.getReader();
        while ((line = br.readLine()) != null) {
            json.append(line);
        }
        // 将json字符转换为java对象
        Brand brand = JSON.parseObject(json.toString(), Brand.class);
        brandService.add(brand);
        resp.getWriter().write("success");
    }
}
