package com.test.entity.dto;

import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SpuSearchDto {
	@ApiParam("商品名称")
	private String spu_name;
	@ApiParam("商品标题")
	private String spu_title;
	@ApiParam("商品上架状态 1:上架 0:下架")
	private Integer spu_status;
	@ApiParam("商品分类编号")
	private Integer cate_id;
	@ApiParam("商品属性值id")
	private String valueList;
	@ApiParam("起始索引")
	private Integer start = 0;
	@ApiParam("查询的记录数")
	private Integer length = 10;

	// 用于接收转换过后的属性值id的数组
	private List<Long> values = new ArrayList<>();


}
