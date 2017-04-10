package com.yc.ssm.web.Fileter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;

import com.yc.ssm.util.ServletUtil;

/**
 *  对所有加载lw-index.jsp进行过滤，
 *  如果取到的取到的好友编号和自己不一致，即显示好友的信息；
 *  如果取到的好友编号和自己一致，即显示自己的信息；
 *  没有取到用户编号，既显示自己的信息
 * @author 姚秋林
 *
 */
@WebFilter("/page/lw-index.jsp")
public class CFriendFilter extends AbstractFilter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		LogManager.getLogger().debug("初始化用户编号过滤器CFriendFilter...");
	}

	@Override
	public void doFilter(ServletRequest requset, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) requset;
		String aid = req.getParameter("aid");
		String usreaid = (String) req.getSession().getAttribute(ServletUtil.USERAID);
		LogManager.getLogger().debug("aid：" + aid+",usreaid:"+usreaid);
		if (aid != null && usreaid != null) {
			// 取到的好友编号和自己不一致，即显示好友的信息
			if (aid.intern() != usreaid.intern()) {
				req.getSession().setAttribute(ServletUtil.FINALAID, aid);
				chain.doFilter(requset, response);
			}
			// 取到的好友编号和自己一致，即显示自己的信息
			if (aid.intern() == usreaid.intern()) {
				req.getSession().setAttribute(ServletUtil.FINALAID, usreaid);
				chain.doFilter(requset, response);
			}
		} else {
			req.getSession().setAttribute(ServletUtil.FINALAID, usreaid);
			chain.doFilter(requset, response);
		}
	}
}
