package com.test.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("china")
public class China {
	@TableId
	private Long id;
	private String name;
	private Long pid;
}
