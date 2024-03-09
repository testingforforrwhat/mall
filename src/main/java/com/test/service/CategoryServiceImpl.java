package com.test.service;

import com.alibaba.fastjson2.JSON;
import com.test.entity.Category;
import com.test.entity.Channel;
import com.test.entity.vo.CategoryVo;
import com.test.mapper.CategoryMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>  implements IService<Category> {

	@Autowired
	private CategoryMapper categoryMapper;

	/**
	 * 根据父级分类编号查询出 带有下级分类列表的 分类列表
	 * @param pid
	 * @return
	 */
	public List<CategoryVo> getVoListByCateId(int pid){
		return categoryMapper.selectVoListByCateId(pid);
	}

	/**
	 * 根据分类编号查询出 带有 频道列表的 Vo
	 * @param cateId
	 * @return
	 */
	public CategoryVo getVoByCateId(int cateId){
		// 这里获取到了带有分类的基本信息的Vo    就差一个频道列表
		CategoryVo categoryVo = categoryMapper.selectVoByCateId(cateId);
		// 先获取到字符串形式的频道列表
		String cateChannel = categoryVo.getCateChannel();
		// 将这个字符串转成List<Channel>  Channel.class 是指定List中的泛型
		categoryVo.setChannelList(JSON.parseArray(cateChannel, Channel.class));
		return categoryVo;
	}
}
