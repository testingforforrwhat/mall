package com.test.entity.vo;

import com.test.entity.SpuAttrValue;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class KeyWithValueListVo {
	private String keyId;
	private String keyName;
	private Integer keyIssku;
	private Integer keyIshigh;
	private LocalDateTime createtime;
	private LocalDateTime updatetime;

	private List<SpuAttrValue> spuAttrValueList = new ArrayList<>();
}
