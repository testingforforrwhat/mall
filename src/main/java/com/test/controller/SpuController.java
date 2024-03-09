package com.test.controller;

import com.test.entity.dto.SpuSearchDto;
import com.test.entity.vo.SpuVo;
import com.test.service.SpuServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "商品Spu模块")
@RequestMapping("/product")
public class SpuController {

	@Autowired
	private SpuServiceImpl spuService;

	@ApiOperation("根据商品Spu的id查询到SpuVo")
	@GetMapping("/spu/{spuId}")
	public Map getSpuVoBySpuId(@PathVariable("spuId") @ApiParam("商品SpuId") Long spuId){
		SpuVo vo = spuService.getSpuVoBySpuId(spuId);

		// 准备用于返回数据的Map集合
		HashMap<String, Object> map = new HashMap<>();

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


	@ApiOperation("根据筛选条件查询到商品的详细数据")
	@GetMapping("/spu")
	public Map getSpuVoListBySpuSearchDto(SpuSearchDto dto){
		List<SpuVo> voList = spuService.getSpuVoListBySpuSearchDto(dto);
		// 准备用于返回数据的map集合
		HashMap<String, Object> map = new HashMap<>();
		map.put("httstatus","success");
		map.put("data",voList);
		map.put("httpcode",200);
		return map;
	}

}
