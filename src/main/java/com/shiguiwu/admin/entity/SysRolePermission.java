package com.shiguiwu.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @description: ${DESC}
 * @author: stone
 * @date: Created by 2020/1/5 21:32
 * @version: 1.0.0
 * @pakeage: com.shiguiwu.admin.entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRolePermission {


    private static final long serialVersionUID = 1948001204916046956L;
    private Integer roleid;

    private Integer permissionid;
}