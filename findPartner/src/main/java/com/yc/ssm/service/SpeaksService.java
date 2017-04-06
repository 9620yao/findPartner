package com.yc.ssm.service;

import java.util.List;

import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Speaks;

public interface SpeaksService {

	//List<Speaks> listSpeaks(String speakman);

	PaginationBean<Speaks> listSpeaks(String speakman,String page, String rows);
}
