package com.yc.ssm.web.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public List<Speaks> listSpeaks(Users users, HttpServletRequest request) {
		LogManager.getLogger().debug("我进来了 listSpeaks");
		String speakman = (String) request.getSession().getAttribute(ServletUtil.USERAID);
		return speaksService.listSpeaks(speakman);// 所有的说说
	}
	
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	@ResponseBody
	public boolean insertSpeaks(Speaks speaks,HttpSession session) {
		LogManager.getLogger().debug("insertSpeaks ==要插入一条说说::"+speaks);
		String speakman = (String) session.getAttribute(ServletUtil.USERAID);
		speaks.setSpeakman(speakman);
		return speaksService.add(speaks);
		//return false;
	}
}
