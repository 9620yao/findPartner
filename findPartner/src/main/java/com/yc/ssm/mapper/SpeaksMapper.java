package com.yc.ssm.mapper;

import java.util.List;

import com.yc.ssm.entity.Users;
import com.yc.ssm.entity.Partner;
import com.yc.ssm.entity.Speaks;

public interface SpeaksMapper {

	List<Speaks> findSpeaks(String speakman);

}
