package seckill.com.linfix.seckill.entity;

import java.util.Date;

public class Seckill {
	
	private long seckillId;
	
	private String name;
	
	private int number;
	
	private Date starTime;
	
	private Date endTime;

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getStarTime() {
		return starTime;
	}

	public void setStarTime(Date starTime) {
		this.starTime = starTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Seckill [seckillId=" + seckillId + ", name=" + name + ", number=" + number + ", starTime=" + starTime
				+ ", endTime=" + endTime + "]";
	}
	
	
	
}
