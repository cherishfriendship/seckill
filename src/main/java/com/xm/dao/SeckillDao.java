package com.xm.dao;

import com.xm.entity.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by xm on 2016/6/9.
 */
public interface SeckillDao {
    /**
     * @param seckillId
     * @param killTime
     * @return 如果影响行数>1，表示更新的记录行数
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询
     * @param offset
     * @param limit
     * @return
     */
    /**
     * 由于java没有保存形参的记录，所以
     * queryAll(int offset, int limit)方法在运行期时会变为
     * queryAll(arg0, arg1)，所以mybatis无法获取到运行期方法的形参参数名，
     * 所以当有多个参数时，使用注解@Param告诉mybatis方法的参数名，当只有一个 参数时可以不用
     * 指定参数名
     *
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
