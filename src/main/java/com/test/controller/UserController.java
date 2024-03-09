package com.test.controller;

import com.test.entity.User;
import com.test.entity.UserAddress;
import com.test.entity.dto.UserAddressSaveDto;
import com.test.entity.dto.UserAddressUpdateDto;
import com.test.entity.dto.UserSaveDto;
import com.test.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "用户模块")
@RequestMapping("/customer")
public class UserController {

	@Autowired
	private UserServiceImpl userService;



	@ApiOperation("获取收货信息列表")
	@GetMapping("/useraddress")
	public Map getUserAddressList(@RequestHeader("Authorization") @ApiParam("登录客户令牌") String token){
		List<UserAddress> userAddresList = userService.getUserAddresList(token);
		HashMap<String, Object> map = new HashMap<>();
		map.put("httpstatus","success");
		map.put("data",userAddresList);
		map.put("httpcode",200);
		return map;

	}


	@ApiOperation("根据收货地址的id删除数据")
	@DeleteMapping("/useraddress/{uaddrId}")
	public Map deleteUserAddressByUaddrId(@PathVariable("uaddrId") @ApiParam("收货地址编号") Integer uaddrId){
		// 在这里需要调用service层的方法删除数据
		boolean b = userService.deleteUserAddressByUaddrId(uaddrId);
		HashMap<String, Object> map = new HashMap<>();
		if(b){
			map.put("httpstatus","success");
			map.put("httpcode",200);
		}else {
			map.put("httpstatus","error");
			map.put("httpcode",200);
		}
		return map;
	}






	@ApiOperation("修改收货信息")
	@PutMapping("/useraddress")
	public Map updateUserAddress(UserAddressUpdateDto dto,@RequestHeader("Authorization") @ApiParam("客户登录令牌") String token){
		// 调用业务逻辑层 方法 完成 收货地址的修改
		UserAddress userAddress = userService.updateUserAddress(dto, token);
		HashMap<String, Object> map = new HashMap<>();
		map.put("httpstatus","success");
		map.put("data",userAddress);
		map.put("httpcode",200);
		return map;
	}


	@ApiOperation("添加收货地址")
	@PostMapping("/useraddress")
	public Map saveUserAddress(UserAddressSaveDto dto,@RequestHeader("Authorization") @ApiParam("客户登录令牌") String token){
		UserAddress userAddress = userService.saveUserAddress(dto, token);
		HashMap<String, Object> map = new HashMap<>();
		map.put("httpstatus","success");
		map.put("data",userAddress);
		map.put("httpcode",200);
		return map;
	}


	/**
	 * 获取用户信息
	 * @param token	登录过后的token
	 * @return
	 */
	@GetMapping("/user")
	@ApiOperation("获取到用户信息")
	public Map getUserInfo(@RequestHeader("Authorization") @ApiParam("客户Token令牌") String token){
		User userInfo = userService.getUserInfo(token);
		HashMap<String, Object> map = new HashMap<>();
		map.put("httpstatus","success");
		map.put("data",userInfo);
		map.put("httpcode",200);
		return map;
	}




	@PostMapping("/regist")
	@ApiOperation("用户注册")
	public Map regist(UserSaveDto dto){
		boolean save = userService.save(dto);
		HashMap<String, Object> map = new HashMap<>();
		if(save){
			map.put("httpstatus","success");
			map.put("httpcode",200);
		}else {
			map.put("httpstatus","error");
			map.put("httpcode",200);
		}
		return map;
	}



	@ApiOperation("用户登录")
	@PostMapping("/login")
	public Map login(@ApiParam("客户手机号") String userPhone,@ApiParam("客户登录密码") String password){

		String token = userService.login(userPhone, password);
		// 创建用于返回数据的map集合
		HashMap<String, Object> map = new HashMap<>();
		map.put("httpstatus","success");
		map.put("data",token);
		map.put("httpcode",200);
		return map;
	}
}
