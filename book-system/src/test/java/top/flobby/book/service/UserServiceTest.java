package top.flobby.book.service;

import org.junit.jupiter.api.Test;
import top.flobby.book.model.entity.User;
import top.flobby.book.service.impl.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    UserService userService = new UserServiceImpl();

    @Test
    void validAccount() {
        User user = userService.validAccount("flobby@qq.com");
        System.out.println(user);
    }
}