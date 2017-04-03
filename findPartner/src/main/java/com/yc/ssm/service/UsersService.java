package com.yc.ssm.service;

import com.yc.ssm.entity.Users;

public interface UsersService {

	boolean insertUsers(String alid);

	Users listUsersInfos(String alid);

	boolean modifyUserInfo(Users users);

}
