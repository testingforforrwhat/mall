package com.test.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("brand")
public class Brand {

	@TableId			// 主键默认使用雪花算法
	private String brandId;
	private String brandName;
	private String brandIntroduction;
	private String brandLogourl;
	private Integer sortno;
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createtime;
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updatetime;
}
