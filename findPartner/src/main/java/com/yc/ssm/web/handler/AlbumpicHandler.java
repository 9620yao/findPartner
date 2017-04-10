package com.yc.ssm.web.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yc.ssm.entity.Album;
import com.yc.ssm.entity.Albumpic;
import com.yc.ssm.service.AlbumService;
import com.yc.ssm.service.AlbumpicService;
import com.yc.ssm.util.ServletUtil;

@Controller("albumpicHandler")
@RequestMapping("albumpic")
public class AlbumpicHandler {

	@Autowired
	private AlbumpicService albumpicService;

	@Autowired
	private AlbumService albumService;

	@RequestMapping("list")
	@ResponseBody
	public List<Albumpic> listAlbumpic(HttpSession session) {
		String abid = (String) session.getAttribute(ServletUtil.ALBUMABID);
		LogManager.getLogger().debug(" listAlbumpic()进来了.....,abid: " + abid);
		return albumpicService.listApic(abid);
	}

	@RequestMapping(value = "newpic", method = RequestMethod.POST)
	@Transactional
	public String newpic(@RequestParam("picData") MultipartFile picData, HttpSession session) {
		String abid = (String) session.getAttribute(ServletUtil.ALBUMABID);
		LogManager.getLogger().debug(" listAlbumpic()进来了.....,abid: " + abid);
		String picPath = null;
		if (picData != null && !picData.isEmpty()) {
			try {
				picData.transferTo(ServletUtil.getUploadFile(picData.getOriginalFilename()));
				picPath = ServletUtil.VIRTUAL_UPLOAD_DIR + "/" + picData.getOriginalFilename();
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			LogManager.getLogger().debug("上传图片==》" + picPath);
			if (albumpicService.newpic(abid, picPath)) {// 添加成功
				Album Album = albumService.fpByabid(abid);//根据用户编号去取该相册
				if (Album != null) {
					String aheader = Album.getAheader();
					if (aheader == null) {// 当刚上传的图片的相册没有头图片的话上传该图片为相册头图片
						albumService.updateAheader(abid,picPath);
					}
				}
				return "redirect:/page/albumpic.jsp?abid=" + abid;
			}
		}
		return "redirect:/page/albumpic.jsp?abid=" + abid;
	}
}
