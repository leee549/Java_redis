package cn.lhx;

import cn.lhx.dao.UserDao;
import cn.lhx.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * @author lee549
 * @date 2020/2/26 13:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class testDao {
    @Autowired private UserDao userDao;

    @Test
    public void testDao(){
//        userDao.insertUser(new User(null,"admin","1",true,1l, new Date(2017-22-22)));
//        List<User> users = userDao.selectAllUser();
//        users.forEach(user-> System.out.println(user));
//        users.forEach(System.out::println);

    }
}
