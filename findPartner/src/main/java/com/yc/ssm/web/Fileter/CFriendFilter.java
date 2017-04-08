package com.yc.ssm.web.Fileter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;

import com.yc.ssm.util.ServletUtil;

@WebFilter("/page/lw-index.jsp")
public class CFriendFilter extends AbstractFilter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		LogManager.getLogger().debug("初始化验证码filter...");
	}

	/**
	 * 验证码验证
	 * 
	 */
	@Override
	public void doFilter(ServletRequest requset, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest  req = (HttpServletRequest) requset;
		String aid = req.getParameter("aid");
		LogManager.getLogger().debug("aid："+aid);
		req.getSession().setAttribute(ServletUtil.FRIENDAID, aid);
		chain.doFilter(requset, response);
	}

}
