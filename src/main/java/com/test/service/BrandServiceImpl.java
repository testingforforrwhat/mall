package com.test.service;

import com.test.entity.Brand;
import com.test.entity.vo.CategoryVo;
import com.test.mapper.BrandMapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper,Brand> implements IService<Brand> {

	@Autowired
	private BrandMapper brandMapper;


	/**
	 * 根据分类编号查询出 品牌列表
	 * @param cateId
	 * @return
	 */
	public List<Brand> getListByCateId(int cateId){
		return brandMapper.selectListByCateId(cateId);
	}



}
