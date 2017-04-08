package com.yc.ssm.service;

import java.util.List;

import com.yc.ssm.entity.Users;

public interface FriendService {
	List<Users> listFriends(String aid);

}
