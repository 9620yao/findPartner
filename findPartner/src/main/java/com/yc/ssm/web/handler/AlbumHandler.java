package com.yc.ssm.web.handler;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.ssm.entity.Album;
import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.service.AlbumService;
import com.yc.ssm.util.ServletUtil;

@Controller("albumHandler")
@RequestMapping("album")
public class AlbumHandler {

	@Autowired
	private AlbumService albumService;

	@RequestMapping("list")
	@ResponseBody
	public List<Album> list(HttpSession session) {
		String aaid = (String) session.getAttribute(ServletUtil.FINALAID);
		LogManager.getLogger().debug("我是Album list() 我进来了");
		return albumService.listAlbum(aaid);
	}

	@RequestMapping("newimgs")
	public String NewImgs(Album Album, HttpSession session) {
		String aaid = (String) session.getAttribute(ServletUtil.FINALAID);
		LogManager.getLogger().debug("我是Album list() 我进来了 aaid:" + aaid);
		Album.setAaid(aaid);
		if (albumService.addAlbum(Album)) {
			return "redirect:/page/lw-img.jsp";
		}
		return "redirect:/page/lw-img.jsp";
	}

	@RequestMapping(value = "showAlbums", method = RequestMethod.POST)
	@ResponseBody
	public PaginationBean<Album> showAllAlbums(String page, String rows) {
		LogManager.getLogger().debug("我进来了 showAllAlbums==>currPage=" + page);
		return albumService.listAllAlbums(page, rows);
	}

	@RequestMapping(value = "findunclear", method = RequestMethod.POST)
	@ResponseBody
	public List<Album> findByUnclearNames(Album album) {
		album.setAaid(album.getAaid());
		album.setAldate(album.getAaid());
		return albumService.findAlbumInfoByName(album);
	}

}
