package com.yc.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.ssm.entity.Album;
import com.yc.ssm.mapper.AlbumMapper;
import com.yc.ssm.service.AlbumService;

@Service("albumService")
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	private AlbumMapper albumMapper;

	@Override
	public List<Album> listAlbum(String aaid) {
		return albumMapper.listAlbum(aaid);
	}

	@Override
	public boolean addAlbum(Album album) {
		return albumMapper.addAlbum(album) > 0;
	}

	@Override
	public Album fpByabid(String abid) {
		return albumMapper.fpByabid(abid);
	}

	@Override
	public boolean updateAheader(String abid, String picPath) {
		Map<String,String> map  = new HashMap<String,String>();
		map.put("abid", abid);
		map.put("picPath", picPath);
		return albumMapper.updateAheader(map)>0;
	}

	@Override
	public void updateAldate(String abid,String aldate) {
		Map<String,String> map  = new HashMap<String,String>();
		map.put("abid", abid);
		map.put("aldate", aldate);
		albumMapper.updateAldate(map);
	}

}
