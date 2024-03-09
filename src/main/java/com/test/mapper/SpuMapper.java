package com.test.mapper;

import com.test.entity.Spu;
import com.test.entity.dto.SpuSearchDto;
import com.test.entity.vo.SpuVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SpuMapper extends BaseMapper<Spu> {

	/**
	 * 根据spuid 查询到Spuvo
	 * @param spuId
	 * @return
	 */
	SpuVo selectSpuVoBySpuId(@Param("spuId") long spuId);


	/**
	 * 根据筛选条件查询到 满足条件的SpuVoList
	 * @param dto
	 * @return
	 */
	List<SpuVo> selectVoListBySpuSearchDto(@Param("dto") SpuSearchDto dto);
}
