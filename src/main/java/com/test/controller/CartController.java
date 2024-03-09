package com.test.controller;

import com.test.entity.Cart;
import com.test.entity.dto.CartSaveDto;
import com.test.entity.dto.CartUpdateDto;
import com.test.service.CartServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "购物车模块")
@RequestMapping("/order")
public class CartController {

	@Autowired
	private CartServiceImpl cartService;



	@ApiOperation("查询购物车")
	@GetMapping("/cart")
	public Map getAll(@RequestHeader("Authorization") @ApiParam("客户Token令牌")String token){
		List<Cart> all = cartService.getAll(token);
		HashMap<String, Object> map = new HashMap<>();
		map.put("httpstatus","success");
		map.put("data",all);
		map.put("httpcode",200);
		return map;
	}



	@DeleteMapping("/cart")
	@ApiOperation("清空购物车")
	public Map clear(@RequestHeader("Authorization") @ApiParam("客户Token令牌")String token){
		boolean clear = cartService.clear(token);
		HashMap<String, Object> map = new HashMap<>();
		map.put("httpstatus","success");
		map.put("data",null);
		map.put("httpcode",200);
		return map;
	}


	@ApiOperation("根据购物车的id删除数据")
	@DeleteMapping("/cart/{carId}")
	public Map deleteByCarId(@PathVariable("carId") @ApiParam("购物车id") Integer carId,@RequestHeader("Authorization") @ApiParam("客户Token令牌")String token){
		boolean b = cartService.deleteByCarId(carId);

		HashMap<String, Object> map = new HashMap<>();
		if(b){
			map.put("httpstatus","success");
			map.put("data",null);
			map.put("httpcode",200);
		}else {
			map.put("httpstatus","error");
			map.put("data",null);
			map.put("httpcode",200);
		}
		return map;
	}



	@ApiOperation("修改购物车")
	@PutMapping("/cart")
	public Map updateCart(CartUpdateDto dto,@RequestHeader("Authorization") @ApiParam("客户Token令牌")String token){
		Cart cart = cartService.updateCart(dto, token);
		HashMap<String, Object> map = new HashMap<>();
		map.put("httpstatus","success");
		map.put("data",cart);
		map.put("httpcode",200);
		return map;
	}






	@PostMapping("/cart")
	@ApiOperation("添加购物车")
	public Map saveCart(@RequestBody CartSaveDto dto, @RequestHeader("Authorization") @ApiParam("客户Token令牌") String token){
		Cart cart = cartService.insertCart(dto, token);

		HashMap<String, Object> map = new HashMap<>();
		map.put("httpstatus","success");
		map.put("data",cart);
		map.put("httpcode",200);
		return map;
	}

}
