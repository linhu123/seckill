package seckill.com.linfix.seckill.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import seckill.com.linfix.seckill.dao.SeckillDao;
import seckill.com.linfix.seckill.dao.SuccessSeckilledDao;
import seckill.com.linfix.seckill.dto.Exposer;
import seckill.com.linfix.seckill.dto.SeckillExecution;
import seckill.com.linfix.seckill.entity.Seckill;
import seckill.com.linfix.seckill.entity.SuccessSeckilled;
import seckill.com.linfix.seckill.enums.SeckillStateEnum;
import seckill.com.linfix.seckill.exception.RepeatSeckillException;
import seckill.com.linfix.seckill.exception.SeckillCloseException;
import seckill.com.linfix.seckill.exception.SeckillException;
import seckill.com.linfix.seckill.service.SeckillService;
@Service
public class SeckillServiceImpl implements SeckillService {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SeckillDao seckillDao;
	
	@Autowired
	private SuccessSeckilledDao successSeckilledDao;
	
	private final String slat = "asdbsajh12uhxcjkSNjasd1%sgjhag1"; 
	
	public List<Seckill> getSeckillList() {
		return seckillDao.queryAll(0, 4);
	}

	public Seckill getSeckillById(long seckillId) {
		return seckillDao.queryById(seckillId);
	}

	public Exposer exportSeckillUrl(long seckillId) {
		Seckill seckill = seckillDao.queryById(seckillId);
		if(seckill == null) {
			return new Exposer(false, seckillId);
		}
		Date startTime =  seckill.getStarTime();
		Date endTime = seckill.getEndTime();
		//系统当前时间
		Date nowTime = new Date();
		if(nowTime.getTime() < startTime.getTime() ||nowTime.getTime() > endTime.getTime()) {
			return new Exposer(false,seckillId,nowTime.getTime(),startTime.getTime(),endTime.getTime());
		}
		//不可逆
		String md5 = getMd5(seckillId); 
		return new  Exposer(true, md5,seckillId);
		
	}

	private String getMd5(long seckillId) {
		String str = seckillId + "/" + slat;
		String md5 = DigestUtils.md5DigestAsHex(str.getBytes());
		return md5;
	}
	
	@Transactional
	/**
	 * 1.开发团队达成约定，明确标准事务的方法的编程风格
	 * 2.保证事务的实行时间尽可能的短
	 * 3.不要穿插RPC/THHP网络请求
	 */
	public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws RepeatSeckillException, SeckillCloseException, SeckillException {
		if (md5 == null || !md5.equals(getMd5(seckillId))) {
            //秒杀数据被重写了
            throw new SeckillException("seckill data rewrite");
        }
        try {
			//执行秒杀逻辑:减库存+增加购买明细
			Date nowTime = new Date();
			//减库存
			int updateCount =  seckillDao.reduceNumber(seckillId, nowTime);
			if(updateCount<=0) {
				throw new SeckillCloseException("seckill is closed");
			}else {
				//记录购买记录
				int insertCount = successSeckilledDao.insertSuccessSeckilled(seckillId, userPhone);
				if(insertCount<=0) {
					throw new RepeatSeckillException("repeat seckill");
				}else{
					//秒杀成功
					SuccessSeckilled successSeckilled = successSeckilledDao.queryByIdWithSeckill(seckillId,userPhone);
					return new SeckillExecution(seckillId,SeckillStateEnum.SUCCESS, successSeckilled);
				}
			}
		} catch (SeckillCloseException e1) {
			throw e1;
		} catch (RepeatSeckillException e2) {
			throw e2;
		} catch (Exception e) {
			// 将所有编译异常转为运行异常
			throw new SeckillException("Seckill Execption " + e.getMessage());
		}
	}

}
