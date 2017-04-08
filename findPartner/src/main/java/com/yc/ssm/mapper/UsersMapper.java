package com.yc.ssm.mapper;

import com.yc.ssm.entity.Users;

public interface UsersMapper {

	int insertUsers(String alid);

	Users findUsersInfo(String alid);

	int updateUserInfo(Users users);

	Users findUsersInfoByAid(String aid);
	
}
