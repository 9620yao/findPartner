package com.yc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.ssm.entity.Words;
import com.yc.ssm.mapper.WordsMapper;
import com.yc.ssm.service.WordsService;

@Service("wordsService")
public class WordsServiceImpl implements WordsService {
	
	@Autowired
	private WordsMapper wordsMapper;
	
	public void setWordsMapper(WordsMapper wordsMapper) {
		this.wordsMapper = wordsMapper;
	}

	@Override
	public List<Words> findWords(Words words) {
		System.out.println("查询留言");
		return wordsMapper.findWords(words);
	}
	
	@Override
	public boolean add(Words words) {
		System.out.println("增加留言");
		return wordsMapper.addWords(words)>0;
	}

}
