package com.test.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.UUID;
import com.test.entity.Order;
import com.test.entity.OrderAddress;
import com.test.entity.OrderDetails;
import com.test.entity.dto.OrderSaveDto;
import com.test.entity.vo.OrderVo;
import com.test.mapper.OrderAddressMapper;
import com.test.mapper.OrderDetailsMapper;
import com.test.mapper.OrderMapper;
import com.test.util.TokenUtil;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IService<Order> {

	@Autowired
	private OrderMapper orderMapper;


	@Autowired
	private OrderAddressMapper orderAddressMapper;

	@Autowired
	private OrderDetailsMapper orderDetailsMapper;

	/**
	 * 添加订单
	 * @param dto
	 * @param token
	 * @return
	 */
	@Transactional
	public OrderVo insertOrder(OrderSaveDto dto,String token){
		// 1.往订单表中添加数据
		// 创建一个用于添加的订单对象
		Order order = new Order();
		// 使用属性拷贝工具将同名的属性值 赋值给order
		BeanUtil.copyProperties(dto,order);
		// 生成订单号
		order.setOrderNo(UUID.randomUUID().toString());
		// 解析token获取到用户id
		Object oldId = TokenUtil.analysis("userId", token);
		Integer userId = Convert.convert(Integer.class, oldId);
		order.setOrderUserId(userId);
		order.setOrderStatus(0);
		int insert = orderMapper.insert(order);

		// 2.往订单收货信息中添加数据
		// 创建一个用于添加的收货信息对象
		OrderAddress orderAddress = new OrderAddress();
		// 借组属性拷贝工具将dto中的userAddress中的同名的属性 赋值给 orderAddress对象
		BeanUtil.copyProperties(dto.getOrderAddress(),orderAddress);
		// 给这个订单的收货信息设置订单编号
		orderAddress.setOrderno(order.getOrderNo());
		// 添加数据
		int insert1 = orderAddressMapper.insert(orderAddress);


		// 3. 添加订单详情
		// 获取到要添加的订单详情
		List<OrderDetails> orderDetailList = dto.getOrderDetailList();

		for (OrderDetails orderDetails : orderDetailList) {
			// 给每一个遍历到的订单详情添加所属订单id
			orderDetails.setOdtailsOrdernoId(order.getId());
			// 调用持久层接口进行添加数据
			int insert3 = orderDetailsMapper.insert(orderDetails);
		}

		// 添加完毕之后 创建Vo返回数据
		OrderVo orderVo = new OrderVo();
		// 使用属性拷贝工具将同名的属性值 拷过去
		BeanUtil.copyProperties(order,orderVo);
		// 将添加过后的收货信息地址赋值给vo
		orderVo.setOrderAddress(orderAddress);
		// 将dto中的orderDetailsList赋值给Vo
		orderVo.setOrderDetailList(dto.getOrderDetailList());

		return orderVo;

	}
}
