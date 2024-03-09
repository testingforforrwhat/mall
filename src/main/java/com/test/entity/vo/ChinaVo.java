package com.test.entity.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChinaVo {
	private Long id;
	private String name;
	private Long pid;

	private List<ChinaVo> children = new ArrayList<>();
}
