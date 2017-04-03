package com.yc.ssm.web.Fileter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yc.ssm.entity.Partner;
import com.yc.ssm.util.ServletUtil;

@WebFilter("/user/*")
public class CheckLoginUserFilter extends AbstractFilter {

	@Override
	public void doFilter(ServletRequest requset, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) requset;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession Session = req.getSession();

		Object user = req.getSession().getAttribute(ServletUtil.LOGIN_USER);// loginUser
		if (user == null) {
			if (Session.getAttribute("errorMsg") == null) {
				Session.setAttribute("errorMsg", "请先登录！");
			}
			resp.sendRedirect(req.getServletContext().getContextPath() + "/page/lw-re.jsp");
			return;
		}
		//user不为空的时候取到登录id
		Partner partner = (Partner) user;
		ServletUtil.LOGINING_ID = partner.getLid();// 取到loingid
		chain.doFilter(requset, response);// 继续请求处理
	}

}
