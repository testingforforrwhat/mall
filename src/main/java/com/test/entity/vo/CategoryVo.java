package com.test.entity.vo;

import com.test.entity.Category;
import com.test.entity.Channel;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryVo {

	private Integer cateId;
	private String cateName;
	private Integer cateSort;
	private LocalDateTime createtime;
	private LocalDateTime updatetime;
	private String cateChannel;
	private Integer cateParentid;

	private List<Channel> channelList = new ArrayList();
	private List<CategoryVo> children = new ArrayList<>();
}
