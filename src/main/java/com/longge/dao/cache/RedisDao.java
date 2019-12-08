package com.longge.dao.cache;

import com.longge.domain.Seckill;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.runtime.RuntimeSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author longge
 * @create 2019-12-02 下午6:53
 */
public class RedisDao {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final JedisPool jedisPool;
    public RedisDao(String ip,int port){
        jedisPool = new JedisPool(ip,port);
    }

    private RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);

    public Seckill getSeckill(long seckillId){
        try {
            Jedis jedis = jedisPool.getResource();
            try{
                String key = "seckill:"+seckillId;
                //采用自定义序列化
                byte[] bytes = jedis.get(key.getBytes());
                if(bytes!=null){
                    Seckill seckill = schema.newMessage(); //未赋值的空对象
                    ProtostuffIOUtil.mergeFrom(bytes,seckill,schema); //将字节数组中的数据赋到空对象中
                    return seckill;
                }
            }finally{
                jedis.close();
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return null;
    }

    public String putSeckill(Seckill seckill){
        try{
            Jedis jedis = jedisPool.getResource();
            try{
                String key = "seckill:"+seckill.getSeckillId();
                byte[] bytes = ProtostuffIOUtil.toByteArray(seckill,schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                int timeout = 60*60; //缓存1小时
                String result = jedis.setex(key.getBytes(), timeout, bytes);
                return result;
            }finally{
                jedis.close();
            }
        }catch(Exception e){
            logger.error(e.getMessage(),e);
        }
        return null;
    }
}
