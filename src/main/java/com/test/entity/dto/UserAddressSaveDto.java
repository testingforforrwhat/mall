package com.test.entity.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserAddressSaveDto {
	@ApiParam("收货人姓名")
	private String uaddrName;
	/**
	 * 收货人手机号
	 */
	@ApiParam("收货人手机号")
	private String uaddrPhone;
	/**
	 * 省份/自治区/直辖市
	 */
	@ApiParam("省份/自治区/直辖市")
	private String uaddrProvince;
	/**
	 * 城市
	 */
	@ApiParam("城市")
	private String uaddrCity;
	/**
	 * 区/县
	 */
	@ApiParam("区/县")
	private String uaddrDistrict;
	/**
	 * 详细地址
	 */
	@ApiParam("详细地址")
	private String uaddrAddress;

	/**
	 * 是否默认
	 */
	@ApiParam("是否默认")
	private Integer uaddrIsdefault;

}
