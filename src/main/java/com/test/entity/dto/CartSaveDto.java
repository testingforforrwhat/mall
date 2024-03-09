package com.test.entity.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CartSaveDto {

	private Long cartSpuid;

	private Integer cartSkuid;

	private String cartName;

	private String cartThumburl;

	private Double cartPrice;

	private Integer cartCount;

	private Integer cartChecked;

	private String cartSku;
}
