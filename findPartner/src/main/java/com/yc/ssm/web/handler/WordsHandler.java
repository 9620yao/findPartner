package com.yc.ssm.web.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Speaks;
import com.yc.ssm.entity.Words;
import com.yc.ssm.service.HomepageService;
import com.yc.ssm.service.WordsService;
import com.yc.ssm.util.ServletUtil;

@Controller("wordsHandler")
@RequestMapping("words")
public class WordsHandler {
	@Autowired
	private WordsService wordsService;
	
	@Autowired
	private HomepageService homepageService;

	@RequestMapping("list")
	@ResponseBody
	public PaginationBean<Words> listWords(Integer currPage, String rows, HttpServletRequest request) {
		LogManager.getLogger().debug("我进来了 listWords");
		String waid = (String) request.getSession().getAttribute(ServletUtil.FINALAID);
		return wordsService.listWords(waid, String.valueOf(currPage), "5");
	}

	@RequestMapping(value = "showWords", method = RequestMethod.POST)
	@ResponseBody
	public PaginationBean<Words> showAllWords(String page, String rows) {
		LogManager.getLogger().debug("我进来了 showAllWords==>currPage=" + page);
		return wordsService.listAllWords(page, rows);
	}

	@RequestMapping("addWords")
	public String add(Words words) {
		if (wordsService.add(words)) {
			return "redirect:/page/message.jsp";
		} else {
			return "redirect:/page/lw-index.jsp";
		}
	}
	
	@RequestMapping(value = "addWords", method = RequestMethod.POST)
	public String insertWords(Words words, HttpSession session) {
		LogManager.getLogger().debug("insertWords ==要插入一条留言:" + words);
		String speakman = (String) session.getAttribute(ServletUtil.USERAID);
		words.setWfrendid(speakman);//留言人编号
		
		if (wordsService.add(words)) {// 如果添加说说成功，添加该数据到主业表用
			return "redirect:/page/message.jsp";
		}
		return "redirect:/page/lw-index.jsp";
	}

	@RequestMapping(value = "findunclear", method = RequestMethod.POST)
	@ResponseBody
	public List<Words> findByUnclearNames(Words words) {
		words.setWfrendid(words.getWfrendid());
		words.setWdate(words.getWfrendid());
		return wordsService.findWordsInfoByName(words);
	}

}
