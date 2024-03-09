package com.test.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * (UserAddress)实体类
 *
 * @author makejava
 * @since 2023-11-16 14:37:48
 */
@Data
@TableName("user_address")
public class UserAddress implements Serializable {
    private static final long serialVersionUID = 170989720082153643L;

    @TableId
    private Integer uaddrId;
/**
     * 收货人名称
     */
    private String uaddrName;
/**
     * 收货人手机号
     */
    private String uaddrPhone;
/**
     * 省份/自治区/直辖市
     */
    private String uaddrProvince;
/**
     * 城市
     */
    private String uaddrCity;
/**
     * 区/县
     */
    private String uaddrDistrict;
/**
     * 详细地址
     */
    private String uaddrAddress;
/**
     * 地址标签
     */
    private String uaddrLabel;
/**
     * 是否默认
     */
    private Integer uaddrIsdefault;
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
    private Integer uaddrUserId;


}

