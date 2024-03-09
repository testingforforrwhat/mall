package com.test.controller;

import com.test.entity.dto.AttrSearchDto;
import com.test.entity.vo.KeyWithValueListVo;
import com.test.service.KeyServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "商品属性值模块")
@RequestMapping("/product")
@RestController
public class SpuAttrKeyController {


	@Autowired
	private KeyServiceImpl keyService;

	/**
	 * 根据筛选条件查询到 带有属性值列表的 属性建列表
	 * @param dto
	 * @return
	 */
	@ApiOperation("根据筛选条件查询到 带有属性值列表的 属性建列表")
	@GetMapping("/attr")
	public Map getVoListByAttrSearchDto(AttrSearchDto dto){
		List<KeyWithValueListVo> voList = keyService.getVoListBySearchDto(dto);

		// 准备用于返回数据用的map集合
		HashMap<String, Object> map = new HashMap<>();

		// 判断数据是否为空 返回不同的提示
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

}
