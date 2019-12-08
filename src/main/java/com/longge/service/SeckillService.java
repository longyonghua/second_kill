package com.longge.service;

import com.longge.domain.Seckill;
import com.longge.dto.Exposer;
import com.longge.dto.SeckillExecution;
import com.longge.exception.RepeatKillException;
import com.longge.exception.SeckillCloseException;
import com.longge.exception.SeckillException;

import java.util.List;

/**
 * @author longge
 * @create 2019-11-27 下午3:40
 */
public interface SeckillService {
    /**
     * 查询所有秒杀记录
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开启时输出秒杀接口地址，否则输出系统时间和秒杀时间
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     * @throws SeckillException
     * @throws RepeatKillException
     * @throws SeckillCloseException
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException, RepeatKillException, SeckillCloseException;

    SeckillExecution executeSeckillByProcedure(long seckillId, long userPhone, String md5);
}
