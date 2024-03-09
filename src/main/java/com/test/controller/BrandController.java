package com.test.controller;

import com.test.entity.Brand;
import com.test.service.BrandServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "商品品牌模块")
@RequestMapping("/product")
@RestController
public class BrandController {

	@Autowired
	private BrandServiceImpl brandService;


	@ApiOperation("根据分类id获取到品牌列表")
	@GetMapping("/brand")
	public Map getBrandListByCateId(@RequestParam("cate_id") @ApiParam("分类id") Integer cateId){

		List<Brand> brandList = brandService.getListByCateId(cateId);

		// 创建用于返回数据的map集合
		HashMap<String, Object> map = new HashMap<>();
		if(brandList != null){
			map.put("httpstatus","success");
			map.put("data",brandList);
			map.put("httpcode",200);
		}else {
			map.put("httpstatus","error");
			map.put("data",brandList);
			map.put("httpcode",200);
		}
		return map;
	}

}
