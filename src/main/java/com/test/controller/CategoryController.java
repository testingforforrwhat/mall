package com.test.controller;

import com.test.entity.vo.CategoryVo;
import com.test.service.CategoryServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "商品分类模块")
@RequestMapping("/product")
public class CategoryController {

	@Autowired
	private CategoryServiceImpl categoryService;

	@GetMapping("/category")
	@ApiOperation("根据父级分类编号查询到分类列表")
	public Map getVoListByPid(@ApiParam("父级分类编号") Integer pid){
		List<CategoryVo> voList = categoryService.getVoListByCateId(pid);

		// 创建用于返回数据的map
		HashMap<String, Object> map = new HashMap<>();
		// 判断是否存在数据
		if(voList != null){
			map.put("httpstatus","success");
			map.put("data",voList);
			map.put("httpcode",200);
		}else {
			map.put("httpstatus","error");
			map.put("data",voList);
			map.put("httpcode",200);
		}
		return map;
	}


	@ApiOperation("根据分类编号查询到 一个带有 频道列表的 分类对象")
	@GetMapping("/category/{cateId}")
	public Map getVoByCategoryId(@PathVariable("cateId") @ApiParam("分类编号") Integer cateId){
		CategoryVo vo = categoryService.getVoByCateId(cateId);

		// 准备用于返回数据的map集合
		HashMap<String, Object> map = new HashMap<>();
		// 判断是否查询到了数据
		if(vo != null){
			map.put("httpstatus","success");
			map.put("data",vo);
			map.put("httpcode",200);
		}else {
			map.put("httpstatus","error");
			map.put("data",vo);
			map.put("httpcode",200);
		}
		return map;
	}
}
