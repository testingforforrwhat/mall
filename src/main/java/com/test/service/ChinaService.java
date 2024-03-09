package com.test.service;

import com.test.entity.China;
import com.test.entity.vo.ChinaVo;
import com.test.mapper.ChinaMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChinaService extends ServiceImpl<ChinaMapper, China> implements IService<China> {

	@Autowired
	private ChinaMapper chinaMapper;

	/**
	 * 根据父级行政地区编号查询到下级行政地区列表
	 * @param pid
	 * @return
	 */
	public List<ChinaVo> getVoListByPid(Long pid){
		return chinaMapper.getVoListByPid(pid);
	}
}
