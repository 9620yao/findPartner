package com.yc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.ssm.entity.Partner;
import com.yc.ssm.mapper.PartnerMapper;
import com.yc.ssm.service.PartnerService;

@Service("partnerService")
public class PartnerServiceImpl implements PartnerService {
	
	@Autowired
	private PartnerMapper partnerMapper;

	@Override
	public Partner login(Partner partner) {
		return partnerMapper.fingPartner(partner);
	}

	@Override
	public boolean register(Partner partner) {
		return partnerMapper.insertPar(partner)>0;
	}

	@Override
	public List<Partner> findEmail(Partner partner) {
		return partnerMapper.fingEmail(partner);
	}

}
