package com.yc.ssm.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.ssm.mapper.UsersMapper;
import com.yc.ssm.service.UsersService;

@Service("usersService")
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersMapper UsersMapper;
	
	@Override
	public boolean insertUsers(String alid) {
		return UsersMapper.insertUsers(alid)>0;
	}

}
