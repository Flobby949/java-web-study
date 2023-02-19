package top.flobby.book.service;

import top.flobby.book.model.dto.LoginDTO;
import top.flobby.book.model.entity.User;

/**
 * @author : JinChenXing
 * @program : java-web-learning
 * @description :
 * @create : 2023-02-17 16:47
 **/

public interface UserService {

    /**
     * 登录
     * @param loginDTO dto
     * @return user
     */
    User userLogin(LoginDTO loginDTO);

    /**
     * 注册
     * @param account account
     * @param password password
     * @return code
     */
    Integer register(String account, String password);

    /**
     * 校验用户名唯一性
     * @param account account
     * @return user
     */
    User validAccount(String account);
}
