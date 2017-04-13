package com.yc.ssm.mapper;

import com.yc.ssm.entity.PaginationBean;
import com.yc.ssm.entity.Users;

public interface UsersMapper {

	int insertUsers(String alid);

	Users findUsersInfo(String alid);

	int updateUserInfo(Users users);

	Users findUsersInfoByAid(String aid);
	
	//查询所有用户信息
	//void partUsers(PaginationBean<Users> pb);
	PaginationBean<Users> partUsers(PaginationBean<Users> pb);
}
