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
	
	
	/*@Test
	public void testListSpeaks() {
		//取到当前用户下的所有说说
		List<Speaks> listspeacks =  speaksService.listSpeaks("a10056");
		System.out.println(" listspeacks:===》"+listspeacks);
		//取到所有说说的说说编号
		for (Speaks speaks : listspeacks) {
			String listcallid = speaks.getSid();
			System.out.println("listcallid==》"+listcallid);
			//取到该说说编号下的所有评论
			List<Comments> listComments = commentsService.listComments(listcallid);
			for (Comments comments : listComments) {
				//取到评论编号
				String listrcid = comments.getCid();
				System.out.println("listrcid==》"+listrcid);
				//取到评论编号下的所有回复
				List<Replys>listReplys = replysService.listreplys(listrcid);
				System.out.println("listReplys==>"+listReplys);
				for (Replys replys : listReplys) {
					//取到回复编号下面的所有回复
					String listRid = replys.getRid();
					List<Replys> listotherReplys =  replysService.listreplys(listRid);
					System.out.println(listotherReplys);
				}
			}
		}
	}*/

}

/**
 * //mav.addObject("speaks", listSpeaks);
		//request.getSession().setAttribute("speaks",listSpeaks);
		for (Speaks speaks : listSpeaks) {
			String listcallid = speaks.getSid();
			List<Comments> listComments = commentsService.listComments(listcallid);// 所有的评论
			//mav.addObject("comments", listComments);
		//	request.getSession().setAttribute("comments",listComments);
			for (Comments comments : listComments) {
				String listrcid = comments.getCid();
				List<Replys> listReplys = replysService.listreplys(listrcid);// 所有的回复
				//mav.addObject("replys", listReplys);
				//request.getSession().setAttribute("replys",listReplys);
			}
		}
		//mav.setViewName("forward:/page/lw-speaks.jsp");
		//System.out.println(mav);
		 * 
		 * 
		<!-- ModelAndView 循环开始 -->
			<c:forEach var="k" items="${speaks}">
				<article class="am-g blog-entry-article">
					<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-img">
						<!-- <img src="assets/i/f6.jpg" alt="" class="am-u-sm-12"> -->
					</div>
					<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-text">
						<span><a href="" class="blog-color">用户${k.speakman}</a></span> <span>发表时间${k.senddate}</span>
						<h1>
							<a href="">说说内容${k.content}</a>
						</h1>
						<span><a href="" class="blog-color">article &nbsp;</a></span> <span>2015/10/9评论时间</span>
						<p>我们一直在坚持着，不是为了改变这个世界，而是希望不被这个世界所改变。</p>
						<p>
							<a href="" class="blog-continue">continue reading</a>
						</p>
					</div>
				</article>
			</c:forEach>
			<!-- ModelAndView 循环结束  -->
 * 
 * */
