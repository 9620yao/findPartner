package com.yc.ssm.mapper;

import java.util.List;
import java.util.Map;

import com.yc.ssm.entity.Album;

public interface AlbumMapper {

	List<Album> listAlbum(String aaid);

	int addAlbum(Album album);

	Album fpByabid(String abid);

	int updateAheader(Map<String, String> map);

	void updateAldate(Map<String, String> map);
}
