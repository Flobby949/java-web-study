package top.flobby.web.servlet;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.flobby.web.entity.Brand;
import top.flobby.web.service.BrandService;

import java.io.IOException;
import java.util.List;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description :
 * @create : 2023-02-25 11:50
 **/

@WebServlet("/selectAllBrand")
public class SelectBrandServlet extends HttpServlet {

    private final BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Brand> brandList = brandService.selectAll();
        String jsonString = JSON.toJSONString(brandList);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(jsonString);

    }
}
