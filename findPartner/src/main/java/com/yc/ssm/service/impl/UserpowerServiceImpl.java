package com.yc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.ssm.entity.Userpower;
import com.yc.ssm.mapper.UserpowerMapper;
import com.yc.ssm.service.UserpowerService;

@Service("userpowerService")
public class UserpowerServiceImpl implements UserpowerService {

	@Autowired
	private UserpowerMapper userpowerMapper;

	@Override
	public boolean userpower(String faid) {
		List<Userpower> list = userpowerMapper.userpower(faid);
		if (list != null && list.size() > 0) {
			for (Userpower userpower : list) {
				String power = userpower.getUpower();
				if (power != null && power.intern() == "-1") {
					return true;
				}
			}
		}
		return false;
	}

}
