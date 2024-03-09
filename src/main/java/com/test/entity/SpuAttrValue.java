package com.test.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("spu_attr_value")
public class SpuAttrValue {

	@TableId
	private Long id;
	private String valueName;
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createtime;
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updatetime;
	private String valueAttrKeyId;
}
