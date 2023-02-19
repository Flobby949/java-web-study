package top.flobby.book.dao;

import top.flobby.book.model.entity.Book;

import java.util.List;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description :
 * @create : 2023-02-18 11:43
 **/

public interface BookDAO {

    /**
     * 获取全部图书
     * @return list
     */
    List<Book> findAll();

    /**
     * 根据id获取书本
     * @param id id
     * @return book
     */
    Book getById(Integer id);
}
