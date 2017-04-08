package com.yc.ssm.mapper;

import java.util.List;

import com.yc.ssm.entity.Users;

public interface FriendMapper {

	List<Users> listFriendsInfo(String aid);

}
