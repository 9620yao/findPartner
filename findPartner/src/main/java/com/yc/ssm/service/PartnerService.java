package com.yc.ssm.service;

import java.util.List;

import com.yc.ssm.entity.Partner;

public interface PartnerService {
	Partner login(Partner partner);

	boolean register(Partner partner);

	List<Partner> findEmail(Partner partner);

	boolean updatePwd(Partner partner);

}
