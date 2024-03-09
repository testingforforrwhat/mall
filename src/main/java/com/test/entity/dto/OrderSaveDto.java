package com.test.entity.dto;

import com.test.entity.OrderAddress;
import com.test.entity.OrderDetails;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderSaveDto {

	@ApiParam("订购商品总金额")
	private Double orderSpuamount;

	@ApiParam("快递费")
	private Double orderExpressfee;

	@ApiParam("订单总金额")
	private Double orderTotalamount;

	@ApiParam("优惠金额")
	private Double orderDiscountamount;

	@ApiParam("实付金额")
	private Double orderPayamount;

	@ApiParam("收货地址")
	private OrderAddress orderAddress;

	private List<OrderDetails> orderDetailList = new ArrayList<>();
}
