package com.shiguiwu.admin.service;

import com.shiguiwu.admin.entity.SysRolePermission;
    /**
 * 
 * @description: ${DESC}
 *
 * 
 * @author: stone
 *
 * @date: Created by 2020/1/5 21:32
 * @version: 1.0.0
 * 
 * @pakeage: com.shiguiwu.admin.service
 *
 *
 */
public interface SysRolePermissionService{


    int deleteByPrimaryKey(Integer roleid,Integer permissionid);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

}
