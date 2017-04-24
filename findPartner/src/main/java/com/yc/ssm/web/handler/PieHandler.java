/*package com.yc.ssm.web.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.ssm.entity.Users;
import com.yc.ssm.service.FriendService;
import com.yc.ssm.service.PieService;
import com.yc.ssm.service.UsersService;
import com.yc.ssm.util.ServletUtil;

@Controller("pieHandler")
@RequestMapping("pie")
public class PieHandler {
	
	@Autowired
	private PieService pieService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Users> listPie(HttpSession session) {
		LogManager.getLogger().debug("我进来了 listPie");
		return pieService.listPie();
	}


}
*/