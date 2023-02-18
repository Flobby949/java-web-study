package top.flobby.book.service.impl;

import top.flobby.book.dao.UserDAO;
import top.flobby.book.dao.impl.UserDaoImpl;
import top.flobby.book.model.dto.LoginDTO;
import top.flobby.book.model.entity.User;
import top.flobby.book.service.UserService;
import top.flobby.book.util.Md5Util;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description :
 * @create : 2023-02-17 16:47
 **/

public class UserServiceImpl implements UserService {

    private final UserDAO userDAO = new UserDaoImpl();

    @Override
    public User userLogin(LoginDTO loginDTO) {
        User user = User.builder()
                .account(loginDTO.getAccount())
                .password(Md5Util.encode(loginDTO.getPassword(), "utf-8"))
                .build();
        return userDAO.findUser(user);
    }
}
