package seckill.com.linfix.seckill.dao;

import java.util.Date;
import java.util.List;

import seckill.com.linfix.seckill.entity.Seckill;


public interface SeckillDao {
	/**
	 * �����
	 * @param seckillId
	 * @param killTime
	 * @return
	 */
	int reduceNumber(long seckillId,Date killTime);
	
	/**
	 * ����seckillId ��ѯseckil
	 * @param seckillId
	 * @return
	 */
	Seckill queryById(long seckillId);
	
	/**
	 * ����ƫ������ѯ��ɱ��Ʒ�б�
	 * @param offet
	 * @param limit
	 * @return
	 */
	List<Seckill> queryAll(int offet,int limit);
}
