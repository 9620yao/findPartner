package com.yc.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.ssm.entity.Users;
import com.yc.ssm.mapper.UsersMapper;
import com.yc.ssm.service.UsersService;

@Service("usersService")
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersMapper UsersMapper;

	@Override
	public boolean insertUsers(String alid) {
		return UsersMapper.insertUsers(alid) > 0;
	}

	@Override
	public boolean modifyUserInfo(Users users) {
		return UsersMapper.updateUserInfo(users) > 0;
	}

	@Override
	public Users listUsersInfo(String alid) {
		return UsersMapper.findUsersInfo(alid);
	}

	@Override
	public Users listUsersInfoByAid(String aid) {
		// TODO Auto-generated method stub
		return UsersMapper.findUsersInfoByAid(aid);
	}

}
