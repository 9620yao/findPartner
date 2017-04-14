package com.yc.ssm.web.handler;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.ssm.entity.Homepage;
import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.service.HomepageService;
import com.yc.ssm.util.ServletUtil;

@Controller("homepageHandler")
@RequestMapping("homepage")
public class HomepageHandler {

	@Autowired
	private HomepageService homepageService;

	@RequestMapping("list")
	@ResponseBody
	public PaginationBean<Homepage> list(Integer currPage, HttpSession session) {
		String hpuseid = (String) session.getAttribute(ServletUtil.FINALAID);
		LogManager.getLogger().debug("我是 List<Homepage> 我进来了,hpuseid:" + hpuseid);
		return homepageService.pbHomepage(hpuseid, String.valueOf(currPage), "10");
	}
	
	@RequestMapping("selflist")
	@ResponseBody
	public PaginationBean<Homepage> selflist(Integer currPage, HttpSession session) {
		String hpuseid = (String) session.getAttribute(ServletUtil.FINALAID);
		LogManager.getLogger().debug("我是 List<Homepage> 我进来了,hpuseid:" + hpuseid+",currPage:"+currPage);
		return homepageService.selflist(hpuseid, String.valueOf(currPage), "10");
	}

}
