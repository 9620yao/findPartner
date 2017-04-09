package com.yc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.ssm.entity.Albumpic;
import com.yc.ssm.mapper.AlbumpicMapper;
import com.yc.ssm.service.AlbumpicService;

@Service("albumpicService")
public class AlbumpicServiceImpl implements AlbumpicService {

	@Autowired
	private AlbumpicMapper albumpicMapper;

	@Override
	public List<Albumpic> listApic(String abid) {
		return albumpicMapper.listApic(abid);
	}

	@Override
	public boolean newpic(String abid, String picPath) {
		Albumpic albumpic = new Albumpic();
		albumpic.setAbid(abid);
		albumpic.setApic(picPath);
		return albumpicMapper.addpic(albumpic) > 0;
	}

}
