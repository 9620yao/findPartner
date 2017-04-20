package com.yc.ssm.web.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.ssm.entity.Users;
import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Speaks;
import com.yc.ssm.service.HomepageService;
import com.yc.ssm.service.SpeaksService;
import com.yc.ssm.util.ServletUtil;

@Controller("speaksHandler")
@RequestMapping("speaks")
public class SpeaksHandler {
	@Autowired
	private SpeaksService speaksService;

	@Autowired
	private HomepageService homepageService;

	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public PaginationBean<Speaks> listSpeaks(Integer currPage, Users users, HttpServletRequest request) {
		LogManager.getLogger().debug("我进来了 listSpeaks==>currPage=" + currPage);
		String speakman = (String) request.getSession().getAttribute(ServletUtil.FINALAID);
		return speaksService.listSpeaks(speakman, String.valueOf(currPage), "5");
	}

	@RequestMapping(value = "showSpeaks", method = RequestMethod.POST)
	@ResponseBody
	public PaginationBean<Speaks> showAllSpeaks(String page, String rows) {
		LogManager.getLogger().debug("我进来了 showAllSpeaks==>currPage=" + page);
		return speaksService.listAllSpeaks(page, rows);
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertSpeaks(Speaks speaks, HttpSession session) {
		LogManager.getLogger().debug("insertSpeaks ==要插入一条说说::" + speaks);
		String speakman = (String) session.getAttribute(ServletUtil.USERAID);
		speaks.setSpeakman(speakman);
		if (speaksService.add(speaks)) {// 如果添加说说成功，添加该数据到主业表用
			String sid = speaksService.findSid();// 取到刚添加说说的说说编号 s10000
			Speaks outspeaks = speaksService.findSpeaks(sid, speakman);// 取到刚刚添加的说说信息
			homepageService.addhompage(outspeaks.getSid(), outspeaks.getSpeakman(), outspeaks.getSenddate());
		}
		return "redirect:/page/lw-speaks.jsp";
	}

	@RequestMapping(value = "hpspeaks", method = RequestMethod.POST)
	@ResponseBody
	public Speaks HomePageSpeaks(String sid, String speakman, HttpServletRequest request) {
		LogManager.getLogger().debug("我进来了 listSpeaks==>sid=" + sid + ",speakman=" + speakman);
		return speaksService.findSpeaks(sid, speakman);
	}

	@RequestMapping(value = "findunclear", method = RequestMethod.POST)
	@ResponseBody
	public List<Speaks> findByUnclearNames(Speaks speaks) {
		speaks.setSenddate(speaks.getSpeakman());
		speaks.setSpeakman(speaks.getSpeakman());
		return speaksService.findSpeaksInfoByName(speaks);
	}

	@RequestMapping(value = "countSpeaks", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> countSpeaks(String speakman) {
		LogManager.getLogger().debug("我进来了countSpeaks：" + speakman);
		return speaksService.countSpeaks(speakman);
	}
	
	@RequestMapping(value = "findunclearing", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> findByUnclearNames(String speakman) {
		return speaksService.countSpeaks(speakman);	
	}

}
