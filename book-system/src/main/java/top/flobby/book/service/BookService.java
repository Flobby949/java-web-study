package top.flobby.book.service;

import top.flobby.book.model.entity.Book;

import java.util.List;

/**
 * @author : JinChenXing
 * @program : java-web-learning
 * @description :
 * @create : 2023-02-18 13:12
 **/

public interface BookService {
    /**
     * 获取全部书籍
     * @return bookList
     */
    List<Book> getAll();
}
