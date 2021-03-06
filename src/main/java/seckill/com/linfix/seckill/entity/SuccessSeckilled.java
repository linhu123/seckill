package seckill.com.linfix.seckill.entity;
/**
 * 成功秒杀的实体
 * @author linhu-pc
 *
 */

import java.util.Date;

public class SuccessSeckilled {

	private long seckillId;
	
	private long userPhone;
	
	private short state;
	
	private Date createTime;

	/**
	 *变通
	 * 多对一
	 */
	private Seckill seckill;
	
	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public short getState() {
		return state;
	}

	public void setState(short state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Seckill getSeckill() {
		return seckill;
	}

	public void setSeckill(Seckill seckill) {
		this.seckill = seckill;
	}

	
	
	
}
