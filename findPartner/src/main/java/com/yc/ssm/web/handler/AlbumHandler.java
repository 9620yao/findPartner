package com.yc.ssm.web.handler;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.ssm.entity.Album;
import com.yc.ssm.service.AlbumService;
import com.yc.ssm.util.ServletUtil;

@Controller("albumHandler")
@RequestMapping("album")
public class AlbumHandler {

	@Autowired
	private AlbumService albumService;
	
	@RequestMapping("list")
	@ResponseBody
	public List<Album> list(HttpSession session){
		String aaid = (String) session.getAttribute(ServletUtil.USERAID);
		LogManager.getLogger().debug("我是Album list() 我进来了");
		return albumService.listAlbum(aaid);
	}

}
