package com.test.service;

import com.test.entity.Sku;
import com.test.mapper.SkuMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku> implements IService<Sku> {
}
