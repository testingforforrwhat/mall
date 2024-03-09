package com.test.mapper;

import com.test.entity.SpuAttrKey;
import com.test.entity.dto.AttrSearchDto;
import com.test.entity.vo.KeyWithValueImageVo;
import com.test.entity.vo.KeyWithValueListVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SpuAttrKeyMapper extends BaseMapper<SpuAttrKey> {

	/**
	 * 根据筛选条件查询到 带有属性值列表的属性建列表
	 * @param dto
	 * @return
	 */
	List<KeyWithValueListVo> getVoByAttrSearchDto(AttrSearchDto dto);

	/**
	 * 根据商品Spu的id查询出带有属性值列表的 规格属性键列表
	 * @param spuId
	 * @return
	 */
	List<KeyWithValueImageVo> getKeyVoListBySpuId(@Param("spuId") long spuId);

	/**
	 * 根据商品Spu 的id 查询出带有相册的 筛选属性值列表
	 * @param spuId
	 * @return
	 */
	List<KeyWithValueImageVo> getSearchKeyListBySpuId(@Param("spuId") long spuId);
}
