package top.flobby.book.service.impl;

import top.flobby.book.dao.BookDAO;
import top.flobby.book.dao.impl.BookDaoImpl;
import top.flobby.book.model.entity.Book;
import top.flobby.book.service.BookService;

import java.util.List;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description :
 * @create : 2023-02-18 13:13
 **/

public class BookServiceImpl implements BookService {

    private final BookDAO bookDAO = new BookDaoImpl();

    @Override
    public List<Book> getAll() {
        return bookDAO.findAll();
    }
}
