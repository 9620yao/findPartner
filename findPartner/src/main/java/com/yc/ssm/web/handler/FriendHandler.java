package com.yc.ssm.web.handler;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.ssm.entity.Users;
import com.yc.ssm.service.FriendService;
import com.yc.ssm.util.ServletUtil;

@Controller("friendHandler")
@RequestMapping("friend")
public class FriendHandler {
	@Autowired
	private FriendService friendService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	@ResponseBody
	public List<Users> listFriends(HttpSession session) {
		LogManager.getLogger().debug("我进来了 listFriends");
		String aid = (String) session.getAttribute(ServletUtil.USERAID);
		return friendService.listFriends(aid);
	}

}
