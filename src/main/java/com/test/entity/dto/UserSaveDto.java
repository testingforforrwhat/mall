package com.test.entity.dto;

import io.swagger.annotations.ApiParam;
import lombok.Data;

@Data
public class UserSaveDto {
	@ApiParam(value = "用户手机号",required = true)
	private String user_phone;
	@ApiParam(value = "用户密码",required = true)
	private String user_password;
	@ApiParam(value = "用户手昵称",required = true)
	private String user_name;
}
