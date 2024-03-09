package com.test.entity.dto;

import io.swagger.annotations.ApiParam;
import lombok.Data;

@Data
public class CartUpdateDto {
	@ApiParam("购买数量")
	private Integer cartCount;
	@ApiParam("是否选中")
	private Integer cartChecked;
	@ApiParam(value = "购物车id",required = true)
	private Integer carId;
}
