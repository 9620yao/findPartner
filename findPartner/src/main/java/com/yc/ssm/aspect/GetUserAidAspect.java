/*package com.yc.ssm.aspect;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.yc.ssm.entity.Users;
import com.yc.ssm.util.ServletUtil;

@Component("getUserAidAspect")
@Aspect
public class GetUserAidAspect {
	@Before("execution(* com.yc.ssm.service.impl.UsersServiceImpl.*(..))")
	public void beforeMethodlogin(JoinPoint jpoint, HttpServletRequest request) {
		Users Users = (Users) jpoint.getArgs()[0];
		LogManager.getLogger().debug("放入aid之前" + Users);
		String alid = (String) request.getSession().getAttribute(ServletUtil.LOGINING_ID);
		Users.setAid(alid);
	}

}
*/