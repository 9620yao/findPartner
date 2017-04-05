package com.yc.ssm.web.handler;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.ssm.entity.Comments;
import com.yc.ssm.entity.Replys;
import com.yc.ssm.entity.Speaks;
import com.yc.ssm.service.CommentsService;
import com.yc.ssm.service.ReplysService;
import com.yc.ssm.service.SpeaksService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class SpeaksHandlerTest {

	@Autowired
	private SpeaksService speaksService;
	
	@Autowired
	private CommentsService commentsService;
	
	@Autowired
	private ReplysService replysService;
	
	
	@Test
	public void testListSpeaks() {
		List<Speaks> listspeacks =  speaksService.listSpeaks("a10056");
		System.out.println(" listspeacks:===》"+listspeacks);
		for (Speaks speaks : listspeacks) {
			String listcallid = speaks.getSid();
			System.out.println("listcallid==》"+listcallid);
			List<Comments> listComments = commentsService.listComments(listcallid);
			for (Comments comments : listComments) {
				String listrcid = comments.getCid();
				System.out.println("listrcid==》"+listrcid);
				List<Replys>listReplys = replysService.listreplys(listrcid);
				System.out.println("listReplys==>"+listReplys);
			}
		}
	}

}
