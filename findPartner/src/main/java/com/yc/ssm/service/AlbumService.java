package com.yc.ssm.service;

import java.util.List;

import com.yc.ssm.entity.Album;
import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Words;

public interface AlbumService {

	List<Album> listAlbum(String aaid);

	boolean addAlbum(Album album);

	Album fpByabid(String abid);// 根据相册编号去该相册

	boolean updateAheader(String abid, String picPath);

	void updateAldate(String abid,String aldate);
	
	PaginationBean<Album> listAllAlbums(String page, String rows);
	
	List<Album> findAlbumInfoByName(Album album);


}
