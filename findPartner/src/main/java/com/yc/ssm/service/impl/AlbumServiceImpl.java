package com.yc.ssm.service.impl;

import java.util.List;

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

}
