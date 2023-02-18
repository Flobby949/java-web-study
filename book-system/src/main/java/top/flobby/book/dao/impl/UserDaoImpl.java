package top.flobby.book.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.flobby.book.dao.UserDAO;
import top.flobby.book.model.entity.User;
import top.flobby.book.util.JdbcUtil;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description :
 * @create : 2023-02-17 15:59
 **/

public class UserDaoImpl implements UserDAO {

    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtil.getDataSource());

    @Override
    public int addUser(User user) {
        String sql = "INSERT INTO t_user (account, password, nickname, avatar, address) VALUES (?, ?, ?, ?, ?) ";
        return jdbcTemplate.update(sql, user.getAccount(), user.getPassword(), user.getNickname(), user.getAvatar(), user.getAddress());
    }

    @Override
    public int deleteUser(Integer id) {
        return 0;
    }

    @Override
    public User findUser(User userDto) {
        String sql = "SELECT * FROM t_user WHERE account = ? AND password = ? ";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), userDto.getAccount(), userDto.getPassword());
        } catch (Exception e) {
            return null;
        }
    }
}
