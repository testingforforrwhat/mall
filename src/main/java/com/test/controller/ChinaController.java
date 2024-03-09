package com.test.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.test.entity.vo.ChinaVo;
import com.test.service.ChinaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "行政地区模块")
@RequestMapping("/customer")
public class ChinaController {


	@Autowired
	private ChinaService chinaService;

	@GetMapping("/china")
	@ApiOperation("根据父级行政地区查询到下级行政地区列表")
	public Map getVoListByPid(@ApiParam("父级行政地区的编号") Long pid){
		List<ChinaVo> voList = chinaService.getVoListByPid(pid);

		HashMap<String, Object> map = new HashMap<>();
		String jsonStr = JSONUtil.toJsonStr(voList);
		map.put("httpstatus","success");
		map.put("data",jsonStr);
		map.put("httpcode",200);
		return map;
	}
}
