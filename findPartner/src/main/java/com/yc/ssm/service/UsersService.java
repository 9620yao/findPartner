package com.yc.ssm.service;

import com.yc.ssm.entity.Users;

public interface UsersService {

	boolean insertUsers(String alid);

	boolean modifyUserInfo(Users users);

	Users listUsersInfo(String alid);

}
