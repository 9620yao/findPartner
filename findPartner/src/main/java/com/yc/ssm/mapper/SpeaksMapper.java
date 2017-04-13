package com.yc.ssm.mapper;

import java.util.Map;

import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Speaks;

public interface SpeaksMapper {

	PaginationBean<Speaks> PbeanSpeaks(Map<String, Object> map);
	PaginationBean<Speaks> showSpeaks(PaginationBean<Speaks> pb);

	// List<Speaks> findSpeaks(String speakman);

	// 增加说说
	int addSpeaks(Speaks speaks);

	Speaks findSpeaks(Map<String, String> map);

	String findSid();

}
