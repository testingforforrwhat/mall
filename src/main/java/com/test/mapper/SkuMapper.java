package com.test.mapper;

import com.test.entity.Sku;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SkuMapper extends BaseMapper<Sku> {


	/**
	 * 根据商品Spuid查询到sku列表
	 * @param spuId
	 * @return
	 */
	List<Sku> selectListBySpuId(@Param("spuId") long spuId);
}
