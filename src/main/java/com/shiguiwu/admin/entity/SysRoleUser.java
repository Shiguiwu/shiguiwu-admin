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

public class SysRoleUser {


    private static final long serialVersionUID = -7114694363942346075L;
    private Integer userid;

    private Integer roleid;
}