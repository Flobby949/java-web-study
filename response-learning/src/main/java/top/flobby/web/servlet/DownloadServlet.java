package top.flobby.web.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description : 下载
 * @create : 2023-02-17 10:53
 **/

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取下载文件名
        String filename = request.getParameter("filename");
        System.out.println(filename);
        // 获取上下文
        ServletContext servletContext = this.getServletContext();
        // 获取下载文件路径
        String realPath = servletContext.getRealPath("/file/" + filename);
        // 获取字节输入流
        FileInputStream fis = new FileInputStream(realPath);
        System.out.println(realPath);
        // 获取下载文件 mime
        String mimeType = servletContext.getMimeType(filename);
        // 设置响应头
        response.setContentType(mimeType);
        response.setHeader("content-disposition", "attachment;filename=" + filename);
        // 预览文件
        // response.sendRedirect(realPath);
        // 下载文件
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1024 * 4];
        int len;
        while ((len = fis.read(buff)) == -1) {
            sos.write(buff, 0, len);
        }
        fis.close();
    }
}
