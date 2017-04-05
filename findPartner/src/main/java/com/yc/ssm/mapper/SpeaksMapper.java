package com.yc.ssm.mapper;

import java.util.List;

import com.yc.ssm.entity.Speaks;

public interface SpeaksMapper {

	List<Speaks> findSpeaks(String speakman);

}
