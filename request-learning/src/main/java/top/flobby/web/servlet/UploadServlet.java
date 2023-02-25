package top.flobby.web.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description :
 * @create : 2023-02-25 12:58
 **/

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Part file = req.getPart("file");
        // 获取文件上传字节流
        InputStream inputStream = file.getInputStream();
        // 修改文件名
        String fileName = UUID.randomUUID() + file.getSubmittedFileName().substring(file.getSubmittedFileName().lastIndexOf("."));

        // 路径转换
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("upload/" + fileName);
        // 创建文件和目录
        File newFile = new File(realPath);
        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }
        newFile.createNewFile();

        file.write(realPath);

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("文件上传成功");
        resp.getWriter().close();
    }
}
