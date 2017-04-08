package com.yc.ssm.web.handler;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.ssm.entity.Albumpic;
import com.yc.ssm.service.AlbumpicService;
import com.yc.ssm.util.ServletUtil;

@Controller("albumpicHandler")
@RequestMapping("albumpic")
public class AlbumpicHandler {

	@Autowired
	private AlbumpicService albumpicService;

	@RequestMapping("list")
	@ResponseBody
	public List<Albumpic> listAlbumpic(HttpSession session) {
		String abid = (String) session.getAttribute(ServletUtil.ALBUMABID);
		LogManager.getLogger().debug(" listAlbumpic()进来了.....,abid: " + abid);
		return albumpicService.listApic(abid);
	}
}
