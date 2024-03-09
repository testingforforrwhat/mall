package com.test.entity.vo;

import com.test.entity.OrderAddress;
import com.test.entity.OrderDetails;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderVo {

	private Integer id;

	private String orderNo;

	private Integer orderStatus;

	private Double orderSpuamount;


	private Double orderExpressfee;


	private Double orderTotalamount;


	private Double orderDiscountamount;


	private Double orderPayamount;

	private Integer orderPaymode;

	private Integer orderPayplatform;

	private String orderIpaddress;

	private String orderPaymentno;

	private String orderRemark;

	private LocalDateTime createtime;

	private LocalDateTime updatetime;

	private Integer orderUserId;


	private OrderAddress orderAddress;

	private List<OrderDetails> orderDetailList = new ArrayList<>();
}
