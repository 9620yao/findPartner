package com.yc.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public boolean insertFriend(String aid, String fid) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("aid", aid);
		map.put("fid", fid);
		return friendMapper.addFriend(map) > 0;
	}

	@Override
	public List<Users> listFrienfReq(String aid) {
		return friendMapper.findFriendReq(aid);
	}

	@Override
	public List<Users> listIntroFriend(String aid) {
		
		return friendMapper.findIntroFriend(aid);
	}

	

	

	

}
