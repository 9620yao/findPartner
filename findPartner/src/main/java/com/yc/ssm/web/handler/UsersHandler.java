package com.yc.ssm.web.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Partner;
import com.yc.ssm.entity.Users;
import com.yc.ssm.service.PartnerService;
import com.yc.ssm.service.UsersService;
import com.yc.ssm.util.ServletUtil;

@Controller("usersHandler")
@RequestMapping("user")
public class UsersHandler {

	@Autowired
	private UsersService usersService;

	@Autowired
	private PartnerService partnerService;

	// 显示个人信息，通过aid取到个人信息
	@RequestMapping(value = "getByid", method = RequestMethod.GET)
	@ResponseBody
	public Users list(HttpSession session) {
		String aid = (String) session.getAttribute(ServletUtil.FINALAID);// 取到用户id
		LogManager.getLogger().debug("ServletUtil.FINALAID==>" + aid);
		return usersService.listUsersInfoByAid(aid);
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String modify(@RequestParam("picData") MultipartFile picData, Users users, HttpSession session) {
		LogManager.getLogger().debug("picData==>" + picData, "user==>" + users);
		if (picData != null && !picData.isEmpty()) {
			String picPath = null;
			try {
				picData.transferTo(ServletUtil.getUploadFile(picData.getOriginalFilename()));
				picPath = ServletUtil.VIRTUAL_UPLOAD_DIR + "/" + picData.getOriginalFilename();
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			users.setPicture(picPath);
			System.out.println("上传图片==》" + users);
		}
		usersService.modifyUserInfo(users);
		return "redirect:/page/lw-index.jsp";
	}

	// 修改密码
	@RequestMapping(value = "mofifyPwd", method = RequestMethod.POST)
	public String modifyPwd(Partner partner, String newPassword, HttpServletRequest request) {
		LogManager.getLogger().debug("partner====>" + partner + "newPassword==>" + newPassword);
		if (partnerService.login(partner) == null) {
			request.setAttribute(ServletUtil.ERROR_MESSAGE, "用户名或密码错误！！！");
			return "/page/lw-modifyPwd.jsp";
		} else {
			partner.setPassword(newPassword);
			partner.setLid(ServletUtil.LOGINING_ID);
			partnerService.updatePwd(partner);
			return "redirect:/page/lw-log.jsp";
		}

	}

	@RequestMapping(value = "mlist", method = RequestMethod.POST)
	@ResponseBody
	public PaginationBean<Users> listUsers(@RequestParam(value = "rows", required = false) String rows,
			@RequestParam(value = "page", required = false) String page) {
		LogManager.getLogger().debug("我进来了listUsers==》 ,rows=" + rows + "，page=" + page);
		return usersService.listUsers(rows, page);
	}
	//后台超管根据aid查询用户信息
	@RequestMapping(value = "find", method = RequestMethod.POST)
	@ResponseBody
	public List<Users> findUsers(String aid){
		LogManager.getLogger().debug("我进来了findUsers==》 ,aid="+aid);
		return usersService.findUsersByAid(aid);
	} 
	
	

	// 显示个人信息，通过aid取到个人信息
	@RequestMapping(value = "aid", method = RequestMethod.POST)
	@ResponseBody
	public Users byAid(String aid,HttpSession session) {
		LogManager.getLogger().debug("我进来byAid()   aid==>" + aid);
		return usersService.listUsersInfoByAid(aid);
	}

}
