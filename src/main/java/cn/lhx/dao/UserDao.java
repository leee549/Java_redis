package cn.lhx.dao;

import cn.lhx.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lee549
 * @date 2020/2/25 21:33
 */
public interface UserDao {
    List<User> selectAllUser();

    void insertUser(User user);

    void updateUser(User user);

    /**
     * 获取登录用户名
      * @return
     */
    User queryByUserName(String name);
}
