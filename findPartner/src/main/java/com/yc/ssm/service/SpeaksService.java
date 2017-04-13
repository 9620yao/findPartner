package com.yc.ssm.service;

import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Speaks;

public interface SpeaksService {

	boolean add(Speaks speaks);

	// List<Speaks> listSpeaks(String speakman);

	PaginationBean<Speaks> listSpeaks(String speakman, String page, String rows);

	PaginationBean<Speaks> listAllSpeaks(String page, String rows);
}
