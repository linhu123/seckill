package seckill.com.linfix.seckill.dao;

import java.util.Date;
import java.util.List;

import seckill.com.linfix.seckill.entity.Seckill;

public interface SeckillDao {
	/**
	 * 减库存
	 * @param seckillId
	 * @param killTime
	 * @return
	 */
	int reduceNumber(long seckillId,Date killTime);
	
	/**
	 * 根基seckillId 查询seckil
	 * @param seckillId
	 * @return
	 */
	Seckill queryById(long seckillId);
	
	/**
	 * 根据偏移量查询秒杀商品列表
	 * @param offet
	 * @param limit
	 * @return
	 */
	List<Seckill> queryAll(int offet,int limit);
}
