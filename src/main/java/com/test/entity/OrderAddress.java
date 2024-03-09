package com.test.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (OrderAddress)实体类
 *
 * @author makejava
 * @since 2023-11-17 14:10:13
 */
@Data
@TableName("order_address")
public class OrderAddress implements Serializable {
    private static final long serialVersionUID = 485400665941936454L;
/**
     * 订单收货信息id
     */
    @TableId
    private Integer id;
/**
     * 关联的订单号
     */
    private String orderno;

    @ApiParam("收货人姓名")
    private String consignee;

    @ApiParam("收货人手机号")
    private String phone;

    @ApiParam("省份/自治区/直辖市")
    private String province;

    @ApiParam("城市")
    private String city;

    @ApiParam("区/县")
    private String district;

    @ApiParam("详细地址")
    private String address;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatetime;


}

