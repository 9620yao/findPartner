package com.yc.ssm.mapper;

import java.util.List;
import java.util.Map;

import com.yc.ssm.entity.Users;

public interface FriendMapper {

	List<Users> listFriendsInfo(String aid);

	int addFriend(Map map);

	List<Users> findFriendReq(String aid);

	List<Users> findIntroFriend(String aid);

}
