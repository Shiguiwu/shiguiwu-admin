package com.shiguiwu.admin.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @description: 角色数据
 * @author: stone
 * @date: Created by 2020/1/8 10:54
 * @version: 1.0.0
 * @pakeage: com.shiguiwu.admin.dto
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleDto extends BaseDto {

    private static final long serialVersionUID = -6399431397333922250L;

    private  String name;
}
