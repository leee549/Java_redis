package cn.lhx;

import cn.hutool.core.date.DateTime;
import cn.lhx.dao.UserDao;
import cn.lhx.entity.User;
import cn.lhx.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author lee549
 * @date 2020/2/26 13:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class testService {
    @Autowired private UserService userService;

    @Test
    public void testService(){
//        userService.insertUser(new User(null,"admin3","1",true,1l, DateTime.now()));
//        List<User> users = userService.selectAllUser();
//        users.forEach(user-> System.out.println(user));
//        users.forEach(System.out::println);



          User user= userService.queryByUserName("aa");
          System.out.println(user);
    }
}
