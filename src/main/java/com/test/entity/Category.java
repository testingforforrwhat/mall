package com.test.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.models.auth.In;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("category")
public class Category {
	@TableId
	private Integer cateId;
	private String cateName;
	private Integer cateSort;
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createtime;
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updatetime;
	private String cateChannel;
	private Integer cateParentid;
}
