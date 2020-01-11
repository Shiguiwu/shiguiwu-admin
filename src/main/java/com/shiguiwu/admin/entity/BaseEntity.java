package com.shiguiwu.admin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 基础类
 * @author: stone
 * @date: Created by 2020/1/5 21:49
 * @version: 1.0.0
 * @pakeage: com.shiguiwu.admin.entity
 */
@Data
public abstract class BaseEntity<ID extends Serializable> implements Serializable {


    private static final long serialVersionUID = 7476144739665991213L;


    private ID id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;



}
