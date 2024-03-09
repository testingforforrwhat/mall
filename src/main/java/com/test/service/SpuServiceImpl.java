package com.test.service;

import com.test.entity.Spu;
import com.test.entity.dto.SpuSearchDto;
import com.test.entity.vo.SpuVo;
import com.test.mapper.SpuMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpuServiceImpl extends ServiceImpl<SpuMapper, Spu> implements IService<Spu> {

	@Autowired
	private SpuMapper spuMapper;

	/**
	 * 根据商品Spu的id查询到SpuVo
	 * @param spuId
	 * @return
	 */
	public SpuVo getSpuVoBySpuId(Long spuId){
		return spuMapper.selectSpuVoBySpuId(spuId);
	}


	/**
	 * 根据筛选条件查询到满足条件的SpuVoList
	 * @param dto
	 * @return
	 */
	public List<SpuVo> getSpuVoListBySpuSearchDto(SpuSearchDto dto){
		// 需要将字符串的属性值id转成long类型存到 values中
		String valueList = dto.getValueList();
		// 将这个字符串以, 分隔成新的字符串数组
		String[] split = valueList.split(",");
		// 遍历这个分割之后的字符串数组 将每个字符串 转成Long类型 存到values中
		for (String s : split) {
			Long id = Long.valueOf(s);
			dto.getValues().add(id);
		}
		return spuMapper.selectVoListBySpuSearchDto(dto);
	}
}
