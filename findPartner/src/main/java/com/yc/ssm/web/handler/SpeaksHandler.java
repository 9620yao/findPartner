package com.yc.ssm.web.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yc.ssm.entity.Users;
import com.yc.ssm.entity.Comments;
import com.yc.ssm.entity.Replys;
import com.yc.ssm.entity.Speaks;
import com.yc.ssm.service.CommentsService;
import com.yc.ssm.service.ReplysService;
import com.yc.ssm.service.SpeaksService;
import com.yc.ssm.util.ServletUtil;

@Controller("speaksHandler")
@RequestMapping("speaks")
public class SpeaksHandler {
	@Autowired
	private SpeaksService speaksService;

	@Autowired
	private CommentsService commentsService;

	@Autowired
	private ReplysService replysService;

	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView listSpeaks(Users users, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		LogManager.getLogger().debug("我进来了 listSpeaks");
		String speakman = (String) request.getSession().getAttribute(ServletUtil.USERAID);
		List<Speaks> listSpeaks = speaksService.listSpeaks(speakman);// 所有的说说
		mav.addObject("speaks", listSpeaks);
		request.getSession().setAttribute("speaks",listSpeaks);
		for (Speaks speaks : listSpeaks) {
			String listcallid = speaks.getSid();
			List<Comments> listComments = commentsService.listComments(listcallid);// 所有的评论
			mav.addObject("comments", listComments);
			request.getSession().setAttribute("comments",listComments);
			for (Comments comments : listComments) {
				String listrcid = comments.getCid();
				List<Replys> listReplys = replysService.listreplys(listrcid);// 所有的回复
				mav.addObject("replys", listReplys);
				request.getSession().setAttribute("replys",listReplys);
			}
		}
		mav.setViewName("forward:/page/lw-speaks.jsp");
		System.out.println(mav);
		return mav;
	}

}
