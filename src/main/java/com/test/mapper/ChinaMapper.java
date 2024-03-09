package com.test.mapper;

import com.test.entity.China;
import com.test.entity.vo.ChinaVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ChinaMapper extends BaseMapper<China> {

	/**
	 * 根据父级行政地区编号 查询到下级行政地区列表
	 * @param pid
	 * @return
	 */
	List<ChinaVo> getVoListByPid(@Param("pid") Long pid);
}
