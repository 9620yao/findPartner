package com.yc.ssm.mapper;

import java.util.List;

import com.yc.ssm.entity.Partner;

public interface PartnerMapper {
	//登录操作
	Partner fingPartner(Partner partner);
	
	int insertPar(Partner partner);
	
	List<Partner> fingEmail(Partner partner);

	int modifyPwd(Partner partner);

	int newPwd(Partner partner);
}
