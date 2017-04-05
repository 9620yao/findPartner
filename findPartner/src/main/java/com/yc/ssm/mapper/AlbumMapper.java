package com.yc.ssm.mapper;

import java.util.List;

import com.yc.ssm.entity.Album;

public interface AlbumMapper {

	List<Album> listAlbum(String aaid);

}
