package com.yc.ssm.service;


import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Words;

public interface WordsService {

	//List<Words> findWords(Words words);
	
	boolean add(Words words);
	
	PaginationBean<Words> listWords(String waid, String page, String rows);

}
