package com.test.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2023-11-15 13:59:59
 */
@Data
@TableName("user")
public class User implements Serializable {
    private static final long serialVersionUID = -96055502519134033L;

    @TableId
    private Integer userId;
/**
     * 用户昵称
     */
    private String userName;
/**
     * 用户头像
     */
    private String userAvatarurl;
/**
     * 手机号
     */
    private String userPhone;
/**
     * 邮箱地址
     */
    private String userEmail;
/**
     * 登录密码
     */
    private String userPassword;
/**
     * 登录密码盐值
     */
    private String userSalt;
/**
     * 安全等级 0.待设置密码 1.待完善邮箱 2.安全
     */
    private Integer userSecuritylevel;
/**
     * 性别 0.未知 1.男 2.女
     */
    private Integer userGender;
/**
     * 生日
     */
    private Date userBirthday;
/**
     * 地区
     */
    private String userRegion;
/**
     * 个性签名
     */
    private String userMotto;
/**
     * 状态 0.正常 1.冻结
     */
    private Integer userStatus;
/**
     * 登录后的令牌
     */
    private String userToken;
/**
     * token过期时间
     */
    private LocalDateTime userExpiretime;
/**
     * 最后登录时间
     */
    private LocalDateTime userLoggedtime;
/**
     * 最后登录的设备ip地址
     */
    private String userLoggedip;
/**
     * 注册来源 0.pc平台 1.app平台 2.小程序平台 3.手机H5平台 4.管理平台
     */
    private Integer userCreatefrom;
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
    

}

