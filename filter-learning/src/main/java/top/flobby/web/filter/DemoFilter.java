package top.flobby.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description :
 * @create : 2023-03-04 15:21
 **/

@WebFilter("/demo")
public class DemoFilter extends HttpFilter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        String token = (String) session.getAttribute("token");
        System.out.println(token);
        if (token == null) {
            request.getRequestDispatcher("/login.html").forward(request, response);
        }

        chain.doFilter(request, response);
    }


    @Override
    public void destroy() {
        super.destroy();
    }
}
