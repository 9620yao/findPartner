package com.yc.ssm.mapper;

import java.util.List;

import com.yc.ssm.entity.Comments;
import com.yc.ssm.entity.Speaks;

public interface SpeaksMapper {

	List<Speaks> findSpeaks(String speakman);
	
	//增加说说
	int addSpeaks(Speaks speaks);

	List<Comments> listComments(String callid);

}
