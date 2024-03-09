package com.test.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("spu")
public class Spu {

        @TableId
        private Long spuId;
        private String spuName;
        private String spuTitle;
        private String spuIntroduction;
        private String spuUnit;
        private byte spuSketchtype;
        private String spuSketch;
        private String spuSpecs;
        private byte spuSkutype;
        private byte spuStatus;
        @TableField(fill = FieldFill.INSERT)
        private LocalDateTime createtime;
        @TableField(fill = FieldFill.INSERT_UPDATE)
        private LocalDateTime updatetime;
        private String spuBrandId;
}