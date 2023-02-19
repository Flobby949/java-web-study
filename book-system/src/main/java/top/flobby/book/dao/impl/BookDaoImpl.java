package top.flobby.book.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.flobby.book.dao.BookDAO;
import top.flobby.book.model.entity.Book;
import top.flobby.book.util.JdbcUtil;

import java.util.List;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description :
 * @create : 2023-02-18 11:44
 **/

public class BookDaoImpl implements BookDAO {

    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtil.getDataSource());

    @Override
    public List<Book> findAll() {
        String sql = "SELECT * FROM t_book ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public Book getById(Integer id) {
        String sql = "SELECT * FROM t_book WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
    }
}
