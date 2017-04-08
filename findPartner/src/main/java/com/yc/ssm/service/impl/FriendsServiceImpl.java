package com.yc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.ssm.entity.Users;
import com.yc.ssm.mapper.FriendMapper;
import com.yc.ssm.service.FriendService;

@Service("friendService")
public class FriendsServiceImpl implements FriendService {
	@Autowired
	private FriendMapper friendMapper;

	@Override
	public List<Users> listFriends(String aid) {
		return friendMapper.listFriendsInfo(aid);
	}

	

	

}
