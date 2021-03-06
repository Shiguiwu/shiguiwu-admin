package com.shiguiwu.admin.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 基础传输类
 * @author: stone
 * @date: Created by 2020/1/7 19:45
 * @version: 1.0.0
 * @pakeage: com.shiguiwu.admin.dto
 */
@Data
public class BaseDto<T> implements Serializable {

    private static final long serialVersionUID = -6891844697615928401L;

    private Integer pageSize = 10;

    private Integer pageNum = 1;

    private T id;

    private String end;

    private String start;




}
