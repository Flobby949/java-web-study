package top.flobby.book.dao;

import top.flobby.book.model.entity.User;

/**
 * @author : JinChenXing
 * @program : java-web-learning
 * @description :
 * @create : 2023-02-17 15:55
 **/

public interface UserDAO {

    /**
     * 新增用户
     * @param user user
     * @return int
     */
    int addUser(User user);

    /**
     * 删除用户
     * @param id id
     * @return int
     */
    int deleteUser(Integer id);

    /**
     * 根据查询对象查询用户是否存在
     * @param userDto user
     * @return user
     */
    User findUser(User userDto);

    /**
     * 验证user
     * @param user user
     * @return user
     */
    User validUser(User user);
}
