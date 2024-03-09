package com.test.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("sku")
public class Sku {

        @TableId
        private Long skuId;
        private long skuSpuId;
        private String skuName;
        private String skuSpuattr;
        private double skuPrice;
        private double skuOriginalprice;
        private double skuCostprice;
        private int skuQuantity;
        private int sortno;
        @TableField(fill = FieldFill.INSERT)
        private LocalDateTime createtime;
        @TableField(fill = FieldFill.INSERT_UPDATE)
        private LocalDateTime updatetime;
}