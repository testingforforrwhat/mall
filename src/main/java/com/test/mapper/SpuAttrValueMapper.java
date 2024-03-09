package com.test.mapper;

import com.test.entity.SpuAttrValue;
import com.test.entity.vo.ValueWithImageVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SpuAttrValueMapper extends BaseMapper<SpuAttrValue> {


	/**
	 * 根据商品属性建id查询出属性值列表
	 * @param keyId
	 * @return
	 */
	List<SpuAttrValue> getValueListByKeyId(@Param("keyId") String keyId);


	/**
	 * 根据商品属性键的id 查询到带有相册的属性值列表
	 * @param keyId
	 * @return
	 */
	List<ValueWithImageVo> getValueWithImageVoListByKeyId(@Param("keyId") String keyId);

	/**
	 * 根据商品属性值的id查询出 当前属性值拥有的相册
	 * @param valueId
	 * @return
	 */
	String getValueImageByValueId(@Param("valueId") long valueId);
}
