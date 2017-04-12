package com.yc.ssm.service;

import java.util.List;

import com.yc.ssm.entity.Album;

public interface AlbumService {

	List<Album> listAlbum(String aaid);

	boolean addAlbum(Album album);

	Album fpByabid(String abid);// 根据相册编号去该相册

	boolean updateAheader(String abid, String picPath);

	void updateAldate(String abid,String aldate);
}
