package com.yc.ssm.aspect;

import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.yc.ssm.entity.Administrator;
import com.yc.ssm.entity.Partner;
import com.yc.ssm.util.Encrypt;

@Component("encryptAspect")
@Aspect
public class EncryptAspect {

	@Before("execution(* com.yc.ssm.service.impl.PartnerServiceImpl.login(..))")
	public void beforeMethodlogin(JoinPoint jpoint) {
		Partner partner = (Partner) jpoint.getArgs()[0];
		LogManager.getLogger().debug("对密码加密前==》" + partner);
		partner.setPassword(Encrypt.md5AndSha(partner.getPassword()));
	}

	@Before("execution(* com.yc.ssm.service.impl.PartnerServiceImpl.register(..))")
	public void beforeMethodregister(JoinPoint jpoint) {
		Partner partner = (Partner) jpoint.getArgs()[0];
		LogManager.getLogger().debug("对密码加密前==》" + partner);
		partner.setPassword(Encrypt.md5AndSha(partner.getPassword()));
	}

	@Before("execution(* com.yc.ssm.service.impl.PartnerServiceImpl.updatePwd(..))")
	public void beforeMethodModifyPwd(JoinPoint jpoint) {
		Partner partner = (Partner) jpoint.getArgs()[0];
		LogManager.getLogger().debug("对密码加密前==》" + partner);
		partner.setPassword(Encrypt.md5AndSha(partner.getPassword()));
	}

	@Before("execution(* com.yc.ssm.service.impl.PartnerServiceImpl.updateNewPwd(..))")
	public void beforeMethodupdateNewPwd(JoinPoint jpoint) {
		Partner partner = (Partner) jpoint.getArgs()[0];
		LogManager.getLogger().debug("对密码加密前==》" + partner);
		partner.setPassword(Encrypt.md5AndSha(partner.getPassword()));
	}
	@Before("execution(* com.yc.ssm.service.impl.AdministratorServiceImpl.adminLogin(..))")
	public void beforeMethodAdminLogin(JoinPoint jpoint) {
		Administrator admin=(Administrator) jpoint.getArgs()[0];
		LogManager.getLogger().debug("对密码加密前==》" + admin);
		admin.setBapwd(Encrypt.md5AndSha(admin.getBapwd()));
		LogManager.getLogger().debug("对密码加密后==》" + admin);
	}
}
