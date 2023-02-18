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
 * @description :
 * @create : 2023-02-18 13:14
 **/

@WebServlet("/bookList")
public class BookListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService bookService = new BookServiceImpl();
        List<Book> bookList = bookService.getAll();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
