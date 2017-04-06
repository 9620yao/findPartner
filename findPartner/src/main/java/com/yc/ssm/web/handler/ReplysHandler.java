package com.yc.ssm.web.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.ssm.entity.Replys;
import com.yc.ssm.service.ReplysService;

@Controller("replysHandler")
@RequestMapping("replys")
public class ReplysHandler {
	@Autowired
	private ReplysService replysService;

	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public List<Replys> listReplys(String cid, HttpServletRequest request) {
		LogManager.getLogger().debug("我进来了 listReplys==== callid:" + cid);
		return replysService.listreplys(cid);// 所有的回复
	}

}
