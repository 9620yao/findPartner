package com.yc.ssm.web.handler;

import java.io.IOException;

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
import com.yc.ssm.service.UsersService;
import com.yc.ssm.util.ServletUtil;

@Controller("UsersHandler")
@RequestMapping("user")
public class UsersHandler {

	@Autowired
	private UsersService usersService;

	//显示个人信息，通过logid取到个人信息
	@RequestMapping(value = "getByid", method = RequestMethod.GET)
	@ResponseBody
	public Users list(Partner partner, HttpSession session) {
		LogManager.getLogger().debug("  list()进来了===》partner："+partner);
		String alid = (String) session.getAttribute(ServletUtil.LOGINING_ID);
		Users users = usersService.listUsersInfos(alid);
		return users;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public boolean modify(@RequestParam("picData") MultipartFile picData, Users users, HttpSession session) {
		String aid = (String) session.getAttribute(ServletUtil.USER_INFO);
		users.setAid(aid);
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

}
