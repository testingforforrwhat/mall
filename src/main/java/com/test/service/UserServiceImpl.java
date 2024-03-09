package com.test.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.convert.Converter;
import cn.hutool.crypto.SecureUtil;
import com.test.entity.User;
import com.test.entity.UserAddress;
import com.test.entity.dto.UserAddressSaveDto;
import com.test.entity.dto.UserAddressUpdateDto;
import com.test.entity.dto.UserSaveDto;
import com.test.mapper.UserAddressMapper;
import com.test.mapper.UserMapper;
import com.test.util.TokenUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IService<User> {


	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserAddressMapper userAddressMapper;


	/**
	 * 获取到收货信息列表
	 * @param token
	 * @return
	 */
	public List<UserAddress> getUserAddresList(String token){
		// 解析token获取到用户的id
		Object userId = TokenUtil.analysis("userId", token);
		// 使用hutool提供的类型转换工具
		Integer convert = Convert.convert(Integer.class, userId);
		// 调用持久层的接口完成数据查询

		// 创建条件构造器
		QueryWrapper<UserAddress> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("uaddr_user_id",convert);
		List<UserAddress> userAddressList = userAddressMapper.selectList(queryWrapper);
		return userAddressList;
	}


	/**
	 * 根据收货地址编号删除收货地址
	 * @param uaddrId
	 * @return
	 */
	public boolean deleteUserAddressByUaddrId(Integer uaddrId){
		int i = userAddressMapper.deleteById(uaddrId);
		return i > 0 ? true : false;
	}


	/**
	 * 修改收货信息
	 * @param dto
	 * @param token
	 * @return
	 */
	public UserAddress updateUserAddress(UserAddressUpdateDto dto,String token){
		// 创建UserAddress 对象
		UserAddress userAddress = new UserAddress();
		// 借助属性拷贝工具给这个对象赋值
		BeanUtil.copyProperties(dto,userAddress);
		// 解析token获取到
		Object userId = TokenUtil.analysis("userId", token);
		// 使用hutool 的类型转换工具进行转换
		Integer convert = Convert.convert(Integer.class, userId);
		// 给这个userAddress 赋值
		userAddress.setUaddrUserId(convert);
		// 调用持久层方法根据主键主键进行更新
		userAddressMapper.updateById(userAddress);
		return userAddress;
	}


	/**
	 * 添加收货信息
	 * @param dto
	 * @return
	 */
	public UserAddress saveUserAddress(UserAddressSaveDto dto,String token){
		// 创建用于添加的UserAddress 对象
		UserAddress userAddress = new UserAddress();
		// 使用属性拷贝工具将dto中同名的值 赋值过去
		BeanUtil.copyProperties(dto,userAddress);
		// 解析token获取到userId
		Object userId = TokenUtil.analysis("userId", token);
		// 这个userId必须使用hutool的类型转换 工具进行转换
		Integer convert = Convert.convert(Integer.class, userId);
		// 给userAddress 的用户id赋值
		userAddress.setUaddrUserId(convert);
		// 调用持久层的方法进行添加
		userAddressMapper.insert(userAddress);
		// 将这个添加过后的 userAddress 返回去
		return userAddress;
	}


	/**
	 * 获取到用户信息
	 * @param token
	 * @return
	 */
	public User getUserInfo(String token){
		// 直接解析token 获取到用户id 根据id查询数据
		Object userId = TokenUtil.analysis("userId", token);

		// 不能强转，需要借组hutool工具的类型转换工具
		Integer convert = Convert.convert(Integer.class, userId);

		// 调用持久层方法根据用户id查询到数据
		User user = userMapper.selectById(convert);
		return user;

	}


	/**
	 * 用户登录 登录成功则返回token
	 * @param userPhone
	 * @param password
	 * @return
	 */
	public String login(String userPhone,String password){
		User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_phone", userPhone));
		if(user == null){
			// 说明用户不存在
			return "手机号码或者密码错误";
		}else {
			// 说明用户是存在的
			// 继续校验密码
			String pwd = SecureUtil.md5(password + user.getUserSalt());
			// 和数据库的密文进行比对
			if(pwd.equals(user.getUserPassword())){
				// 登录成功
				// 创建token
				String token = TokenUtil.createToken(user);

				// 登录成功之后 应该更新user表中的数据 更新最后登录的时间 token过期时间  TODO
				return token;
			}else {
				// 登录失败
				return "手机号码或者密码错误";
			}
		}
	}



	/**
	 * 添加用户
	 * @return
	 */
	public boolean save(UserSaveDto dto){
		// 创建用于添加用的User对象
		User user = new User();
		// 将dto中的值赋给 user
		user.setUserName(dto.getUser_name());
		user.setUserPhone(dto.getUser_phone());

		// 创建用于加密的盐
		String s = SecureUtil.md5("atstudy");
		// 给这个user设置盐值
		user.setUserSalt(s);
		// 加盐加密   得到加密过后的密码
		String pwd = SecureUtil.md5(dto.getUser_password() + s);
		user.setUserPassword(pwd);

		// 将这个user对象添加到数据库中
		int insert = userMapper.insert(user);
		return insert > 0 ? true : false;
	}

}
