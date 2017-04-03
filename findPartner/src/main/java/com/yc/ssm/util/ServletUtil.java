package com.yc.ssm.util;

import java.io.File;

public class ServletUtil {
	public static final String LOGIN_USER = "loginUser";// 登录用户
	public static final String ERROR_MESSAGE = "errorMsg";
	public static String DEPLOY_NAME;

	public static final String USER_INFO = "userInfo";
	public static String UPLOAD_DIR;
	public static String VIRTUAL_UPLOAD_DIR = "/upload03/";
	
	public static String LOGINING_ID = "logining" ;// 登录用户的登录id

	public static File getUploadFile(String fileName) {
		File file = new File(UPLOAD_DIR, fileName);// 上传文件
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		return file;

	}

}
