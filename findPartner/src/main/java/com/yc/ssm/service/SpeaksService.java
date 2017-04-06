package com.yc.ssm.service;

import java.util.List;

import com.yc.ssm.entity.Speaks;

public interface SpeaksService {
	
	List<Speaks> listSpeaks(String speakman);
	
	boolean add(Speaks speaks);

}
