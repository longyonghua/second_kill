package com.longge.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author longge
 * @create 2019-12-02 下午12:51
 */
public class JedisTest {
    @Test
    public void test1(){
        //获取连接
        Jedis jedis = new Jedis("192.168.30.133",6379);
        //操作
        jedis.set("username","longge");
        //关闭资源
        jedis.close();
    }
}
