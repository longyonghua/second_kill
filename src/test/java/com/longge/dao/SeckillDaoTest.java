package com.longge.dao;

import com.longge.domain.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author longge
 * @create 2019-11-27 下午1:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SeckillDaoTest {
    @Autowired
    private SeckillDao seckillDao;

    @Test
    public void queryById() {
        Seckill seckill = seckillDao.queryById(1000);
        System.out.println(seckill);
    }

    @Test
    public void queryAll() {
        List<Seckill> lists = seckillDao.queryAll(0,100);
        for(Seckill seckill : lists){
            System.out.println(seckill);
        }
    }

    @Test
    public void reduceNumber() {
        int count = seckillDao.reduceNumber(1000L,new Date());
        System.out.println(count);
    }
}