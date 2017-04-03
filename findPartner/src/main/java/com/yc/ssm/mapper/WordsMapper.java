package com.yc.ssm.mapper;

import java.util.List;

import com.yc.ssm.entity.Words;

public interface WordsMapper {
	//查找所有的留言
	List<Words> findWords(Words words);

	//增加留言
	int addWords(Words words);

}
