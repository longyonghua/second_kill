package com.longge.dao;

import com.longge.domain.SuccessKilled;
import org.apache.ibatis.annotations.Param;

/**
 * @author longge
 * @create 2019-11-23 上午11:28
 */
public interface SuccessKilledDao {
    //插入购买明细(可过滤重复)
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
    //根据id查询SuccessKilled（内部含有秒杀产品对象）
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);
}
