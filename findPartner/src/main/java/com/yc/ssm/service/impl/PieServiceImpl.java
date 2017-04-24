/*package com.yc.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.yc.ssm.entity.Users;
import com.yc.ssm.mapper.PieMapper;
import com.yc.ssm.service.PieService;

public class PieServiceImpl implements PieService{

	@Autowired
	private  PieMapper  pieMapper;
	@Override
	public Map<String,Users> listPie() {

		List<Users> users= pieMapper.listPie();
		if(users==null || users.size()==0){
			return null;
		}

		int total=users.size();

		int henan=0;
		int hunan=0;
		int anhui=0;
		int hubei=0;
		int other=0;

		for(Users user:users){
			if(user.getAddress().equalsIgnoreCase("河南省")){
				henan++;
			}else if(user.getAddress().equalsIgnoreCase("湖南省")){
				hunan++;
			}else if(user.getAddress().equalsIgnoreCase("安徽省")){
				anhui++;
			}else if(user.getAddress().equalsIgnoreCase("湖北省")){
				hubei++;
			}else{
				other++;
			} 
		}

		//List<Users> data=new ArrayList<Users>();
		Map<String,Users> data=new HashMap<String,Users>();
		for(Users user:users){
			if(user.getAddress().equalsIgnoreCase("河南省")){
				user.setPercent((double)henan/total);
				data.put("河南省", user);
				continue;
			}else if(user.getAddress().equalsIgnoreCase("湖南省")){
				user.setPercent((double)henan/total);
				data.put("湖南省", user);
				continue;
			}else if(user.getAddress().equalsIgnoreCase("安徽省")){
				user.setPercent((double)henan/total);
				data.put("安徽省", user);
				continue;
			}else if(user.getAddress().equalsIgnoreCase("湖北省")){
				user.setPercent((double)henan/total);
				data.put("湖北省", user);
				continue;
			}
		}
		
		Users user=new Users();
		user.setAddress("其他省");
		user.setPercent((double)henan/total);
		data.put("其他省", user);

		System.out.println(data);
		
		return data;
	}

}
*/