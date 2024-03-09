package com.test.controller;

import com.test.entity.dto.OrderSaveDto;
import com.test.entity.vo.OrderVo;
import com.test.service.OrderServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "订单模块")
@RestController
public class OrderController {

	@Autowired
	private OrderServiceImpl orderService;




	@ApiOperation("添加订单")
	@PostMapping("/order")
	public Map insertOrder(OrderSaveDto dto, @RequestHeader("Authorization") String token){
		OrderVo orderVo = orderService.insertOrder(dto, token);
		HashMap<String, Object> map = new HashMap<>();
		map.put("httpstatus","success");
		map.put("data",orderVo);
		map.put("httpcode",200);

		return map;
	}

}
