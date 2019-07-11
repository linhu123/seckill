package seckill.com.linfix.seckill.service;
/**
 * 	业务接口
 * 1.方法定义粒度2.参数3.返回类型
 * @author linhu
 *
 */

import java.util.List;

import seckill.com.linfix.seckill.dto.Exposer;
import seckill.com.linfix.seckill.dto.SeckillExecution;
import seckill.com.linfix.seckill.entity.Seckill;
import seckill.com.linfix.seckill.exception.RepeatSeckillException;
import seckill.com.linfix.seckill.exception.SeckillCloseException;
import seckill.com.linfix.seckill.exception.SeckillException;

public interface SeckillService {
	/**
	 * 	查询所有的秒杀记录	
	 * @return
	 */
	List<Seckill> getSeckillList();
	
	/**
	 * 	得到单个秒杀记录
	 * @param seckillId
	 * @return
	 */
	Seckill	getSeckillById(long seckillId);
	
	/**
	 * 	秒杀开启时，输出秒杀接口地址、
	 * 	否者输出系统时间个秒杀时间
	 * @param seckillId
	 */
	Exposer exportSeckillUrl(long seckillId);
	
	/**
	 * 	执行秒杀服务
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 */
	SeckillExecution executeSeckill(long seckillId,long userPhone,String md5)
	throws RepeatSeckillException,SeckillCloseException,SeckillException;
	
	
	
	
}
