package com.test.entity.vo;

import com.test.entity.Brand;
import com.test.entity.Sku;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class SpuVo {

	// 商品Spu的基本信息
	private long spuId;
	private String spuName;
	private String spuTitle;
	private String spuIntroduction;
	private String spuUnit;
	private byte spuSketchtype;
	private String spuSketch;
	private String spuSpecs;
	private byte spuSkutype;
	private byte spuStatus;
	private LocalDateTime createtime;
	private LocalDateTime updatetime;
	private String spuBrandId;

	// 品牌信息
	private Brand brand;

	// 分类列表
	private List<CategoryVo> categoryList = new ArrayList();

	// Sku列表
	private List<Sku> skuList = new ArrayList<>();

	// spuAttrVoList
	private List spuAttrVoList = new ArrayList();

	// 规格属性键列表
	private List<KeyWithValueImageVo> attrKeyList = new ArrayList<>();

	// 筛选属性键列表
	private List<KeyWithValueImageVo> searchList = new ArrayList<>();
}
