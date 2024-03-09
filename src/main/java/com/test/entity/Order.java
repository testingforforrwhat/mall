package com.test.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2023-11-17 14:10:13
 */
@Data
@TableName("order")
public class Order{


    @TableId(type = IdType.AUTO)
    private Integer id;
/**
     * 订单号
     */
    private String orderNo;
/**
     * 订单状态 0.已下单 2.已付款 4.已配货 6.已发货 8.已收货 10.已评价 30.退款中 32.已退款 34.退款失败 40.已取消
     */
    private Integer orderStatus;
/**
     * 商品总金额
     */
    private Double orderSpuamount;
/**
     * 快递费
     */
    private Double orderExpressfee;
/**
     * 订单总金额
     */
    private Double orderTotalamount;
/**
     * 优惠金额
     */
    private Double orderDiscountamount;
/**
     * 实付金额
     */
    private Double orderPayamount;
/**
     * 支付方式 0.支付宝 1.微信
     */
    private Integer orderPaymode;
/**
     * 支付平台 0.pc 1.app 2.小程序 3.手机H5
     */
    private Integer orderPayplatform;
/**
     * 请求付款时设备ip地址
     */
    private String orderIpaddress;
/**
     * 付款平台的支付单号
     */
    private String orderPaymentno;
/**
     * 订单备注
     */
    private String orderRemark;
/**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createtime;
/**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatetime;
/**
     * 用户id
     */
    private Integer orderUserId;


}

