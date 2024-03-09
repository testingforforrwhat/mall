package com.test.entity.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class KeyWithValueImageVo {

	// 属性键的基本信息
	private String keyId;
	private String keyName;
	private Integer keyIssku;
	private Integer keyIshigh;
	private LocalDateTime createtime;
	private LocalDateTime updatetime;


	// 带有相册的属性值列表
	private List<ValueWithImageVo> attrValueList = new ArrayList<>();
}
