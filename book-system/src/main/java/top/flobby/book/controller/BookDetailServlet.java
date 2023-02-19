package top.flobby.book.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.flobby.book.model.entity.Book;
import top.flobby.book.service.BookService;
import top.flobby.book.service.impl.BookServiceImpl;

import java.io.IOException;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description :
 * @create : 2023-02-19 09:57
 **/

@WebServlet("/detail/*")
public class BookDetailServlet extends HttpServlet {
    private BookService bookService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取uri，获取书本id
        String requestPath = req.getRequestURI().trim();
        String id = requestPath.substring(requestPath.lastIndexOf("/") + 1);
        Book book = bookService.getById(Integer.valueOf(id));
        // 携带参数转发到book_detail
        req.setAttribute("book", book);
        req.getRequestDispatcher("/book_detail.jsp").forward(req, resp);
    }
}
