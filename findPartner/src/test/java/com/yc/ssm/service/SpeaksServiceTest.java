package com.yc.ssm.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.ssm.entity.Comments;
import com.yc.ssm.entity.Speaks;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class SpeaksServiceTest {
	@Autowired
	private SpeaksService speaksService;

	@Test
	public void testListSpeaksInfos() {
		List<Speaks> speaks=speaksService.listSpeaks("10000");
		System.out.println(speaks);
		assertNotNull(speaks);
	}
	
	@Test
	public void testListComments() {
		List<Comments> comments=speaksService.listComments("10020");
		System.out.println(comments);
		assertNotNull(comments);
	}
	public void testAddSpeaks() {
		Speaks speaks=new Speaks();
		speaks.setSid("s10002");
		speaks.setContent("我是用户a28，我发表了一篇说说");
		speaks.setSpeakman("a28");
		speaks.setFiles("");
		speaks.getSenddate();
		//speaks.getSenddate();
		boolean ss=speaksService.add(speaks);
		System.out.println(speaks);
		assertNotNull(speaks);
	}
	

}
