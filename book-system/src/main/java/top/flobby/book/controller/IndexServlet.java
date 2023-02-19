package top.flobby.book.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.flobby.book.model.entity.Book;
import top.flobby.book.service.BookService;
import top.flobby.book.service.impl.BookServiceImpl;

import java.io.IOException;
import java.util.List;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description : 转发首页
 * @create : 2023-02-19 09:52
 **/

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService bookService = new BookServiceImpl();
        List<Book> bookList = bookService.getAll();
        // 存入request
        req.setAttribute("bookList", bookList);
        // 服务器转发
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
