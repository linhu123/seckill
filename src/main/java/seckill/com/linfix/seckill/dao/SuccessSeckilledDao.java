package seckill.com.linfix.seckill.dao;

import seckill.com.linfix.seckill.entity.Seckill;
import seckill.com.linfix.seckill.entity.SuccessSeckilled;

public interface SuccessSeckilledDao {
	/**
	 * 	插入购买明细，可过滤重复
	 * @param seckillId
	 * @param userPhone
	 * @return
	 */
	int insertSuccessSeckilled(long seckillId,long userPhone);
	
	
	/**
	 * 	根据id查询SuccessSecKilled并携带秒杀产品对象
	 * @return
	 */
	SuccessSeckilled queryByIdWithSeckill();
	
	
	
	
}
