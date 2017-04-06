package com.yc.ssm.mapper;

import java.util.Map;

import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Speaks;

public interface SpeaksMapper {

	// List<Speaks> findSpeaks(String speakman);

	PaginationBean<Speaks> PbeanSpeaks(Map<String, Object> map);

}
