package com.test.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import com.test.entity.Cart;
import com.test.entity.dto.CartSaveDto;
import com.test.entity.dto.CartUpdateDto;
import com.test.mapper.CartMapper;
import com.test.util.TokenUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements IService<Cart> {

	@Autowired
	private CartMapper cartMapper;


	/**
	 * 查询购物车信息
	 * @param token
	 * @return
	 */
	public List<Cart> getAll(String token){
		// 1.解析token获取到当前登录用户的id
		Object userId = TokenUtil.analysis("userId", token);
		// 2.使用hutool的类型转换工具
		Integer convert = Convert.convert(Integer.class, userId);
		// 3.调用持久层接口进行查询 需要创建条件构造器
		QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("cart_userid",convert);
		List<Cart> carts = cartMapper.selectList(queryWrapper);
		return carts;
	}


	/**
	 * 清空购物车
	 * @param token
	 * @return
	 */
	public boolean clear(String token) {
		// 解析token获取到用户的id
		Object userId = TokenUtil.analysis("userId", token);
		// 借组类型转换工具 得到userId
		Integer convert = Convert.convert(Integer.class, userId);
		// 创建一个用于删除的条件构造器
		QueryWrapper<Cart> deleteWrapper = new QueryWrapper<>();
		deleteWrapper.eq("cart_userid",convert);
		// 删除数据
		int delete = cartMapper.delete(deleteWrapper);
		// 可能有的用户购物车中并没有数据
		return true;
	}

	/**
	 * 根据购物车的编号删除购物车数据
	 * @param carId
	 * @return
	 */
	public boolean deleteByCarId(Integer carId){
		return cartMapper.deleteById(carId) > 0 ? true : false;
	}



	/**
	 * 修改购物车
	 * @param dto
	 * @param token
	 * @return
	 */
	public Cart updateCart(CartUpdateDto dto,String token){
		// 创建用于更新的UpdateWapper
		UpdateWrapper<Cart> updateWrapper = new UpdateWrapper<>();
		// 设置需要更新的字段 和更新条件
		updateWrapper.set("cart_count",dto.getCartCount())
				.set("cart_checked",dto.getCartChecked())
				.eq("car_id",dto.getCarId());
		int update = cartMapper.update(new Cart(), updateWrapper);
		// 因为这个方法需要将更新过后的数据返回 所以可以再次查询数据库
		Cart cart = cartMapper.selectById(dto.getCarId());
		return cart;
	}




	/**
	 * 添加购物车
	 * @param dto
	 * @param token
	 * @return
	 */
	public Cart insertCart(CartSaveDto dto,String token){
		// 创建用于添加的Cart对象
		Cart cart = new Cart();
		// 借组属性拷贝工具将dto中的同名的属性值 赋给 cart对象
		BeanUtil.copyProperties(dto,cart);
		// 还差一个所属客户id 可以通过解析token获取
		Object userId = TokenUtil.analysis("userId", token);
		// 使用hutool工具的类型转换工具进行
		Integer convert = Convert.convert(Integer.class, userId);
		// 给这个用于添加的cart对象的所属客户id赋值
		cart.setCartUserid(convert);
		// 调用持久层的方法添加数据
		int insert = cartMapper.insert(cart);
		return cart;
	}
}
