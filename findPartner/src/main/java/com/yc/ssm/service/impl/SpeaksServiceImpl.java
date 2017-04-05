package com.yc.ssm.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.ssm.entity.Speaks;
import com.yc.ssm.mapper.SpeaksMapper;
import com.yc.ssm.service.SpeaksService;
@Service("speaksService")
public class SpeaksServiceImpl implements SpeaksService {
	@Autowired
	private SpeaksMapper speaksMapper;

	@Override
	public List<Speaks> listSpeaks(String speakman) {
		return speaksMapper.findSpeaks(speakman);
	}
	
	

}
