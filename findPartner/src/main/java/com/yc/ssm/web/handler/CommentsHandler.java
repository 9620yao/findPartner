package com.yc.ssm.web.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.ssm.entity.Comments;
import com.yc.ssm.service.CommentsService;

@Controller("commentsHandler")
@RequestMapping("comments")
public class CommentsHandler {
	@Autowired
	private CommentsService commentsService;

	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public List<Comments> listComments(String sid, HttpServletRequest request) {
		LogManager.getLogger().debug("我进来了 listComments==== callid:"+sid);
		return commentsService.listComments(sid);// 所有的评论
	}

}
