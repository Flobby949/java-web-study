package top.flobby.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description :
 * @create : 2023-03-04 15:21
 **/

@WebFilter("/*")
public class DemoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // String[] urls = {"login", "index", "/css/"};
        String[] urls = {"login", "index"};
        String url = request.getRequestURL().toString();
        for (String u : urls) {
            if (url.contains(u)) {
                System.out.println("pass:" + url);
                chain.doFilter(servletRequest, response);
            }
        }

        HttpSession session = request.getSession();

        String token = (String) session.getAttribute("token");
        System.out.println(token);
        if (token == null) {
            request.getRequestDispatcher("/login.html").forward(request, response);
        } else {
            chain.doFilter(servletRequest, response);
        }
    }

}
