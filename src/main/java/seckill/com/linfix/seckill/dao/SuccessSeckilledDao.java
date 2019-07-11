package seckill.com.linfix.seckill.dao;

import seckill.com.linfix.seckill.entity.Seckill;
import seckill.com.linfix.seckill.entity.SuccessSeckilled;

public interface SuccessSeckilledDao {
	/**
	 * 	���빺����ϸ���ɹ����ظ�
	 * @param seckillId
	 * @param userPhone
	 * @return
	 */
	int insertSuccessSeckilled(long seckillId,long userPhone);
	
	
	/**
	 * 	����id��ѯSuccessSecKilled��Я����ɱ��Ʒ����
	 * @return
	 */
	SuccessSeckilled queryByIdWithSeckill(long seckillId,long userPhone);
	
	
	
	
}
