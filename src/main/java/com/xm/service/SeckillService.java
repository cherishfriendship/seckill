package com.xm.service;

import com.xm.dto.Exposer;
import com.xm.dto.SeckillExecution;
import com.xm.entity.Seckill;
import com.xm.exception.RepeatKillException;
import com.xm.exception.SeckillCloseException;
import com.xm.exception.SeckillException;

import java.util.List;

/**
 * 业务接口：站在使用者的角度设计接口
 * 1、方法定义粒度明确
 * 2、参数越简练越直接
 * 3、返回类型友好（return/抛异常）
 * Created by xm on 2016/6/11.
 */
public interface SeckillService {

    List<Seckill> getSeckillList();

    Seckill getById(long seckillId);

    /**
     * 秒杀开启时输出秒杀接口地址，否则输出系统时间和秒杀时间
     *
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 实行秒杀操作
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException, SeckillCloseException, RepeatKillException;
}
