package cn.lhx;

import redis.clients.jedis.Jedis;

/**
 * @author lee549
 * @date 2020/2/24 10:10
 */
public class TestJedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
       jedis.set("java","java04");
       jedis.lpush("hobby","football","basketball");
        String data = jedis.get("name");
        System.out.println(data);
    }


}
