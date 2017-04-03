package com.yc.ssm.web.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yc.ssm.entity.Users;
import com.yc.ssm.entity.Partner;
import com.yc.ssm.entity.Speaks;
import com.yc.ssm.service.PartnerService;
import com.yc.ssm.service.SpeaksService;
import com.yc.ssm.util.ServletUtil;

@Controller("speaksHandler")
@RequestMapping("speaks")
public class SpeaksHandler {
	@Autowired
	private SpeaksService speaksService;

	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public List<Speaks> listSpeaks(Users users, HttpSession session) {
		String speakman=(String) session.getAttribute(ServletUtil.USER_INFO);
		return speaksService.listSpeaks(speakman);
	}

	

}
