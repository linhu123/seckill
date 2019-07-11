package seckill.com.linfix.seckill.dto;

import seckill.com.linfix.seckill.entity.SuccessSeckilled;
import seckill.com.linfix.seckill.enums.SeckillStateEnum;

/**
 *	 封装秒杀执行后的结果
 * @author linhu
 *
 */
public class SeckillExecution {
	
	private long seckillId;
	//秒杀结果状态
	private int state;
	
	private String stateInfo;
	
	private SuccessSeckilled successKilled;
	
	public SeckillExecution(long seckillId,SeckillStateEnum state) {
		super();
		this.seckillId = seckillId;
		this.state = state.getState();
		this.stateInfo = state.getStateInfo();
	}

	public SeckillExecution(long seckillId, SeckillStateEnum state, SuccessSeckilled successKilled) {
		super();
		this.seckillId = seckillId;
		this.state = state.getState();
		this.stateInfo = state.getStateInfo();
		this.successKilled = successKilled;
	}

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public SuccessSeckilled getSuccessKilled() {
		return successKilled;
	}

	public void setSuccessKilled(SuccessSeckilled successKilled) {
		this.successKilled = successKilled;
	}
	
}
