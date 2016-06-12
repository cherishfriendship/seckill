package com.xm.dao;

import com.xm.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/applicationContext.xml")
public class SeckillDaoTest {

    @Resource
    private SeckillDao seckillDao;

    @Test
    public void testReduceNumber() throws Exception {
        int updateCount = seckillDao.reduceNumber(1000L, new Date());
        System.out.println("updateCount=" + updateCount);
    }

    @Test
    public void testQueryById() throws Exception {
        Seckill i = seckillDao.queryById(1000);
        System.out.println(i);
    }

    @Test
    public void testQueryAll() throws Exception {
        List<Seckill> list = seckillDao.queryAll(0, 100);
        for (Iterator<Seckill> iterator = list.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }
}