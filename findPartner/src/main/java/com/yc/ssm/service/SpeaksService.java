package com.yc.ssm.service;

import java.util.List;

import com.yc.ssm.entity.Comments;
import com.yc.ssm.entity.Speaks;

public interface SpeaksService {
	
	List<Speaks> listSpeaks(String speakman);
	
	List<Comments> listComments(String callid);
	
	
	boolean add(Speaks speaks);

}
