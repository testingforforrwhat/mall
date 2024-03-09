package com.test.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * (Cart)实体类
 *
 * @author makejava
 * @since 2023-11-17 09:39:32
 */
@Data
@TableName("cart")
public class Cart implements Serializable {
    private static final long serialVersionUID = -45609377988778176L;


    @TableId
    private Integer carId;

    private Integer cartUserid;

    private Long cartSpuid;

    private Integer cartSkuid;

    private String cartName;

    private String cartThumburl;

    private Double cartPrice;

    private Integer cartCount;

    private Integer cartChecked;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createtime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatetime;

    private String cartSku;



}

