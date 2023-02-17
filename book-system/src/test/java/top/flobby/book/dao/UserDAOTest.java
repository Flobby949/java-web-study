package top.flobby.book.dao;

import org.junit.jupiter.api.Test;
import top.flobby.book.dao.impl.UserDaoImpl;
import top.flobby.book.model.entity.User;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {
    private UserDAO userDAO = new UserDaoImpl();

    @Test
    void addUser() {
        User newUser = User.builder()
                .account("new@qq.com")
                .password("123")
                .nickname("newUser")
                .build();
        int code = userDAO.addUser(newUser);
        System.out.println(code);
    }

    @Test
    void deleteUser() {
    }

    @Test
    void findUser() {
        User user = User.builder()
                .account("new@qq.com")
                .password("123")
                .build();
        System.out.println(userDAO.findUser(user));
    }
}