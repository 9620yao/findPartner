package com.yc.ssm.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.ssm.entity.Users;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class FriendServiceTest {
	@Autowired
	private FriendService friendService;

	@Test
	public void testListFriends() {
		List<Users> users=friendService.listFriends("10000");
		System.out.println(users);
		assertNotNull(users);
		
	}

}
