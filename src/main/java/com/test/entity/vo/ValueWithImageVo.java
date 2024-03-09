package com.test.entity.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ValueWithImageVo {

	// 属性值的基本信息
	private Long value_id;
	private String value_name;
	private LocalDateTime createtime;
	private LocalDateTime updatetime;
	private String key_id;

	// 还有属性值的相册
	private String value_images;
}
