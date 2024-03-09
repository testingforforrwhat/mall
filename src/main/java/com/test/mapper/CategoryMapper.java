package com.test.mapper;

import com.test.entity.Category;
import com.test.entity.vo.CategoryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {


	/**
	 * 根据商品spuId 查询到分类列表
	 * @param spuId
	 * @return
	 */
	List<CategoryVo> selectVoListBySpuId(@Param("spuId") long spuId);


	/**
	 * 根据父级分类编号查询到分类列表
	 * @param pid
	 * @return
	 */
	List<CategoryVo> selectVoListByCateId(@Param("pid") int pid);


	/**
	 * 根据分类编号查询出 带有频道的Vo
	 * @param cateId
	 * @return
	 */
	CategoryVo selectVoByCateId(@Param("cateId") int cateId);
}
