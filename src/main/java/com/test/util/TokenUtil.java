package com.test.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTHeader;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.JWTValidator;
import com.test.entity.User;

import javax.xml.crypto.Data;
import java.util.Date;

public class TokenUtil {


	public static final Date EXPIRATION_TIME = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 15);

	// 创建token的方法
	public static String createToken(User user){
		// 密钥
		byte[] key = "atstudy".getBytes();

		String token = JWT.create()
				.setPayload("userId", user.getUserId())
				.setPayload("userName", user.getUserName())
				.setPayload("userPhone", user.getUserPhone())
				.setExpiresAt(EXPIRATION_TIME)
				.setKey(key)
				.sign();

		return token;
	}

	/**
	 * 解析token
	 * @param key
	 * @param token
	 * @return
	 */
	public static Object analysis(String key,String token){
		// 先验证 token
		JWTValidator.of(token).validateDate(DateUtil.date());

		final JWT jwt = JWTUtil.parseToken(token);

		// JWT
		jwt.getHeader(JWTHeader.TYPE);
		// HS256
		jwt.getHeader(JWTHeader.ALGORITHM);
		Object payload = jwt.getPayload(key);
		return payload;
	}


}
