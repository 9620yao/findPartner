package com.yc.ssm.web.handler;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.ssm.entity.Partner;
import com.yc.ssm.entity.Users;
import com.yc.ssm.service.PartnerService;
import com.yc.ssm.service.UsersService;
import com.yc.ssm.util.RandomNumUtil;
import com.yc.ssm.util.SendMailutil;
import com.yc.ssm.util.ServletUtil;

@Controller("partnerHandler")
@RequestMapping("partner")
public class PartnerHandler {

	@Autowired
	private PartnerService partnerService;

	@Autowired
	private UsersService usersService;

	@RequestMapping("login")
	public String login(Partner partner, HttpServletRequest request) {
		partner = partnerService.login(partner);
		String aid = "";
		LogManager.getLogger().debug("partner====>" + partner);
		if (partner == null) {
			request.setAttribute(ServletUtil.ERROR_MESSAGE, "用户名或密码错误！！！");
			return "/page/lw-log.jsp";
		} else {
			request.getSession().setAttribute(ServletUtil.LOGIN_USER, partner);
			request.getSession().setAttribute(ServletUtil.LOGINING_ID, partner.getLid());
			Users users = usersService.listUsersInfo(partner.getLid());
			if (users != null) {
				// 取到用户id放到session会话里面
				aid = users.getAid();
				request.getSession().setAttribute(ServletUtil.USERAID, aid);
			}
			return "redirect:/page/lw-index.jsp?aid=" + aid;
		}
	}

	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping("sendMail")
	public void sendMail(ModelMap map, String email, PrintWriter out, HttpServletRequest request) {
		LogManager.getLogger().debug(email);
		Integer yzm = RandomNumUtil.getRandomNumber();// 生成六位不重复随机数
		request.getSession().setAttribute("yzm", yzm.toString());
		SendMailutil.activeAccountMail(mailSender, "findPartner注册验证信息", "您的验证码是：" + yzm + ",请认真确认后在是您的操作之后，在执行操作",
				"15675456193@163.com", email);
		out.print(yzm);
		out.flush();
		out.close();
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	@Transactional
	public String add(Partner partner, String uname, String gender, HttpServletRequest request) {// 注册
		LogManager.getLogger().debug("partner:" + partner + "uname:" + uname + "gender:" + gender);
		List<Partner> listmail = partnerService.findEmail(partner);// 判断是否被注册
		if (listmail.size() > 0) {// 返回值大于0
			request.getSession().setAttribute("emailError", "该邮箱已经注册！！！");
			return "/page/lw-re.jsp";
		}
		if (partnerService.register(partner)) {// 注册成功
			List<Partner> listail = partnerService.findEmail(partner);// 取到刚刚注册的lid
			LogManager.getLogger().debug("注册成功后，当前用户：" + listail);
			if (listail != null && listail.size() > 0) { //
				Partner Partner = (Partner) listail.get(0);
				usersService.insertUsers(Partner.getLid());// 初始化users表
			}
			return "redirect:/page/lw-log.jsp";
		}
		return "/page/lw-re.jsp";
	}

	@RequestMapping("sendForgetMail")
	public void sendForgetMail(ModelMap map, Partner partner, PrintWriter out, HttpServletRequest request) {
		LogManager.getLogger().debug(partner);
		Integer yzm = RandomNumUtil.getRandomNumber();// 生成六位不重复随机数
		request.getSession().setAttribute("yzm", yzm.toString());
		SendMailutil.activeAccountMail(mailSender, "findPartner忘记密码验证信息", "您的验证码是：" + yzm + ",请认真确认后在是您的操作之后，在执行操作",
				"15675456193@163.com", partner.getEmail());
		out.print(yzm);
		out.flush();
		out.close();
	}

	@RequestMapping("emailExist")
	@ResponseBody
	public boolean emailExist(String email){
		Partner partner=new Partner();
		partner.setEmail(email);
		List<Partner> listmail = partnerService.findEmail(partner);// 判断是否存在该用户
		if(listmail.size() > 0){
			return true;
		}
		return false;
	}
	
	@RequestMapping(value = "forget", method = RequestMethod.POST)
	public String newPwd(String email) {
		return "redirect:/page/lw-newPwd.jsp?email="+email;
	}
	
	@RequestMapping(value = "newPwd", method = RequestMethod.POST)
	public String newPwd(@RequestParam("newemail")String newemail,@RequestParam("newpwd")String newpwd) {
		LogManager.getLogger().debug("newemail==>"+newemail+"newpwd==>"+newpwd);
		Partner partner=new Partner();
		partner.setEmail(newemail);
		partner.setPassword(newpwd);
		partnerService.updateNewPwd(partner);
		return "/page/lw-log.jsp";
	}
	
	

}
