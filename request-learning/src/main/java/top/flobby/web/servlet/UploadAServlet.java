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
import java.io.PrintWriter;
import java.util.UUID;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description : 上传文件 前后端分离
 * @create : 2023-02-25 14:02
 **/


@WebServlet("/uploadA")
@MultipartConfig
public class UploadAServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String account = request.getParameter("account");
        System.out.println(account);
        Part part = request.getPart("file");
        // 原⽂件名
        System.out.println(part.getSubmittedFileName());
        String fileName = "";
        if (part.getContentType() != null) {
            // 给⽂件改名
            fileName = UUID.randomUUID() +
                    part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf("."));
            // 获取项⽬部署的绝对路径
            ServletContext context = this.getServletContext();
            // ⽂件上传最终的⽬录/⽂件名
            String realPath = context.getRealPath("upload/" + fileName);
            File newFile = new File(realPath);
            if (!newFile.getParentFile().exists()) {
                newFile.getParentFile().mkdirs();
            }
            // 上传
            part.write(realPath);
        }
        // 把上传图⽚的相对路径返回给客户端
        response.setContentType("image/jpeg");
        PrintWriter out = response.getWriter();
        out.write("./upload/" + fileName);
        // out.write("./upload/83c88b41-b709-4374-820a-691b1a1faf73.jpg");
        out.flush();
        out.close();
    }
}
