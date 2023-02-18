package top.flobby.book.dao;

import org.junit.jupiter.api.Test;
import top.flobby.book.dao.impl.BookDaoImpl;
import top.flobby.book.model.entity.Book;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookDAOTest {

    BookDAO bookDAO = new BookDaoImpl();

    @Test
    void findAll() {
        List<Book> books = bookDAO.findAll();
        books.forEach(System.out::println);
    }
}