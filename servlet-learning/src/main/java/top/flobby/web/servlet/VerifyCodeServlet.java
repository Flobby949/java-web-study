package top.flobby.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author : Flobby
 * @program : java-web-study
 * @description :
 * @create : 2023-02-13 20:46
 **/

@WebServlet(value = "/verifyCode")
public class VerifyCodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //验证码输出到页面
        ImageIO.write(createVerifyImage(200,100), "jpg", resp.getOutputStream());
    }

    public BufferedImage createVerifyImage(Integer width, Integer height) {
        // int width = 120;
        // int height = 50;
        //创建一个在内存中存放验证码图片的对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //绘制图片
        //画笔对象
        Graphics g = image.getGraphics();
        g.setColor(Color.PINK);
        g.fillRect(0, 0, width, height);
        //绘制边框
        g.setColor(Color.GRAY);
        g.drawRect(0, 0, width - 1, height - 1);
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        //随机生成下班
        Random random = new Random();
        //四位验证码
        for (int i = 0; i < 4; i++) {
            //nextInt()为左闭右开
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            g.setFont(new Font("宋体", Font.BOLD, 50));
            g.drawString(String.valueOf(ch), width / 5 * i, height -20);
        }
        //绘制干扰线
        g.setColor(Color.BLUE);
        for (int i = 0; i < 20; i++) {
            int x1 = random.nextInt(width - 1);
            int y1 = random.nextInt(height - 1);
            int x2 = random.nextInt(6) + 1;
            int y2 = random.nextInt(12) + 1;
            g.drawLine(x1, y1, x1 + x2 + 20, y1 + y2 + 20);
        }

        for (int i = 0; i < width; i++) {
            g.copyArea(0,i,height,1, random.nextInt(5),0);
        }

        return image;
    }
}
