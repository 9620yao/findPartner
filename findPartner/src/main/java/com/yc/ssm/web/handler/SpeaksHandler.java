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
import com.yc.ssm.entity.Speaks;
import com.yc.ssm.service.SpeaksService;
import com.yc.ssm.util.ServletUtil;

@Controller("speaksHandler")
@RequestMapping("speaks")
public class SpeaksHandler {
	@Autowired
	private SpeaksService speaksService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	@ResponseBody
	public List<Speaks> listSpeaks(Users users, HttpSession session) {
		LogManager.getLogger().debug("我进来了 listSpeaks");
		String speakman = (String) session.getAttribute(ServletUtil.USERAID);
		return speaksService.listSpeaks(speakman);
	}

}
