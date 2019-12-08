package com.longge.service;

import com.longge.domain.Seckill;
import com.longge.dto.Exposer;
import com.longge.dto.SeckillExecution;
import com.longge.exception.RepeatKillException;
import com.longge.exception.SeckillCloseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author longge
 * @create 2019-11-27 下午7:31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SeckillServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}",list);
    }

    @Test
    public void getById() {
        Seckill seckill = seckillService.getById(1000);
        logger.info("seckill={}",seckill);
    }

    @Test
    public void seckillLogic() {
        Exposer exposer = seckillService.exportSeckillUrl(1000);
        if(exposer.isExposed()){
            logger.info("exposer={}",exposer);
            try{
                SeckillExecution execution = seckillService.executeSeckill(1000,18862162388L,exposer.getMd5());
                logger.info("result={}",execution);
            }catch(RepeatKillException e){
                logger.error(e.getMessage());
            }catch(SeckillCloseException e){
                logger.error(e.getMessage());
            }
        }else{
            logger.warn("exposer={}",exposer);
        }
        logger.info("exposer={}",exposer);
    }

}