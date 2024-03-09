package com.test.service;

import com.test.entity.SpuAttrKey;
import com.test.entity.dto.AttrSearchDto;
import com.test.entity.vo.KeyWithValueListVo;
import com.test.mapper.SpuAttrKeyMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeyServiceImpl extends ServiceImpl<SpuAttrKeyMapper, SpuAttrKey> implements IService<SpuAttrKey> {

	@Autowired
	private SpuAttrKeyMapper keyMapper;

	/**
	 * 根据筛选条件查询到 带有属性值列表的属性建 列表
	 * @param dto
	 * @return
	 */
	public List<KeyWithValueListVo> getVoListBySearchDto(AttrSearchDto dto){
		return keyMapper.getVoByAttrSearchDto(dto);
	}
}
