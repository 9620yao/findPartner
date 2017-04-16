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
import com.yc.ssm.entity.Words;
import com.yc.ssm.service.WordsService;
import com.yc.ssm.util.ServletUtil;

@Controller("wordsHandler")
@RequestMapping("words")
public class WordsHandler {
	@Autowired
	private WordsService wordsService;

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

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addWords(Words words, HttpSession session) {
		LogManager.getLogger().debug("我进来了 addWords==>words:" + words);
		String wfrendid = (String) session.getAttribute(ServletUtil.USERAID);
		String waid = (String) session.getAttribute(ServletUtil.FINALAID);
		words.setWfrendid(wfrendid);
		words.setWaid(waid);
		wordsService.add(words);
		return "redirect:/page/message.jsp";
	}

	@RequestMapping(value = "findunclear", method = RequestMethod.POST)
	@ResponseBody
	public List<Words> findByUnclearNames(Words words) {
		words.setWfrendid(words.getWfrendid());
		words.setWdate(words.getWfrendid());
		return wordsService.findWordsInfoByName(words);
	}

}
