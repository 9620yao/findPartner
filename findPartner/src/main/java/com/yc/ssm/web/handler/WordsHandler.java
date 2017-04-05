package com.yc.ssm.web.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yc.ssm.entity.Comments;
import com.yc.ssm.entity.Words;
import com.yc.ssm.service.WordsService;
import com.yc.ssm.util.ServletUtil;

@Controller("wordsHandler")
@RequestMapping("words")
public class WordsHandler {
	@Autowired
	private WordsService wordsService;
	
	@RequestMapping("/findWords")
	public ModelAndView findWords(Words words,HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		List<Words> ws= wordsService.findWords(words);
		modelAndView.addObject("ws",ws);
		modelAndView.setViewName("forward:/page/message.jsp");
		request.getSession().setAttribute("ws",ws);
		if(words==null){
			request.setAttribute(ServletUtil.ERROR_MESSAGE, "没有留言内容");
			//return "redirect:/page/message.jsp";	
		}else{
			//return "redirect:/page/lw-index.jsp";	
		}
		System.out.println(ws);
		return modelAndView;
	}

	
	@RequestMapping("addWords")
	public String add(Words words){
		if(wordsService.add(words)){
			return "redirect:/page/message.jsp";	
		}else{
			return "redirect:/page/lw-index.jsp";	
		}
	}
	
}
