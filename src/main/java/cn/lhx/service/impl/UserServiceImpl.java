package cn.lhx.service.impl;

import cn.lhx.base.constant.MyConstant;
import cn.lhx.dao.UserDao;
import cn.lhx.entity.User;
import cn.lhx.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lee549
 * @date 2020/2/26 14:26
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<User> selectAllUser() {
        return userDao.selectAllUser();
    }

    @Override
    public void insertUser(User user) {
        String password = new Md5Hash(user.getPassword(), null, MyConstant.ITERCOUNT).toString();
        user.setPassword(password);
        userDao.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User queryByUserName(String username) {
        return userDao.queryByUserName(username);
    }
}
