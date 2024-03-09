package com.test.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * (OrderDetails)实体类
 *
 * @author makejava
 * @since 2023-11-17 14:10:13
 */
@Data
@TableName("order_details")
public class OrderDetails implements Serializable {
    private static final long serialVersionUID = -97744314802558214L;

    @TableId
    private Integer id;

    @ApiParam("商品名称")
    private String odtailsName;

    @ApiParam("商品图片地址")
    private String odtailsThumburl;

    @ApiParam("商品价格")
    private Double odtailsPrice;

    @ApiParam("订购数量")
    private Integer odtailsCount;

    @ApiParam("小计金额")
    private Double odtailsAmount;

    @ApiParam("评价状态 0.待评价 1.已评价")
    private Integer odtailsScorestatus;
/**
     * 商品评分
     */
    private Object odtailsScore;
/**
     * 商品评论内容
     */
    private String odtailsComment;
/**
     * 分享的图片集合
     */
    private String odtailsPhotourls;
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
     * 关联的订单号
     */
    private Integer odtailsOrdernoId;

    @ApiParam("订购商品Sku")
    private String odtailsSku;

    @ApiParam("订购商品SpuId")
    private Long odtailsSpuId;


}

