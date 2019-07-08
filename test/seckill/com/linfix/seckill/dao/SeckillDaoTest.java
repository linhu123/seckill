package seckill.com.linfix.seckill.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import seckill.com.linfix.seckill.entity.Seckill;
/**
 * 配置spring 和 junit整合  junit启动时加载springIOC容器
 * @author linhu
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring 配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
	//注入
	@Autowired
	private SeckillDao seckilldao;
	@Test
	public void testReduceNumber() {
		
	}

	@Test
	public void testQueryById() {
		long id = 1000;
		Seckill seckill = seckilldao.queryById(id);
		System.out.println(seckill);
	}

	@Test
	public void testQueryAll() {

	}

}
