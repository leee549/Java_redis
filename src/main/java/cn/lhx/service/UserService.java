package cn.lhx.service;

import cn.lhx.entity.User;

import java.util.List;

/**
 * @author lee549
 * @date 2020/2/26 14:26
 */
public interface UserService {
    List<User> selectAllUser();

    void insertUser(User user);

    void updateUser(User user);

    User queryByUserName(String username);
}
