package com.yc.ssm.service;

import java.util.List;

import com.yc.ssm.entity.Words;

public interface WordsService {

	List<Words> findWords(Words words);
	
	boolean add(Words words);

}
