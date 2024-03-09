package com.test.service;

import com.test.entity.SpuAttrValue;
import com.test.mapper.SpuAttrValueMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ValueServiceImpl extends ServiceImpl<SpuAttrValueMapper, SpuAttrValue> implements IService<SpuAttrValue> {
}
