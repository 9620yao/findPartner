package com.yc.ssm.aspect;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

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
}
