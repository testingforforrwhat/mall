package com.test.mapper;

import com.test.entity.Brand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BrandMapper extends BaseMapper<Brand> {


	/**
	 * 根据分类编号查询到品牌列表
	 * @param cateId
	 * @return
	 */
	List<Brand> selectListByCateId(@Param("cateId") int cateId);


}
