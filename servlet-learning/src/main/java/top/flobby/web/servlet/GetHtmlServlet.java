package top.flobby.web.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Flobby
 */
@WebServlet(value = "/getHtml")
public class GetHtmlServlet extends HttpServlet {
    private String message;

    @Override
    public void init() {
        message = "<div>\n" +
                "    <div>\n" +
                "      <h1><span>一、 ES6介绍</span></h1>\n" +
                "      <h2><span>1.ES6的前世今生</span></h2>\n" +
                "      <h3><span>1.1 ECMAScript 和 JavaScript </span></h3>\n" +
                "      <h3><span>1.2 历史进化过程</span></h3>\n" +
                "      <figure>\n" +
                "        <table>\n" +
                "          <thead>\n" +
                "            <tr>\n" +
                "              <th><span>时间</span></th>\n" +
                "              <th><span>版本</span></th>\n" +
                "              <th><span>解释</span></th>\n" +
                "            </tr>\n" +
                "          </thead>\n" +
                "          <tbody>\n" +
                "            <tr>\n" +
                "              <td><span>2009.12</span></td>\n" +
                "              <td><span>ES 5.0</span></td>\n" +
                "              <td><span>ES5正式发布，同时公布了JavaScript.next也就是后来的ES 6.0</span></td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "              <td><span>2011.06</span></td>\n" +
                "              <td><span>ES 5.1</span></td>\n" +
                "              <td><span>ES5.1 版发布，并且成为 ISO 国际标准（ISO/IEC 16262:2011）</span></td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "              <td><span>2013.03</span></td>\n" +
                "              <td><span>ES 6.0</span></td>\n" +
                "              <td><span>ES6草案定稿，不再添加新功能。新的功能设想将被放到 ECMAScript 7。</span></td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "              <td><span>2013.12</span></td>\n" +
                "              <td><span>ES 6.0</span></td>\n" +
                "              <td><span>ES6草案发布，然后是 12 个月的讨论期，听取各方反馈。</span></td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "              <td><span>2015.06</span></td>\n" +
                "              <td><span>ES 6.0</span></td>\n" +
                "              <td><span>ES6 正式通过，成为国际标准。从 2000 年算起，这时已经过去了 15 年。JavaScript.next开始指向ES7.0</span></td>\n" +
                "            </tr>\n" +
                "          </tbody>\n" +
                "        </table>\n" +
                "      </figure>\n" +
                "      <h3><span>1.3 ES6兼容性分析</span></h3>\n" +
                "      <h4><span>横向对比</span></h4>\n" +
                "      <h5><span>（1）桌面端浏览器对ES2015的支持情况</span></h5>\n" +
                "      <ul>\n" +
                "        <li><span>Chrome：51 版起便可以支持 97% 的 ES6 新特性。</span></li>\n" +
                "        <li><span>Firefox：53 版起便可以支持 97% 的 ES6 新特性。</span></li>\n" +
                "        <li><span>Safari：10 版起便可以支持 99% 的 ES6 新特性。</span></li>\n" +
                "        <li><span>IE：Edge 15可以支持 96% 的 ES6 新特性。Edge 14 可以支持 93% 的 ES6 新特性。（IE7~11 基本不支持 ES6）</span></li>\n" +
                "      </ul>\n" +
                "      <h5><span>（2）移动端浏览器对ES2015的支持情况</span></h5>\n" +
                "      <ul>\n" +
                "        <li><span>iOS：10.0 版起便可以支持 99% 的 ES6 新特性。</span></li>\n" +
                "        <li><span>Android：基本不支持 ES6 新特性（5.1 仅支持 25%）</span></li>\n" +
                "      </ul>\n" +
                "      <h5><span>（3）服务器对ES2015的支持情况</span></h5>\n" +
                "      <ul>\n" +
                "        <li><span>Node.js：6.5 版起便可以支持 97% 的 ES6 新特性。（6.0 支持 92%）</span></li>\n" +
                "      </ul>\n" +
                "      <h4><span>纵向对比</span></h4>\n" +
                "      <p><img src=\"https://www.w3cschool.cn/attachments/image/20181128/1543398511477409.png\"\n" +
                "          referrerpolicy=\"no-referrer\" alt=\"img\"></p>\n" +
                "      <p><span>引用地址 </span><a href='https://caniuse.com/#search=es6' target='_blank'\n" +
                "          class='url'>https://caniuse.com/#search=es6</a></p>";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println(message);
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
    }
}