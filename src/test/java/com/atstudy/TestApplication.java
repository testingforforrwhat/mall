package com.test;

import cn.hutool.crypto.SecureUtil;
import com.test.entity.Brand;
import com.test.entity.Order;
import com.test.entity.User;
import com.test.entity.dto.SpuSearchDto;
import com.test.entity.vo.*;
import com.test.mapper.*;
import com.test.service.CategoryServiceImpl;
import com.test.util.TokenUtil;
import org.apache.tomcat.util.security.MD5Encoder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

@SpringBootTest
public class TestApplication {


	@Autowired
	private BrandMapper brandMapper;

	@Autowired
	private CategoryMapper categoryMapper;

	@Autowired
	private CategoryServiceImpl categoryService;


	@Autowired
	private SpuAttrKeyMapper keyMapper;

	@Autowired
	private SpuMapper spuMapper;

	@Autowired
	private SpuAttrValueMapper valueMapper;


	@Autowired
	private OrderMapper orderMapper;


	@Test
	public void testOrderMapper(){
		Order order = new Order();
		order.setOrderNo(UUID.randomUUID().toString());
		order.setOrderTotalamount(3499.00);
		order.setOrderUserId(123);
		orderMapper.insert(order);
	}

	@Test
	public void testTokenUtil() throws InterruptedException {
		// 创建User对象
		User user = new User();
		user.setUserId(123456);
		user.setUserName("张三");
		user.setUserPhone("12345678999");
		String token = TokenUtil.createToken(user);


		Object userId = TokenUtil.analysis("userId", token);
		System.out.println(userId);
	}


	@Test
	public void doSome() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String s = SecureUtil.md5("atstudy");
		System.out.println(s);

		String s1 = SecureUtil.md5("123456" + s);
		System.out.println(s1);

	}


	@Test
	public void testValueMapper(){
		List<ValueWithImageVo> voList = valueMapper.getValueWithImageVoListByKeyId("185836710433177359412935911814042316840");
		for (ValueWithImageVo vo : voList) {
			System.out.println(vo);
		}
	}


	@Test
	public void testSpuMapper(){
		SpuSearchDto dto = new SpuSearchDto();
		dto.setSpu_status(1);
//		dto.setValues(new Long[]{1916L,1917L});
		List<SpuVo> spuVos = spuMapper.selectVoListBySpuSearchDto(dto);


//		SpuVo spuVo = spuMapper.selectSpuVoBySpuId(196856);
//		System.out.println(spuVo);
//		System.out.println(spuVo.getBrand());
//		System.out.println("===========分类列表====================");
//		for (CategoryVo categoryVo : spuVo.getCategoryList()) {
//			System.out.println(categoryVo);
//		}
//		System.out.println("================sku列表==================");
//		for (Sku sku : spuVo.getSkuList()) {
//			System.out.println(sku);
//		}
//		System.out.println("=============规格属性键列表==========");
//		for (KeyWithValueImageVo keyWithValueImageVo : spuVo.getAttrKeyList()) {
//			System.out.println(keyWithValueImageVo);
//			for (ValueWithImageVo vo : keyWithValueImageVo.getAttrValueList()) {
//				System.out.println(vo);
//			}
//		}
//		System.out.println("===============筛选属性键列表=============");
//		for (KeyWithValueImageVo vo : spuVo.getSearchList()) {
//			System.out.println(vo);
//		}
	}


	@Test
	public void testKeyMapper(){

		List<KeyWithValueImageVo> voList = keyMapper.getSearchKeyListBySpuId(196856);
		for (KeyWithValueImageVo vo : voList) {
			System.out.println(vo);
		}
//		List<KeyWithValueListVo> voList = keyMapper.getVoByAttrSearchDto(new AttrSearchDto(130, 0, 0));
//		for (KeyWithValueListVo vo : voList) {
//			System.out.println(vo);
//		}
	}


	@Test
	public void testCategoryService(){
		CategoryVo voByCateId = categoryService.getVoByCateId(1);
		System.out.println(voByCateId);
	}

	@Test
	public void testBrandMapper(){
		Brand brand = new Brand();
		brand.setBrandName("测试品牌aaaa");
		brand.setBrandLogourl("abc");
		brandMapper.insert(brand);
		System.out.println(brand);
	}


	@Test
	public void testCategoryMapper(){



//		CategoryVo categoryVo = categoryMapper.selectVoByCateId(1);
//		System.out.println(categoryVo);

//		List<CategoryVo> voList = categoryMapper.selectVoListByCateId(1);
//		for (CategoryVo categoryVo : voList) {
//			System.out.println(categoryVo);
//		}
	}
}
