package com.test.entity.dto;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttrSearchDto {
	@ApiParam(value = "分类id",required = true)
	private Integer cateId;
	@ApiParam(value = "是否是规格属性",required = true)
	private Integer keyIssku;
	@ApiParam(value = "是否是高级属性",required = true)
	private Integer keyIshigh;
}
