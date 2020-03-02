package cn.lhx;

import static org.junit.Assert.assertTrue;

import cn.lhx.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

//测试时启动spring工厂，并且把当前类加入工程
@RunWith(SpringJUnit4ClassRunner.class)//测试的运行由spring 管理
@ContextConfiguration("classpath:applicationContext_redis.xml")

public class AppTest 
{
    @Autowired
    RedisTemplate<String,Object> template;

    @Resource(name = "redisTemplate")
    private ValueOperations<String,Object>  valueOps;

    @Resource(name = "redisTemplate")
    private SetOperations<String,Object>  setOps;

    @Resource(name = "redisTemplate")
    private ListOperations<String,Object>  listOps;

    @Resource(name = "redisTemplate")
    private ZSetOperations<String,Object>  zsetOps;

    @Resource(name = "redisTemplate")
    private HashOperations<String,String,Object>  hashOps;


    @Test
    public void testRedistemple(){
        //string
        ValueOperations<String, Object> vops = template.opsForValue();
//        vops.set("user:1111",new User(1111,"李某某",new Date()));
      //  valueOps.set("user:1111",new User(1111,"李某某",new Date()));
        User user = (User) vops.get("user:1111");
        System.out.println(user);


    }
    @Test
    public void testRedistempleList(){
//        User user1 = new User(3,"李某人",new Date());
//        User user2 = new User(4,"张某人",new Date());
     //List
        ListOperations<String, Object> listops = template.opsForList();
//        listops.leftPushAll("list2",user1,user2);
        List<Object> list = listops.range("list2", 0, -1);
        for (Object o : list) {
            System.out.println(o);
        }



    }

}
