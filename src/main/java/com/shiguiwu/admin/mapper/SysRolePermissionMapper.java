package com.shiguiwu.admin.mapper;

import com.shiguiwu.admin.entity.SysRolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
 * @pakeage: com.shiguiwu.admin.mapper
 *
 *
 */
public interface SysRolePermissionMapper {
    int deleteByPrimaryKey(@Param("roleid") Integer roleid, @Param("permissionid") Integer permissionid);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    void batchAdd(List<SysRolePermission> permissionIds);

    void deleteByRoleId(@Param("roleId") Integer roleId);

    void batchDelete(@Param("list") List<Integer> integers);
}