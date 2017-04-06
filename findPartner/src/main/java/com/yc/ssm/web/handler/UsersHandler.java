package com.yc.ssm.web.handler;

import java.io.IOException;

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

	// 显示个人信息，通过logid取到个人信息
	@RequestMapping(value = "getByid", method = RequestMethod.GET)
	@ResponseBody
	public Users list(HttpSession session) {
		Users users = usersService.listUsersInfo(ServletUtil.LOGINING_ID);
		if (users != null) {
			// 取到用户id放到session会话里面
			session.setAttribute(ServletUtil.USERAID, users.getAid());
		}
		return users;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public boolean modify(@RequestParam("picData") MultipartFile picData, Users users, HttpSession session) {
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
		return usersService.modifyUserInfo(users);
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

}
