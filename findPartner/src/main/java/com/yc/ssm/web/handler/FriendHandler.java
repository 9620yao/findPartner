package com.yc.ssm.web.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.ssm.entity.Users;
import com.yc.ssm.service.FriendService;
import com.yc.ssm.service.UsersService;
import com.yc.ssm.util.ServletUtil;

@Controller("friendHandler")
@RequestMapping("friend")
public class FriendHandler {
	@Autowired
	private FriendService friendService;
	@Autowired
	private UsersService userService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	@ResponseBody
	public List<Users> listFriends(HttpSession session) {
		LogManager.getLogger().debug("我进来了 listFriends");
		String aid = (String) session.getAttribute(ServletUtil.USERAID);
		return friendService.listFriends(aid);
	}

	// 查找好友
	@RequestMapping(value = "findFriend", method = RequestMethod.POST)
	@ResponseBody
	public Users findFriendsById(String aid) {
		LogManager.getLogger().debug("我进来了 findFriendsById aid===>" + aid);
		return userService.listUsersInfoByAid(aid);
	}

	// 添加好友
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public boolean insertFriend(String aid, HttpSession session) {
		LogManager.getLogger().debug("我进来了 insertFriend aid===>" + aid);
		String uid = (String) session.getAttribute(ServletUtil.USERAID);
		return friendService.insertFriend(uid, aid);
	}

	// 好友请求
	@RequestMapping(value = "reqAdd", method = RequestMethod.GET)
	@ResponseBody
	public List<Users> friendReq(HttpSession session) {
		LogManager.getLogger().debug("我进来了 friendReq ");
		String aid = (String) session.getAttribute(ServletUtil.USERAID);
		return friendService.listFrienfReq(aid);
	}

	// 系统推荐好友
	@RequestMapping(value = "introFriend", method = RequestMethod.GET)
	@ResponseBody
	public List<Users> listIntroFriend(HttpSession session) {
		LogManager.getLogger().debug("我进来了 listIntroFriend");
		String aid = (String) session.getAttribute(ServletUtil.USERAID);
		return friendService.listIntroFriend(aid);
	}

	@RequestMapping(value = "finalAid", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> FinallyAid(HttpSession session) {
		Map<String, String> map = new HashMap<String, String>();
		LogManager.getLogger().debug("我进来了 FinallyAid()");
		String useraid = (String) session.getAttribute(ServletUtil.USERAID);
		String finalaid = (String) session.getAttribute(ServletUtil.FINALAID);
		LogManager.getLogger().debug("useraid：" + useraid + ",finalaid:" + finalaid);
		if (useraid != null && finalaid != null) {
			if (useraid.intern() == finalaid.intern()) {// 相等说明是用户自己的编号
				map.put("finalaid", "-1");
			}
			if (useraid.intern() != finalaid.intern()) {// 不相等说明是好友编号
				map.put("finalaid", finalaid);
			}
		}
		// useraid或者finalaid为空
		return map;
	}
	//取到请求添加你为好友的人数
	@RequestMapping(value = "reqCount", method = RequestMethod.GET)
	@ResponseBody
	public int reqCount(HttpSession session){
		LogManager.getLogger().debug("我进来了 friendReq ");
		String aid = (String) session.getAttribute(ServletUtil.USERAID);
		return friendService.countReq(aid);
	}

}
